package com.scuthnweb.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.scuthnweb.dao.interf.Pub_rec_needDao;
import com.scuthnweb.domain.Pub_rec_need;

public class Pub_rec_needDaoImpl  extends HibernateDaoSupport implements Pub_rec_needDao{

	@Override
	public void createPub_rec_need(Pub_rec_need prn) {
		//调用 Hibernate 模板存储对象
		this.getHibernateTemplate().save(prn);
	}


	@Override
	public List<Pub_rec_need> findByNeed_id(int need_id) {
		//命名查询过程 findByNeed_id_pub_rec_need_query
		return this.getSession().getNamedQuery("findByNeed_id_pub_rec_need_query")
				                .setInteger(0, need_id).list();
	}

	@Override
	public List<Pub_rec_need> findByNeed_reciever(int need_reciever) {
		//命名查询过程 findByNeed_reciever_pub_rec_need_query
		return this.getSession().getNamedQuery("findByNeed_reciever_pub_rec_need_query")
				                .setInteger(0, need_reciever).list();
	}

	@Override
	public void updatePub_rec_need( final Pub_rec_need prn ) {
		//调用 Hibernate 模板更新对象
		//this.getHibernateTemplate().update(prn);
		this.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session) throws HibernateException,
					SQLException {

						session.setFlushMode(FlushMode.AUTO); 

						session.update(prn); 

						session.flush(); 

						return null; 
					}
		});

	}

	@Override
	public List<Pub_rec_need> findPub_rec_needM(int need_id, int need_receiver) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deletePub_rec_need(final Pub_rec_need prn ) {
		//调用 Hibernate 模板删除对象
		//this.getHibernateTemplate().delete(prn);			
		this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						session.setFlushMode(FlushMode.AUTO);
						session.beginTransaction();

						Query query = session.createSQLQuery("DELETE FROM pub_rec_need WHERE pub_rec_need_id=?")
								.setInteger(0, prn.getPub_rec_need_id());
						query.executeUpdate();
						
						session.getTransaction().commit();
						return null; 
					}
				});	
	}


	@Override
	public Pub_rec_need findByNeed_idAndNeed_receiver(int need_id, int need_receiver) {
		//使用命名查询 findByNeed_idAndNeed_receiver_pub_rec_need_query
		List ls = this.getSession().getNamedQuery("findByNeed_idAndNeed_receiver_pub_rec_need_query")
				                .setInteger(0, need_id)
				                .setInteger(1, need_receiver)
				                .list();
		return ls.size()!=0?(Pub_rec_need)ls.get(0):null;
	}

}
