package com.scuthnweb.dao.impl;

import java.util.List;

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
	public void updateShare_link(Share_link sl) {
	    this.getHibernateTemplate().update(sl);
	}

	@Override
	public List<Share_link> findShare_linkM(int share_link_id, String share_link_name, String share_link_content,int share_link_publisher, int share_link_state) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void deleteShare_link(Share_link sl) {
	   this.getHibernateTemplate().delete(sl);
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
