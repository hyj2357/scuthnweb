package com.scuthnweb.service.interf;

import java.util.List;
import java.util.Map;

import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.Customer;

public interface AdminUserModule {
	
	/**
	 * Jun:查看待审核用户注册信息
	 * @validate no
	 * @intercept yes  
	 * @param customer_id
	 * @return
	 */
	public Customer checkRegInfo(int customer_id);
	
	/**
	 * Jun:查看所有注册信息
	 * @return
	 */
	public  Map<String,String> checkAllRegInfo();
	
	/**
	 * Jun：审核待审核用户注册信息
	 * @param message_publisher
	 * @param accept
	 * @return
	 */
	public boolean op_regInfo( Admin message_publisher,Customer cs, boolean accept);
    
	/**
	 * Jun: 查看所有用户信息
	 * @validate yes
	 * @intercept yes
	 * @return
	 */
	public Map<String,String> checkAllUserInfo();

	/**
	 * Jun: 查看用户信息
	 * @param customer_id
	 * @return
	 */
	public Customer checkUserInfo(int customer_id);

	/**
	 * Jun: 注销该ID指向的用户信息，并将customer_state设为1
	 * @validate no
	 * @intercept yes
	 * @param cs
	 * @return
	 */
    public  boolean logoutUserID( Customer cs);


    /**
     * Jun: 修改用户信息
     * @validate yes
     * @intercept yes
     * @param admin_id
     * @param customer_id
     * @param customer_name
     * @param customer_password
     * @param invite_code_Content
     * @param customer_sex
     * @param customer_grade
     * @param customer_major
     * @param customer_phone
     * @param customer_qq
     * @param customer_email
     * @param customer_room
     * @return
     */
    public  boolean modifyUserInfo( Admin ad,Customer    customer,String customer_name,
                                    String customer_password,int    customer_sex,String customer_grade, 
                                    String customer_major,String    customer_phone,String    customer_qq, 
                                    String customer_email,String customer_room);

    
}
