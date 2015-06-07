package com.scuthnweb.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.scuthnweb.dao.interf.Event_summaryDao;
import com.scuthnweb.domain.Event_summary;

public class Event_summaryDaoImpl  extends HibernateDaoSupport implements Event_summaryDao{

	@Override
	public void createEvent_summary(Event_summary es) {
		//
	    this.getHibernateTemplate().save(es);
	}


	@Override
	public List<Event_summary> findByEvent_id(int Event_id) {
		// TODO Auto-generated method stub
		return this.getSession().getNamedQuery("findByEvent_id_event_summary_query")
				                .setInteger(0, Event_id).list();
	}

	@Override
	public List<Event_summary> findByEvent_customer(int Event_customer) {
		// TODO Auto-generated method stub
		return this.getSession().getNamedQuery("findByEvent_customer_event_summary_query")
				                .setInteger(0, Event_customer).list();
	}


	@Override
	public List<Event_summary> findEvent_summaryM(int Event_id,
			int Event_customer) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteEvent_summary(final Event_summary es) {
		//调用 Hibernate 模板删除对象
		//this.getHibernateTemplate().delete(es);
		this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						session.setFlushMode(FlushMode.AUTO);
						session.beginTransaction();

						Query query = session.createSQLQuery("DELETE FROM event_summary WHERE event_summary_id=?")
								.setInteger(0, es.getEvent_summary_id());
						query.executeUpdate();
						
						session.getTransaction().commit();
						return null; 
					}
				});	
	}


	@Override
	public Event_summary findByEvent_idAndEvent_customer(int event_id,int event_customer) {
		List lst =  this.getSession().getNamedQuery("findByEvent_idAndEvent_customer_event_summary_query")
				                     .setInteger(0, event_id)
				                     .setInteger(1, event_customer).list();
		return lst.size()>0?(Event_summary)lst.get(0):null;
	}
}
