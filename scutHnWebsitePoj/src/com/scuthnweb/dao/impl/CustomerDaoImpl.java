package com.scuthnweb.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.scuthnweb.dao.interf.CustomerDao;
import com.scuthnweb.domain.Customer;




public class CustomerDaoImpl  extends HibernateDaoSupport implements CustomerDao{

	
	
	public Customer findByNameAndPassword(String customer_name, String customer_password){
	  return null;
	}

	
	public Customer createCustomer( Customer cs){
		  //将对应用户信息持久化至数据库
		  getHibernateTemplate().save(cs);
          return cs;
	}


	@Override
	public Customer findCustomerByCustomerEmail(String customer_email) {
		//使用命名查询 findCustomerByCustomerEmail_customer_query
		List ls = this.getSession().getNamedQuery("findCustomerByCustomerEmail_customer_query")
				                   .setString(0,customer_email)
				                   .list();
		return ls.size()>0?(Customer)ls.get(0):null;
	}

	@Override
	public Customer findCustomerByCustomerID(int customer_id) {
		//由 customer_id 查询 Customer
	    return (Customer)this.getHibernateTemplate().get(Customer.class, customer_id);
	}

	@Override
	public Customer findByIdAndPassword(int customer_id,String customer_password) {
		//命名查询 findByIdAndPassword_customer_query		
		List ls = getSession().getNamedQuery("findByIdAndPassword_customer_query")
				              .setInteger(0, customer_id)
				              .setString(1, customer_password)
				              .list();
		return ls.size()>0?(Customer)ls.get(0):null;
	}



	@Override
	public void updateCustomer(final Customer cs) {
		//更新持久化对象
		//this.getHibernateTemplate().update(cs);
		this.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session) throws HibernateException,
					SQLException {

						session.setFlushMode(FlushMode.AUTO); 

						session.update(cs); 

						session.flush(); 

						return null; 
					}
				});
	}



	@Override
	public List<Customer> findCustomerM(int customer_id, String customer_name,
			String customer_password, int customer_sex, String customer_email,
			String customer_grade, String customer_major, int customer_phone,
			int customer_qq, String customer_room, int customer_state) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Object[]> findAllCustomer(int hasAuthority) {
		List ls;
		if(hasAuthority==2)
			ls = getSession().getNamedQuery("findAllCustomer_customer_query").list();
		else
			ls = getSession().getNamedQuery("findAllCustomer_customer_query_authority")
			                 .setInteger(0, hasAuthority)
			                 .list();
		return ls;
	}


	@Override
	public void deleteCustomer(final Customer cs) {
		//this.getHibernateTemplate().delete(cs);
		this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						session.setFlushMode(FlushMode.AUTO);
						session.beginTransaction();

						Query query = session.createSQLQuery("DELETE FROM customer WHERE id=?")
								.setInteger(0, cs.getId());
						query.executeUpdate();
						
						session.getTransaction().commit();
						return null; 
					}
				});
	}


	@Override
	public List<Object[]> findIDByName(String name) {
		//使用命名查询 findIDByName_customer_query
		return this.getSession().getNamedQuery("findIDByName_customer_query")
		                        .setString(0, name).list();
	};
	
	
}
