package com.scuthnweb.service.impl;

import java.util.List;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.scuthnweb.dao.interf.CustomerDao;
import com.scuthnweb.dao.interf.MessageDao;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Customer;
import com.scuthnweb.service.interf.UserAdminModule;

public class UserAdminModuleImpl implements UserAdminModule{
	private CustomerDao          customerDao;
	private MessageDao           messageDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public boolean userFindPassWord(String customer_name, String customer_email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BaseCustomer userIDLogin(int customer_id, String customer_password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void userIDLogOut() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BaseCustomer userIDResgist(String customer_name,String customer_password, String invite_code_Content,
			                          int customer_sex, String customer_grade, String customer_major,
			                          int customer_phone, int customer_qq, String customer_email,
			                          String customer_room) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer userInfoCheck(int customer_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean userInfoModify(int customer_id, int customer_sex,String customer_grade, String customer_major, int customer_phone,
			                      int customer_qq, String customer_email, String customer_room) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean userPasswordChange(int customer_id,String customer_password, String customer_passwordM) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Integer> userFindID(String customer_name) {
		// TODO Auto-generated method stub
	
		return null;
	}

}
