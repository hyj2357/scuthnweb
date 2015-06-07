package com.scuthnweb.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.scuthnweb.dao.interf.AdminDao;
import com.scuthnweb.domain.Admin;

public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao{
    @Override
	public Admin findByNameAndPassword(String admin_name, String admin_password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin createAdmin(String name, String admin_password,int admin_state) {
		// TODO Auto-generated method stub
		Admin ad  = new Admin();
		ad.setName(name);
		ad.setAdmin_password(admin_password);
		ad.setAdmin_state(admin_state);
		this.getHibernateTemplate().save(ad);
		return ad;
	}


	@Override
	public Admin findAdminByAdminId(int admin_id) {
		//由 admin_id 查询 Admin
	    return (Admin)this.getHibernateTemplate().get(Admin.class, admin_id);
	}

	public void upDateAdmin( final Admin ad ){
		//更新管理员信息
		this.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session) throws HibernateException,
					SQLException {

						session.setFlushMode(FlushMode.AUTO); 

						session.update(ad); 

						session.flush(); 

						return null; 
					}
		});
	}

	@Override
	public List<Admin> findAdminM(int admin_id, String admin_name,String admin_password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin findByIdAndPassword(int id, String admin_password) {
		List<Admin>ad = this.getSession().getNamedQuery("findByIdAndPassword_admin_query")
				             .setInteger(0, id)
				             .setString(1, admin_password)
				             .list();
		return (ad.size()>0)?(Admin)ad.get(0):null;
	}

}
