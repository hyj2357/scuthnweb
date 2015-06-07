package com.scuthnweb.service.impl;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.scuthnweb.dao.interf.AdminDao;
import com.scuthnweb.dao.interf.CustomerDao;
import com.scuthnweb.dao.interf.EventDao;
import com.scuthnweb.dao.interf.Event_summaryDao;
import com.scuthnweb.dao.interf.MessageDao;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Event;
import com.scuthnweb.domain.Event_summary;
import com.scuthnweb.domain.Message;
import com.scuthnweb.service.interf.ActModule;

public class ActModuleImpl implements ActModule{
	private  CustomerDao customerDao;
	private  AdminDao    adminDao;
	private  EventDao    eventDao;
	private  Event_summaryDao event_summaryDao;
	private  MessageDao  messageDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	public void setEvent_summaryDao(Event_summaryDao event_summaryDao) {
		this.event_summaryDao = event_summaryDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public Event checkAct(int event_id) {
		return this.eventDao.findByEventId(event_id);
	}

	@Override
	public BaseCustomer checkUserInfo(int customer_id) {
		return customer_id>10?
			   this.customerDao.findCustomerByCustomerID(customer_id):
			   this.adminDao.findAdminByAdminId(customer_id);
	}

	@Override
	public Map<String, String> checkAllAct(boolean isAdmin) {
		Map<String,String> actMap = new HashMap<String,String>();
		List<Object[]> toActMap= isAdmin?this.eventDao.findAllEvents(2):this.eventDao.findAllEvents(0);
		for(Iterator itr=toActMap.iterator();itr.hasNext();){
			Object[] element = (Object[])itr.next();
			actMap.put((String)element[1], "checkActAction?event_id="+element[0]);
		}
		return actMap;
	}

	@Override
	public Map<String, String> checkTakePartIn(int event_customer) {
	     Map<String,String> evtMap = new HashMap<String,String>();
	     List<Event_summary> evtList= this.event_summaryDao.findByEvent_customer(event_customer);
	     for(Event_summary esum :evtList){
	    	 Event evt = esum.getEvent();
	    	 evtMap.put(evt.getEvent_name(), "checkActAction?event_id="+evt.getEvent_id());
	     }
	     return evtMap;
	}

	@Override
	public Map<String, String> checkPublish(int event_publisher) {
		Map<String,String> evtMap = new HashMap<String,String>();
	    List<Object[]> evtList = this.eventDao.findByEvent_publisher(event_publisher);
	    for(Object[] element:evtList){
	    	evtMap.put((String)element[1], "checkActAction?event_id="+element[0]);
	    }
		return evtMap;
	}

	@Override
	public Map<String, String> checkTakePartInUserInfo(int event_id,int event_publisher) {
	    Map<String,String> evtBsMap = new HashMap<String,String>();
	    if(this.eventDao.findByEvent_publisher(event_publisher)!=null){
	    	List<Event_summary> es = this.event_summaryDao.findByEvent_id(event_id);
	    	for(Event_summary esum:es){
	    		evtBsMap.put(esum.getEvent_customer().getName(), "checkUserInfo_actModuleAction?id="+esum.getEvent_customer().getId());
	    	}
	    }
	    return evtBsMap;
	}

	@Override
	public boolean offLineAct(Event evt, Admin ad) {
		if(evt!=null){ 
			evt.setEvent_state(1);
			this.eventDao.updateEvent(evt);
			Set<Event_summary> es = evt.getEvent_summary();
			for(Event_summary esum:es){
				//删除相关活动参与信息
				this.event_summaryDao.deleteEvent_summary(esum);
				//发送消息给活动参与者
				//告知活动已下线
				Message ms = new Message();
				ms.setMessage_publisher(ad);
				ms.setMessage_receiver(esum.getEvent_customer());
				ms.setMessage_title("网站活动下线消息");
				ms.setMessage_content("您参与的活动 ["+evt.getEvent_id()+":"+evt.getEvent_name()
						              +"] 已下线,如有相关活动问题,请联系管理员 "+ad.getId()+":"+ad.getName());
				ms.setMessage_state(0);
				this.messageDao.createMessage(ms);
			}
		    return true;			
		}
		else return false;
	}

	@Override
	public boolean onLineAct( Event evt,Admin ad ) {
		if(evt!=null){
		   evt.setEvent_state(0);
		   this.eventDao.updateEvent(evt);
		   return true;
		}
		else return false;
	}

	@Override
	public boolean createAct(String event_name, String event_intro, Date event_time, 
			                 Date event_endtime, int event_maxPeople, Admin event_publisher,int event_state) {
		
		Event evt = new Event();
		evt.setEvent_endtime(event_endtime);
		evt.setEvent_intro(event_intro);
		evt.setEvent_maxPeople(event_maxPeople);
		evt.setEvent_name(event_name);
		evt.setEvent_publisher(event_publisher);
		evt.setEvent_time(event_time);
		evt.setEvent_state(1);		
		
		this.eventDao.createEvent(evt);
		return true;
	}

	@Override
	public boolean deleteAct(Event evt, Admin ad) {
		// 删除之前先下线
		if(!this.offLineAct(evt, ad))
			return false;
		if(evt!=null&&evt.getEvent_publisher().getId()==ad.getId()){
			   this.eventDao.delete(evt);
		       return true;
		}
		else return false;
	}

	@Override
	public boolean takePartInAct(Event evt,BaseCustomer event_customer) {
	    
		if(this.event_summaryDao.findByEvent_idAndEvent_customer(evt.getEvent_id(), event_customer.getId())!=null)
	    	 return false;
	    else{
	    	Event_summary es = new Event_summary();
	    	es.setEvent(evt);
	    	es.setEvent_customer(event_customer);
	    	
	    	//如果参与人数已达到最大值
	    	//则无法参与活动
	    	int countNum = this.event_summaryDao.findByEvent_id(evt.getEvent_id()).size();
	    	if(countNum>=evt.getEvent_maxPeople())
	    		return false;
	    	
	    	this.event_summaryDao.createEvent_summary(es);
	    	return true;	    	
	    }
	}
    
	@Override
	public boolean exitAct( Event evt, BaseCustomer event_customer ) {
		Event_summary esum = this.event_summaryDao.findByEvent_idAndEvent_customer(evt.getEvent_id(), event_customer.getId());
		if(esum==null) 
			return false;
		else{
			this.event_summaryDao.deleteEvent_summary(esum);
			return true;			
		}
	}

	@Override
	public boolean modifyAct(Event evt, Admin ad, String event_name,String event_intro, Date event_time, Date event_endtime,int event_maxPeople) {
		//更新活动信息
		evt.setEvent_endtime(event_endtime);
		evt.setEvent_maxPeople(event_maxPeople);
		evt.setEvent_name(event_name);
		evt.setEvent_time(event_time);
		evt.setEvent_intro(event_intro);
		//持久化至数据库中
		this.eventDao.updateEvent(evt);
		
	    //如果当前活动处于上线状态
		if(evt.getEvent_state()==0){
		  Set<Event_summary> es = evt.getEvent_summary();
		  for(Event_summary esum:es){
			//发送消息给活动参与者
			//告知活动信息更新
			Message ms = new Message();
			ms.setMessage_publisher(ad);
			ms.setMessage_receiver(esum.getEvent_customer());
			ms.setMessage_title("网站活动信息更新");
			ms.setMessage_content("您参与的活动 ["+evt.getEvent_id()+":"+evt.getEvent_name()
					              +"] 相关信息更新, 请留意查看活动的最新信息，如有相关活动问题,请联系管理员 "+ad.getId()+":"+ad.getName());
			//设置消息为“未读”
			ms.setMessage_state(0);
			//发送消息
			this.messageDao.createMessage(ms);		
		  }
		}
		return true;
		   
	}
}
