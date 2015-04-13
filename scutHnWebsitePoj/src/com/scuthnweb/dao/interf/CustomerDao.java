package com.scuthnweb.dao.interf;

import java.sql.SQLException;
import java.util.List;

import com.scuthnweb.domain.Customer;





public interface CustomerDao {
	
	/**
	 * Jun:
	 * @Param customer_name
	 * @param customer_password
	 * @return
	 * @deprecated
	 */
	public    Customer findByNameAndPassword( String customer_name, String customer_password ) throws SQLException;
	
	/**
	 * Jun:通过ID与密码查找用户
	 * @param customer_id
	 * @param customer_password
	 * @return
	 */
	public    Customer findByIdAndPassword(int customer_id, String customer_password );
	
	/**
	 * Jun:创建一个用户账号
	 * @param cs
	 * @return
	 */
    public    Customer createCustomer( Customer cs);
    
    
    
  /**
   * Jun:更新用户信息
   * @param cs
   * @return
   */
    public    void updateCustomer(Customer cs);
    
    
    /**
     * Jun:
     * @param customer_id
     * @param customer_name
     * @param customer_password
     * @param customer_sex
     * @param customer_email
     * @param customer_grade
     * @param customer_major
     * @param customer_phone
     * @param customer_qq
     * @param customer_room
     * @param customer_state
     * @return
     * @deprecated
     */
    public  List<Customer> findCustomerM( int    customer_id,
                                   String customer_name,
                                   String customer_password,
                                   int    customer_sex,
                                   String customer_email, 
                                   String customer_grade,
                                   String customer_major,
                                   int    customer_phone,
                                   int    customer_qq,
                                   String customer_room,
                                   int    customer_state);
    
    
    /**
     * Jun:通过邮箱查询用户
     * @param customer_email
     * @return
     */
    public    Customer   findCustomerByCustomerEmail( String customer_email );
    
    
    /**
     * Jun:通过用户ID查询用户
     * @param customer_id
     * @return
     */
    public  Customer   findCustomerByCustomerID( int   customer_id);
    
    /**
     * Jun:查看所有用户列表    
     * @param hasAuthority 0表示查看有权限用户，1表示查看无权限用户，2表示查看所有用户
     * @return
     */
    public  List<Object[]> findAllCustomer(int hasAuthority);
    
    /**
     * Jun:删除用户
     * @param cs
     */
    public void deleteCustomer(Customer cs);
}
