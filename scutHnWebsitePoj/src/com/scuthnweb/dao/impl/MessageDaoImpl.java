package com.scuthnweb.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
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
		return this.getSession().getNamedQuery("findByMessage_publisher_message_query").setInteger(0, message_publisher).list();
	}


	@Override
	public List<Object[]> findByMessage_receiver(int message_receiver) {
		//调用命名查询过程
		return this.getSession().getNamedQuery("findByMessage_receiver_message_query").setInteger(0, message_receiver).list();
	}


	@Override
	public void update(final Message ms) {
		//this.getHibernateTemplate().update(ms);
			    	this.getHibernateTemplate().execute(
							new HibernateCallback() {

								public Object doInHibernate(Session session) throws HibernateException,
								SQLException {

									session.setFlushMode(FlushMode.AUTO); 

									session.update(ms); 

									session.flush(); 

									return null; 
								}
					});
	}


	@Override
	public void delete(final Message ms) {
		this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						session.setFlushMode(FlushMode.AUTO);
						session.beginTransaction();

						Query query = session.createSQLQuery("DELETE FROM message WHERE message_id=?")
								.setInteger(0, ms.getMessage_id());
						query.executeUpdate();
						
						session.getTransaction().commit();
						return null; 
					}
				});		
	};
}
