package com.scuthnweb.service.interf;

import java.util.List;
import java.util.Map;

import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Need;

public interface NeedModule {
	/**
	 * Jun: 用户接受需求
	 * @validate  no
	 * @intercept yes
	 * @param need_id
	 * @param need_reciever
	 * @return
	 */
	public boolean acceptNeed( Need need, BaseCustomer need_reciever );
	
	
	/**
	 * Jun:取消接受需求
	 * @validate  no
	 * @intercept yes
	 * @param need_id
	 * @param need_reciever
	 * @return
	 */
	public boolean cancelAcNeed( Need need, BaseCustomer need_reciever );
	
	/**
	 * Jun: 根据need_id查找对应的需求信息
	 * @param need_id
	 * @return
	 */
	public Need  checkNeed(int need_id);
	
	/**
	 * Jun:查看所有需求
	 * @validate  no
	 * @intercept no
	 * @param isAdmin 
	 * @return
	 */
	public Map<String,String> checkAllNeed(boolean isAdmin);
	
	
	/**
	 * Jun:查看发布的需求
	 * @validate  no
	 * @intercept yes 
	 * @param need_publisher
	 * @return
	 */
	public Map<String,String> checkPostNeed( BaseCustomer need_publisher );
	
	
	/**
	 * Jun:查看用户个人接受的需求
	 * @validate  no
	 * @intercept yes 
	 * @param need_reciever
	 * @return
	 */
	public Map<String,String> checkAcNeed( BaseCustomer need_reciever );
	
	
	/**
	 * Jun:查看接受需求的用户相关信息
	 * @validate  no
	 * @intercept yes 
	 * @param need_id
	 * @param need_publisher
	 * @return
	 */
	public Map<String,String> checkAcNeedUserInfo( Need need, BaseCustomer need_publisher);
	
	/**
	 * Jun:查看用户信息
	 * @param id
	 * @return
	 */
	public BaseCustomer checkUserInfo(int id);

	/**
	 * Jun: 删除需求
	 * @validate  no
	 * @intercept yes
	 * @param need_id
	 * @return
	 */
	public boolean delNeed(  Need need_id , BaseCustomer need_publisher);
	
	
	/**
	 * Jun: 发布需求
	 * @validate yes
	 * @intercept yes
	 * @param need_name
	 * @param need_content
	 * @param need_publisher
	 * @return
	 */
	public boolean postNeed( String need_name, String need_content, BaseCustomer need_publisher );
	
	
	/**
	 * Jun: 修改已发布的需求
	 * @validate yes
	 * @intercept yes
	 * @param need
	 * @param need_name
	 * @param need_content
	 * @return
	 */
	public boolean modifyNeed( Need need_id, BaseCustomer cs,String need_name, String need_content);
	
	
	/**
	 * Jun: 设置需求为已解决
	 * @validate yes
	 * @intercept yes
	 * @param need_id
	 * @return
	 */
	public boolean setNeedSucc( Need need_id ,BaseCustomer need_publisher);
	
}
