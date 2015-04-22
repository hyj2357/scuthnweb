package com.scuthnweb.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.scuthnweb.dao.interf.MessageDao;
import com.scuthnweb.domain.Message;

public class MessageDaoImpl  extends HibernateDaoSupport implements MessageDao{
    
	
	
	public void createMessage( Message message) {
		//将message对象persist到数据库中
		this.getHibernateTemplate().save(message);
	}


	@Override
	public Message findByMessage_ID(int message_id) {
		Message ms = (Message)this.getHibernateTemplate().get(Message.class, message_id);
	    //如果当前消息处于未读状态
		if(ms.getMessage_state()==0) {
	    	//将未读标志设置为已读
	    	ms.setMessage_state(1);
	    	this.getHibernateTemplate().update(ms);
	    }
	    return ms;
	}

	@Override
	public List<Message> findMessageM(int message_i, String message_content) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Object[]> findByMessage_publisher(int message_publisher) {
		//调用命名查询过程
		return this.getSession().getNamedQuery("findByMessage_publisher_message_query").list();
	}


	@Override
	public List<Object[]> findByMessage_receiver(int message_receiver) {
		//调用命名查询过程
		return this.getSession().getNamedQuery("findByMessage_receiver_message_query").list();
	};
}
