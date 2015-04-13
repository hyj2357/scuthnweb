package com.scuthnweb.service.impl;

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
	public Map<String, String> checkAllMessages(int message_receiver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message checkMessage(int message_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
