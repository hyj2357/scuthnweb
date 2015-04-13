package com.scuthnweb.dao.impl;

import java.util.List;

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
		return this.getSession().getNamedQuery("findByNeed_reciever_pub_rec_need_query")
				                .setInteger(0, need_id).list();
	}

	@Override
	public List<Pub_rec_need> findByNeed_reciever(int need_reciever) {
		//命名查询过程 findByNeed_reciever_pub_rec_need_query
		return this.getSession().getNamedQuery("findByNeed_reciever_pub_rec_need_query")
				                .setInteger(0, need_reciever).list();
	}

	@Override
	public void updatePub_rec_need( Pub_rec_need prn ) {
		//调用 Hibernate 模板更新对象
		this.getHibernateTemplate().update(prn);
	}

	@Override
	public List<Pub_rec_need> findPub_rec_needM(int need_id, int need_receiver) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deletePub_rec_need( Pub_rec_need prn ) {
		//调用 Hibernate 模板删除对象
		this.getHibernateTemplate().delete(prn);			
	}

}
