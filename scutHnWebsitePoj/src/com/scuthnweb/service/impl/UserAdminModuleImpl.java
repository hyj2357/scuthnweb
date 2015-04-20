package com.scuthnweb.service.impl;

import java.util.List;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.scuthnweb.dao.interf.AdminDao;
import com.scuthnweb.dao.interf.CustomerDao;
import com.scuthnweb.dao.interf.MessageDao;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Customer;
import com.scuthnweb.domain.Message;
import com.scuthnweb.service.interf.UserAdminModule;

public class UserAdminModuleImpl implements UserAdminModule{
	private CustomerDao          customerDao;
	private MessageDao           messageDao;
	private AdminDao             adminDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public boolean userFindPassword(int customer_id, String customer_email) {
		Message ms = new Message();
		Customer cs = this.customerDao.findCustomerByCustomerID(customer_id);
		Customer cs_1 = this.customerDao.findCustomerByCustomerEmail(customer_email);
		if(cs_1!=cs || cs_1==null )
			return false;
		ms.setMessage_title("用户找回密码消息");
		ms.setMessage_content("用户[id:"+customer_id+" "+cs.getName()+"]"+"请求找回密码.");
		ms.setMessage_publisher(cs);
		//设置消息为未读
		ms.setMessage_state(0);
		ms.setMessage_publisher(cs);
		//由id为 1~10 中随机抽取一名管理员审核新用户信息
		Admin ad = this.adminDao.findAdminByAdminId((int)(Math.random()*10));
		ms.setMessage_receiver(ad);
		this.messageDao.createMessage(ms);
		return true;
	}

	@Override
	public BaseCustomer userIDLogin(int customer_id, String customer_password) {		
		return this.customerDao.findByIdAndPassword(customer_id, customer_password);
	}

	@Override
	public void userIDLogOut() {
	}

	@Override
	public BaseCustomer userIDResgist(String customer_name,String customer_password,
			                          int customer_sex, String customer_grade, String customer_major,
			                          int customer_phone, int customer_qq, String customer_email,
			                          String customer_room) {
		Customer cs = new Customer();
		cs.setCustomer_email(customer_email);
		cs.setCustomer_grade(customer_grade);
		cs.setCustomer_major(customer_major);
		cs.setCustomer_password(customer_password);
		cs.setCustomer_phone(customer_phone);
		cs.setCustomer_qq(customer_qq);
		cs.setCustomer_room(customer_room);
		cs.setCustomer_sex(customer_sex);
		//设置新用户无相应权限
		cs.setCustomer_state(1);
		Message ms = new Message();
		ms.setMessage_title("新用户注册信息");
		ms.setMessage_content("新用户[name:"+cs.getName()+"]"+"请求注册;");
		ms.setMessage_publisher(cs);		
		ms.setMessage_state(0);		
		//由id为 1~10 中随机抽取一名管理员审核新用户信息
		Admin ad = this.adminDao.findAdminByAdminId((int)(Math.random()*10));
		ms.setMessage_receiver(ad);
		
		this.messageDao.createMessage(ms);
		this.customerDao.createCustomer(cs);
		return cs;
	}

	@Override
	public Customer userInfoCheck(int customer_id) {
		return this.customerDao.findCustomerByCustomerID(customer_id);
	}

	@Override
	public boolean userInfoModify(Customer cs, int customer_sex,String customer_grade, String customer_major, int customer_phone,
			                      int customer_qq, String customer_email, String customer_room) {
		 
		 cs.setCustomer_email(customer_email); 
		 cs.setCustomer_grade(customer_grade);
		 cs.setCustomer_major(customer_major);
		 cs.setCustomer_phone(customer_phone);
		 cs.setCustomer_qq(customer_qq);
		 cs.setCustomer_room(customer_room);
		 cs.setCustomer_sex(customer_sex);
		 //更新用户信息
		 this.customerDao.updateCustomer(cs);
		 return true;
	}

	@Override
	public boolean userPasswordChange(int customer_id,String customer_password, String customer_passwordM) {
		
		Customer cs = this.customerDao.findByIdAndPassword(customer_id, customer_password);
		//如果用户名与密码不匹配
		//返回false
		if(cs == null)
			return false;
		//修改用户密码
		cs.setCustomer_password(customer_passwordM);
		//更新用户信息
		this.customerDao.updateCustomer(cs);
		return true;
	}

	@Override
	public List<Integer> userFindID(String name) {
		 //
		 return (List)this.customerDao.findIDByName(name);
	}

}
