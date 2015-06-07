package com.scuthnweb.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.scuthnweb.dao.interf.Share_linkDao;
import com.scuthnweb.domain.Share_link;

public class Share_linkDaoImpl extends HibernateDaoSupport  implements Share_linkDao{

	@Override
	public void createShare_link(Share_link sl) {
		this.getHibernateTemplate().save(sl);
	}



	@Override
	public Share_link findByShare_link_id(int share_link_id) {
		return (Share_link)this.getHibernateTemplate().get(Share_link.class, share_link_id);
	}

	@Override
	public void updateShare_link(final Share_link sl) {
		
	    //this.getHibernateTemplate().update(sl);
		this.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session) throws HibernateException,
					SQLException {

						session.setFlushMode(FlushMode.AUTO); 

						session.update(sl); 

						session.flush(); 

						return null; 
					}
		});

	}

	@Override
	public List<Share_link> findShare_linkM(int share_link_id, String share_link_name, String share_link_content,int share_link_publisher, int share_link_state) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void deleteShare_link(final Share_link sl) {
	   //this.getHibernateTemplate().delete(sl);
		this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						session.setFlushMode(FlushMode.AUTO);
						session.beginTransaction();

						Query query = session.createSQLQuery("DELETE FROM share_link WHERE share_link_id=?")
								.setInteger(0, sl.getShare_link_id());
						query.executeUpdate();
						
						session.getTransaction().commit();
						return null; 
					}
				});		
	}



	@Override
	public List<Object[]> findAllShare_link(int share_link_state) {	
		return this.getSession().getNamedQuery("findAllShare_share_link_query_state")
				                  .setInteger(0, share_link_state)
				                  .list();
	}



	@Override
	public List<Object[]> findByShare_link_publisher(int share_link_publisher) {
		return this.getSession().getNamedQuery("findByShare_link_publisher_share_link_query")
				                .setInteger(0, share_link_publisher).list();
	}

}
