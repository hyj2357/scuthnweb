package com.scuthnweb.service.impl;

import java.util.Map;

import com.scuthnweb.dao.interf.AdminDao;
import com.scuthnweb.dao.interf.CustomerDao;
import com.scuthnweb.dao.interf.MessageDao;
import com.scuthnweb.dao.interf.NeedDao;
import com.scuthnweb.dao.interf.Pub_rec_needDao;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Need;
import com.scuthnweb.service.interf.NeedModule;

public class NeedModuleImpl implements NeedModule{
	private Pub_rec_needDao     pub_rec_needDao;
	private MessageDao          messageDao;
	private NeedDao             needDao;
	private CustomerDao         customerDao;
	private AdminDao            adminDao;
	
	public void setPub_rec_needDao(Pub_rec_needDao pub_rec_needDao) {
		this.pub_rec_needDao = pub_rec_needDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	public void setNeedDao(NeedDao needDao) {
		this.needDao = needDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public boolean acceptNeed(Need need, BaseCustomer need_reciever) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancelAcNeed(Need need, BaseCustomer need_reciever) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Need checkNeed(int need_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> checkAllNeed(boolean isAdmin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> checkPostNeed(BaseCustomer need_publisher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> checkACNeed(BaseCustomer need_reciever) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> checkAcNeedUserInfo(Need need, BaseCustomer need_publisher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delNeed(Need need, BaseCustomer need_publisher) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean postNeed(String need_name, String need_content,BaseCustomer need_publisher) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyNeed(int need_id, String need_name, String need_content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setNeedSucc(Need need, BaseCustomer need_publisher) {
		// TODO Auto-generated method stub
		return false;
	}

}
