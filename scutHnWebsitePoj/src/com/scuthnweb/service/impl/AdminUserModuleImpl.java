package com.scuthnweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scuthnweb.dao.interf.CustomerDao;
import com.scuthnweb.dao.interf.MessageDao;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.Customer;
import com.scuthnweb.domain.Message;
import com.scuthnweb.service.interf.AdminUserModule;

public class AdminUserModuleImpl implements AdminUserModule{
	private CustomerDao        customerDao;
	private MessageDao         messageDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public Customer checkRegInfo(int customer_id) {
		return this.customerDao.findCustomerByCustomerID(customer_id);
	}

	@Override
	public Map<String, String> checkAllRegInfo() {
		Map csMap = new HashMap<String,String>();
		List<Object[]> lst = this.customerDao.findAllCustomer(1);
		for(Object[] itr:lst){
			csMap.put((String)itr[1], "checkRegInfoAction?id="+(String)itr[0]);
		}
		return csMap;
	}

	@Override
	public boolean op_RegInfo(Admin message_publisher, Customer cs, boolean accept) {
		//审核未通过则自动删除未通过账号
		if(accept){
			cs.setCustomer_state(0);
			this.customerDao.updateCustomer(cs);
			Message ms = new Message();
			ms.setMessage_title("账号审核通过信息");
			ms.setMessage_content( "您的账号已通过管理员(id:"+message_publisher.getId()+")"
					              +"审核通过,您已拥有普通用户权限，欢迎加入本站！");
			ms.setMessage_publisher(message_publisher);
			ms.setMessage_receiver(cs);
			ms.setMessage_state(0);
			//推送消息
			this.messageDao.createMessage(ms);
		}
		else 
			this.customerDao.deleteCustomer(cs);
		return true;
	}

	@Override
	public Map<String, String> checkAllUserInfo(int customer_id, String customer_name, int customer_sex, String customer_grade,
			                                    String customer_major, int customer_phone, int customer_qq, String customer_email, String customer_room) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer checkUserInfo(int customer_id) {
		
		return null;
	}

	@Override
	public boolean logoutUserID(Customer cs) {
		this.customerDao.deleteCustomer(cs);
		return false;
	}

	@Override
	public boolean modifyUserInfo(Admin admin, Customer customer,String customer_name, String customer_password, int customer_sex,String customer_grade, String customer_major, int customer_phone,int customer_qq, String customer_email, String customer_room) {
		// TODO Auto-generated method stub
		return false;
	}

}
