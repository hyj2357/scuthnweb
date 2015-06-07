package com.scuthnweb.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.scuthnweb.dao.interf.EventDao;
import com.scuthnweb.domain.Event;

public class EventDaoImpl extends HibernateDaoSupport  implements EventDao{

	@Override
	public Event createEvent(Event evt) {
		//将Event对象持久化到数据库
		this.getHibernateTemplate().save(evt);
		return evt;
	}


	@Override
	public Event findByEventId(int event_id) {
		 //由 event_id 查询 Event
	     return (Event)this.getHibernateTemplate().get(Event.class, event_id);
	}

	@Override
	public void updateEvent(final Event evt) {
		 //更新Event对象信息
	     //this.getHibernateTemplate().update(evt);
		this.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session) throws HibernateException,
					SQLException {

						session.setFlushMode(FlushMode.AUTO); 

						session.update(evt); 

						session.flush(); 

						return null; 
					}
		});
	}

	/**
	 * ＊＊＊＊＊＊＊＊测试当中＊＊＊＊＊＊＊＊
	 */
	@Override
	public List<Event> findEventM(int event_id, String event_name, String event_intro,
			Date event_time, Date event_endtime, int event_maxPeople,
			int event_publisher, int event_state) {
		/**
		 * 
		 */
		Event to = new Event();
		to.setEvent_name("2014年华南理工大学海南同乡会冬游活动");
		to.setEvent_id(10000000);
		List<Event> de = new ArrayList<Event>();
		return de;
	}


	@Override
	public List<Object[]> findAllEvents(int event_state) {
		List ls;
		if(event_state==2)
		      ls = this.getSession().getNamedQuery("findAllEvents_event_query").list();
		else  ls = this.getSession().getNamedQuery("findAllEvents_event_query_state")
		                            .setInteger(0, event_state)
		                            .list();
		return ls;
	}


	@Override
	public List<Object[]> findByEvent_publisher(int event_publisher) {
		return this.getSession().getNamedQuery("findByEvent_publisher_event_query")
				                .setInteger(0, event_publisher)
				                .list();
	}


	@Override
	public void delete(final Event evt) {
		//
		//this.getHibernateTemplate().delete(evt);
		this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						session.setFlushMode(FlushMode.AUTO);
						session.beginTransaction();

						Query query = session.createSQLQuery("DELETE FROM event WHERE event_id=?")
								.setInteger(0, evt.getEvent_id());
						query.executeUpdate();
						
						session.getTransaction().commit();
						return null; 
					}
				});		
	}
}