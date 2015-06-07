package com.scuthnweb.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.scuthnweb.dao.interf.NeedDao;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Need;

public class NeedDaoImpl  extends HibernateDaoSupport implements NeedDao{

	@Override
	public Need createNeed(Need nd) {
		//将 nd 持久化到数据库
		this.getHibernateTemplate().save(nd);
		return nd;
	}


	@Override
	public Need findByNeed_ID(int need_id) {
		return (Need)this.getHibernateTemplate().get(Need.class, need_id);
	}

	@Override
	public List<Need> findByNeed_publisher(int need_publisher) {
		//使用命名查询 findByNeed_publisher_need_query
		return this.getSession().getNamedQuery("findByNeed_publisher_need_query")
				                   .setInteger(0, need_publisher)
				                   .list();
		
	}

	@Override
	public void updateNeed(final Need nd) {
		//更新需求信息
		//this.getHibernateTemplate().update(nd);
		this.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session) throws HibernateException,
					SQLException {

						session.setFlushMode(FlushMode.AUTO); 

						session.update(nd); 

						session.flush(); 

						return null; 
					}
		});
	
	}

	@Override
	public List<Need> findNeedM(int need_id, String need_name,
			String need_content, int need_publisher, int need_state) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteNeed(final Need nd) {
		//调用 Hibernate 模板删除对象数据
		//this.getHibernateTemplate().delete(nd);
		this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						session.setFlushMode(FlushMode.AUTO);
						session.beginTransaction();

						Query query = session.createSQLQuery("DELETE FROM need WHERE need_id=?")
								.setInteger(0, nd.getNeed_id());
						query.executeUpdate();
						
						session.getTransaction().commit();
						return null; 
					}
				});			
	}


	@Override
	public List<Object[]> findAllNeed(int need_state) {
		//
		if(need_state==2)
			 return this.getSession().getNamedQuery("findAllNeed_need_query").list();
		else return this.getSession().getNamedQuery("findAllNeed_need_query_state")
				                     .setInteger(0, need_state).list();
    }

}
