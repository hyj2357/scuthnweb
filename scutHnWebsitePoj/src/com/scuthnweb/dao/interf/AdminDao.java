package com.scuthnweb.dao.interf;

import java.util.List;

import com.scuthnweb.domain.Admin;

public interface AdminDao {
	/**
	 * Jun:通过姓名和密码查找管理员
	 * @param admin_name
	 * @param admin_password
	 * @return
	 * @deprecated
	 */
	public Admin findByNameAndPassword( String name, String admin_password);
	
	/**
	 * Jun:通过Id和密码查询管理员
	 * @param admin_name
	 * @param admin_password
	 * @return
	 */
	public Admin findByIdAndPassword( int id, String admin_password);
	
    
	/**
	 * Jun:创建一个管理员账号
	 * @param admin_name
	 * @param admin_password
	 * @return
	 */
	public Admin createAdmin( String admin_name, String admin_password , int admin_state);
	
	
	/**
	 * Jun:更新管理员信息
	 * @param ad
	 */
	public void upDateAdmin( Admin ad );
	
	 /**
     * Jun：条件式查询管理员信息
     * @param admin_id
     * @param admin_name
     * @param admin_password
     * @return
     * @deprecated
     */
	public List<Admin> findAdminM( int admin_id, String admin_name, String admin_password);

	/**
	 * Jun:根据管理员id查询管理员
	 * @param admin_id
	 * @return
	 */
	public Admin findAdminByAdminId( int admin_id );
	
	
   
}
