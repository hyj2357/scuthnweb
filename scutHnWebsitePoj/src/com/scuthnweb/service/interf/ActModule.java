package com.scuthnweb.service.interf;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Event;

public interface ActModule {
	
	/**
	 * Jun: 查看活动信息
	 * @param event_id
	 * @return
	 */
	public Event checkAct( int event_id);
	
	/**
	 * Jun:查看用户信息(这里的用户并不单指普通用户，也可能是管理员id，因此返回值是 Object )
	 * @param customer_id
	 * @return
	 */
	public BaseCustomer checkUserInfo(int customer_id);
	
	
	/**
	 * Jun:查看所有活动信息( 管理员可以看到所有活动,包括已下线的活动 )
	 * @validate no
	 * @intercept no
	 * @return
	 */
	public Map<String,String> checkAllAct( boolean isAdmin);
	
	/**
	 * Jun:用户查看自己所参与的活动
	 * @validate no
	 * @intercept yes
	 * @param event_customer
	 * @return
	 */
	public Map<String,String> checkTakePartIn( int event_customer);
	
	
	/**
	 * Jun:管理员查看个人所发布的活动
	 * @validate no
	 * @intercept yes
	 * @param event_publisher
	 * @return
	 */
	public Map<String,String> checkPublish(int event_publisher);
	
	
	/**
	 * Jun:查看所有参与活动的用户信息
	 * @validate no
	 * @intercept yes
	 * @param event_id
	 * @param event_publisher
	 * @return
	 */
	public Map<String,String> checkTakePartInUserInfo( int event_id, int event_publisher);
	
	
	/**
	 * Jun:退出活动
	 * @validate no
	 * @intercept yes
	 * @param event_id
	 * @param event_customer
	 * @return
	 */
	public boolean exitAct( Event evt, BaseCustomer event_customer);
	
	
	
	/**
	 * Jun:下线活动
	 * @validate no
	 * @intercept yes
	 * @param event_id
	 * @return
	 */
	public boolean offLineAct( Event evt, Admin ad);
	
	
	/**
	 * Jun:上线活动
	 * @validate yes
	 * @intercept yes 
	 * @param evt
	 * @param event_id
	 * @param event_publisher
	 */
	public boolean onLineAct(Event evt, Admin ad);
    
	/**
	 * Jun:创建活动
	 * @param event_name
	 * @param event_intro
	 * @param event_time
	 * @param event_endtime
	 * @param event_maxPeople
	 * @param event_publisher
	 * @param event_state
	 * @return
	 */
	public boolean createAct(String event_name,String event_intro,Date   event_time,
			                 Date   event_endtime,int    event_maxPeople,
			                 Admin    event_publisher,int    event_state);
	
	/**
	 * Jun: 删除活动
	 * @param evt
	 * @param event_id
	 * @param event_publisher
	 * @return
	 */
	public boolean deleteAct(Event evt,Admin ad);
	
	/**
	 * Jun:修改活动信息
	 * @param evt
	 * @param ad
	 * @return
	 */
	public boolean modifyAct(Event  evt,Admin ad,String event_name,String event_intro,Date   event_time,
                             Date   event_endtime,int    event_maxPeople);
	
	/**
	 * Jun:参加活动
	 * @validate no
	 * @intercept yes
	 * @param event_id
	 * @param event_customer
	 * @return
	 */
    public boolean takePartInAct(Event evt,BaseCustomer evt_customer);
}
