package com.scuthnweb.service.interf;

import com.scuthnweb.domain.Admin;

public interface AdminAdModule {
	
	/**
	 * Jun:管理员登录
	 * @validate yes
	 * @interrupt no
	 * @param admin_id
	 * @param admin_password
	 * @return
	 */
	public Admin adminLogin( int admin_id, String admin_password);

	/**
	 * Jun:管理员查看个人信息
	 * @validate no
	 * @interrupt yes
	 * @param admin_id
	 * @return
	 */
	public Admin checkAdminInfo( int admin_id );
	
	
	/**
	 * Jun:管理员修改密码
	 * @validate yes
	 * @interrupt yes
	 * @param ad
	 * @param admin_password
	 * @param admin_passwordM
	 * @return
	 */
	public boolean modifyPassword(Admin ad, String admin_password, String admin_passwordM);
	
	
	/**
	 * Jun:管理员设置姓名
	 * @validate yes
	 * @interrupt no
	 * @param ad
	 * @param admin_nameM
	 * @return
	 */
	public void setName( Admin ad, String admin_nameM);
	
	/**
	 * Jun:这是用来测试框架整合效果的 组件方法
	 * @param admin_name
	 * @param admin_password
	 * @return
	 */
	public Admin addAdmin_test(String admin_name,String admin_password);

}
