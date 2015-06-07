package com.scuthnweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scuthnweb.dao.interf.MessageDao;
import com.scuthnweb.domain.Message;
import com.scuthnweb.service.interf.MessageModule;

public class MessageModuleImpl implements MessageModule{
    private MessageDao messageDao;
    
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}


	@Override
	public Message checkMessage(int message_id) {
		Message ms =  this.messageDao.findByMessage_ID(message_id);
		//如果消息为未读状态
		if(ms.getMessage_state()==0){
			//设置成已读状态
			ms.setMessage_state(1);
			this.messageDao.update(ms);
		}
		return ms;			
	}


	@Override
	public Map<String, String> checkReceiveMessages(int message_receiver) {
		Map<String,String> messageMap = new HashMap<String,String>();
		List<Object[]> ls = this.messageDao.findByMessage_receiver(message_receiver);
		for(Object[] itr:ls){
			String flag = ((Integer)itr[2])==0?" [ 新消息 ]":"";
			messageMap.put((String)itr[1]+flag, "checkMessageAction?message_id="+itr[0]);
		}
		return messageMap;
	}


	@Override
	public Map<String, String> checkPublishMessages(int message_publisher) {
		Map<String,String> messageMap = new HashMap<String,String>();
		List<Object[]> ls = this.messageDao.findByMessage_publisher(message_publisher);
		for(Object[] itr:ls)
			messageMap.put((String)itr[1], "checkMessageAction?message_id="+itr[0]);
		return messageMap;
	}

}
