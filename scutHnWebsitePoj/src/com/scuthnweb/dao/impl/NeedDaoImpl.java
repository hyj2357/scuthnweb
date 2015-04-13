package com.scuthnweb.dao.impl;

import java.util.List;

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
	public void updateNeed(Need nd) {
		//更新需求信息
		this.getHibernateTemplate().update(nd);
	}

	@Override
	public List<Need> findNeedM(int need_id, String need_name,
			String need_content, int need_publisher, int need_state) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteNeed(Need nd) {
		//调用 Hibernate 模板删除对象数据
		this.getHibernateTemplate().delete(nd);
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
