package com.scuthnweb.dao.interf;

import java.util.Date;
import java.util.List;

import com.scuthnweb.domain.Event;

public interface EventDao {
	
	/**
	 * Jun:创建一个新的活动
	 * @param Event evt
	 * @return
	 */
	public  Event createEvent( Event evt);
	
	
	/**
	 * Jun:更新活动信息
	 * @param Event evt
	 * @return
	 */
	public void updateEvent( Event evt);
	
	/**
	 * 
	 * @param evt
	 */
	public void delete(Event evt);
	
	/**
	 * Jun:
	 * @param event_name
	 * @param event_intro
	 * @param event_time
	 * @param event_endtime
	 * @param event_maxPeople
	 * @param event_publisher
	 * @param event_state
	 * @return
	 * @deprecated
	 */
	public  List<Event> findEventM(int    event_id,String event_name,String event_intro,
                               Date   event_time,Date   event_endtime,int    event_maxPeople,
                               int    event_publisher,int    event_state); 
	
	/**
	 * Jun:通过活动ID查找活动
	 * @param event_id
	 * @return
	 */
	public  Event findByEventId(int   event_id);  
	
	/**
	 * Jun:查找所有活动
	 * @param event_state 0表示上线，1表示下线，2表示查看所有活动
	 * @return
	 */
	public  List<Object[]> findAllEvents(int event_state);
	
	
	/**
	 * Jun:通过活动发布者查询活动
	 * @param event_publisher
	 * @return
	 */
	public  List<Object[]> findByEvent_publisher(int event_publisher);

}
