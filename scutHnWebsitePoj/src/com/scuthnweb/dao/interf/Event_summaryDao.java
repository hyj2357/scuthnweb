package com.scuthnweb.dao.interf;

import java.util.List;

import com.scuthnweb.domain.Event_summary;

public interface Event_summaryDao {
	
	/**
	 * Jun:
	 * @param es
	 * @return
	 */	
	public void createEvent_summary(Event_summary es);
	

	
	/**
	 * Jun:
	 * @param Event_id
	 * @param Event_customer
	 * @return
	 */
	public List<Event_summary> findEvent_summaryM( int Event_id, int Event_customer);
	
	
	/**
	 * Jun:
	 * @param Event_id
	 * @return
	 */
	public List<Event_summary> findByEvent_id( int Event_id );
	
	
	/**
	 * Jun:
	 * @param Event_customer
	 * @return
	 */
	public List<Event_summary> findByEvent_customer( int Event_customer );
    
	/**
	 * Jun:
	 * @param event_id
	 * @param event_customer
	 * @return
	 */
	public Event_summary findByEvent_idAndEvent_customer(int event_id,int event_customer);
	
	
	/**
	 * Jun:
	 * @param es
	 */
	public void deleteEvent_summary(Event_summary es);
}
