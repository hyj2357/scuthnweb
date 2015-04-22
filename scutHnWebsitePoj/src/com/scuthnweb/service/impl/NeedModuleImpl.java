package com.scuthnweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scuthnweb.dao.interf.AdminDao;
import com.scuthnweb.dao.interf.CustomerDao;
import com.scuthnweb.dao.interf.MessageDao;
import com.scuthnweb.dao.interf.NeedDao;
import com.scuthnweb.dao.interf.Pub_rec_needDao;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Message;
import com.scuthnweb.domain.Need;
import com.scuthnweb.domain.Pub_rec_need;
import com.scuthnweb.service.interf.NeedModule;

public class NeedModuleImpl implements NeedModule{
	private Pub_rec_needDao     pub_rec_needDao;
	private MessageDao          messageDao;
	private NeedDao             needDao;
	private CustomerDao         customerDao;
	private AdminDao             adminDao;
	
	public void setPub_rec_needDao(Pub_rec_needDao pub_rec_needDao) {
		this.pub_rec_needDao = pub_rec_needDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	public void setNeedDao(NeedDao needDao) {
		this.needDao = needDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public boolean acceptNeed(Need need, BaseCustomer need_receiver) {
		Pub_rec_need prn = new Pub_rec_need();
		prn.setNeed(need);
		prn.setNeed_receiver(need_receiver);
		this.pub_rec_needDao.createPub_rec_need(prn);
		
		Message ms = new Message();
		ms.setMessage_title("用户需求接收消息");
		ms.setMessage_content("您的需求[id:"+need.getNeed_id()+" "+need.getNeed_name()+"]"
				              + "已被用户[id:"+need_receiver.getId() +" "+need_receiver.getName()
				              + "接受,可通过需求管理界面查看该用户信息联系该用户.");
		ms.setMessage_publisher(need_receiver);
		ms.setMessage_receiver(need.getNeed_publisher());
		//设置消息为未读状态
		ms.setMessage_state(0);
		//推送消息
		this.messageDao.createMessage(ms);
		//接受需求
		this.pub_rec_needDao.createPub_rec_need(prn);
		return true;
	}

	@Override
	public boolean cancelAcNeed(Need need, BaseCustomer need_receiver) {
		//检测该用户是否有接受该需求
		Pub_rec_need prn = this.pub_rec_needDao.findByNeed_idAndNeed_receiver(need.getNeed_id(), need_receiver.getId());
		
		if(prn!=null){
				Message ms = new Message();
				ms.setMessage_title("用户需求取消消息");
				ms.setMessage_content("您的需求[id:"+need.getNeed_id()+" "+need.getNeed_name()+"]"
						              + "已被用户[id:"+need_receiver.getId() +" "+need_receiver.getName()
						              + "取消接受.");
				ms.setMessage_publisher(need_receiver);
				ms.setMessage_receiver(need.getNeed_publisher());
				//设置消息为未读状态
				ms.setMessage_state(0);
				//推送消息
				this.messageDao.createMessage(ms);			
				//取消接受需求
				this.pub_rec_needDao.deletePub_rec_need(prn);	
				return true;
		}
		return false;
	}

	@Override
	public Need checkNeed(int need_id) {
		return this.needDao.findByNeed_ID(need_id);
	}

	@Override
	public Map<String, String> checkAllNeed(boolean isAdmin) {
		Map<String,String> needMap = new HashMap<String,String>();		
		List<Object[]> ls = isAdmin?this.needDao.findAllNeed(2):this.needDao.findAllNeed(0);
	    for(Object[] itr:ls){
	    	needMap.put((String)itr[1], "CheckNeedAction?need_id="+itr[0]);
	    }
		return needMap;
	}

	@Override
	public Map<String, String> checkPostNeed(BaseCustomer need_publisher) {
		Map<String,String> needMap = new HashMap<String,String>();		
		List<Need> ls = this.needDao.findByNeed_publisher(need_publisher.getId());
	    for(Need itr:ls){
	    	needMap.put(itr.getNeed_name(), "CheckNeedAction?need_id="+itr.getNeed_id());
	    }
		return needMap;
	}

	@Override
	public Map<String, String> checkAcNeed(BaseCustomer need_receiver) {
		List<Pub_rec_need> prnList = this.pub_rec_needDao.findByNeed_reciever(need_receiver.getId()); 
		Map<String,String> needMap = new HashMap<String,String>();
		for(Pub_rec_need prn :prnList){
			needMap.put(prn.getNeed().getNeed_name(), "CheckNeedAction?need_id="+prn.getNeed().getNeed_id());
		}
		return needMap;
    }

	@Override
	public Map<String, String> checkAcNeedUserInfo(Need need, BaseCustomer need_publisher) {
		//如果当前检测该用户非该需求发布者
		//返回空值
		if(need.getNeed_publisher()!=need_publisher)
			return null;
		Map<String,String> csMap = new HashMap<String,String>();
		List<Pub_rec_need> prnList = this.pub_rec_needDao.findByNeed_id(need.getNeed_id());
		for(Pub_rec_need prn :prnList){
			csMap.put(prn.getNeed_receiver().getName(), "CheckUserInfoAction?id="+prn.getNeed_receiver().getId());
		}
		return csMap;
	}
    
	public BaseCustomer checkUserInfo(int id){
		//管理员账号ID则查询管理员
		//否则查询普通用户
		return id>1000000000?
			   this.customerDao.findCustomerByCustomerID(id):
			   this.adminDao.findAdminByAdminId(id);
		
	}
	
	@Override
	public boolean delNeed(Need need, BaseCustomer need_publisher) {
		//如果当前检测该用户非该需求发布者
		//返回空值
		if(need.getNeed_publisher()!=need_publisher)
			return false;		
		//发送消息通知接受该需求者需求已被删除
		List<Pub_rec_need> prnList = this.pub_rec_needDao.findByNeed_id(need.getNeed_id()); 
		for( Pub_rec_need prn:prnList){
			Message ms = new Message();
			ms.setMessage_title("接受需求删除消息");
			ms.setMessage_content("很抱歉,您接受的需求[id:"+need.getNeed_id()+" "+need.getNeed_name()+"]"+
					              "已被发布者或管理员删除.如有问题请联系管理员.");
			ms.setMessage_publisher(need_publisher);
			ms.setMessage_receiver(prn.getNeed_receiver());
			//设置消息为未读状态
			ms.setMessage_state(0);
			//推送消息
			this.messageDao.createMessage(ms);						
		}
		//删除需求
		this.needDao.deleteNeed(need);
		return true;
	}

	@Override
	public boolean postNeed(String need_name, String need_content,BaseCustomer need_publisher) {
		Need nd = new Need();
		nd.setNeed_name(need_name);
		nd.setNeed_content(need_content);
		//需求初始状态为未解决
		nd.setNeed_state(0);
		nd.setNeed_publisher(need_publisher);
		//创建并发布需求
		this.needDao.createNeed(nd);
		return true;
	}

	@Override
	public boolean modifyNeed(Need need, BaseCustomer cs, String need_name, String need_content) {
		//如果当前检测该用户非该需求发布者
		//返回空值
		if(need.getNeed_publisher()!=cs)
			return false;		
		need.setNeed_name(need_name);
		need.setNeed_content(need_content);
		//修改后的需求状态为未解决
		need.setNeed_state(0);
		//发送消息通知接受该需求者需求信息已被修改
		List<Pub_rec_need> prnList = this.pub_rec_needDao.findByNeed_id(need.getNeed_id()); 
			for( Pub_rec_need prn:prnList){
					Message ms = new Message();
					ms.setMessage_title("接受需求变更消息");
					ms.setMessage_content("您接受的需求[id:"+need.getNeed_id()+" "+need.getNeed_name()+"]"+
							              "已被发布者或管理员修改变更相关信息.如有问题请联系需求发布者或管理员.");
					ms.setMessage_publisher(cs);
					ms.setMessage_receiver(prn.getNeed_receiver());
					//设置消息为未读状态
					ms.setMessage_state(0);
					//推送消息
					this.messageDao.createMessage(ms);						
		}
		//更新需求信息
		this.needDao.updateNeed(need);
		return true;
	}

	@Override
	public boolean setNeedSucc(Need need, BaseCustomer need_publisher) {
		//如果当前检测该用户非该需求发布者
		//返回空值
		if(need.getNeed_publisher()!=need_publisher)
			return false;		
		//修改需求状态
		need.setNeed_state(1);
		//发送消息通知接受该需求者需求信息已被修改		
		List<Pub_rec_need> prnList = this.pub_rec_needDao.findByNeed_id(need.getNeed_id()); 
		for( Pub_rec_need prn:prnList){
				Message ms = new Message();
				ms.setMessage_title("接受需求已解决消息");
				ms.setMessage_content("您接受的需求[id:"+need.getNeed_id()+" "+need.getNeed_name()+"]"+
						              "发布者已成功解决.感谢您的参与!");
				ms.setMessage_publisher(need_publisher);
				ms.setMessage_receiver(prn.getNeed_receiver());
				//设置消息为未读状态
				ms.setMessage_state(0);
				//推送消息
				this.messageDao.createMessage(ms);						
	    }	
		//更新需求信息
		this.needDao.updateNeed(need);
		return true;
	}

}
