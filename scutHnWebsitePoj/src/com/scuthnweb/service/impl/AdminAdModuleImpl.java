package com.scuthnweb.service.impl;

import com.scuthnweb.dao.interf.AdminDao;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.service.interf.AdminAdModule;

public class AdminAdModuleImpl implements AdminAdModule{
	private AdminDao adminDao;

	@Override
	public Admin adminLogin(int admin_id, String admin_password) {
		return adminDao.findByIdAndPassword(admin_id, admin_password);
	}

	@Override
	public Admin checkAdminInfo(int admin_id) {
		return adminDao.findAdminByAdminId(admin_id);
	}

	@Override
	public boolean modifyPassword(Admin ad, String admin_password,String admin_passwordM) {
		//如果原密码错误
		//返回false
		if(!ad.getAdmin_password().equals(admin_password)) 
			return false;
		else {
		    ad.setAdmin_password(admin_passwordM);
			adminDao.upDateAdmin(ad);
			return true;
		}
	}

	@Override
	public void setName(Admin ad, String admin_nameM) {
		//设置管理员名称
		ad.setName(admin_nameM);
		//将修改保存进数据库中
		adminDao.upDateAdmin(ad);
	}
    
	public Admin addAdmin_test(String admin_name,String admin_password){
		return this.adminDao.createAdmin(admin_name, admin_password, 0);
	}
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

}
