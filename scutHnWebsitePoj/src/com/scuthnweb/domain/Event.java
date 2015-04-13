package com.scuthnweb.domain;

import java.util.Date;
import java.util.Set;

public class Event {
	private int    event_id,
	               event_maxPeople,
	               event_state;
	
	private String event_name,
	               event_intro;
	
	private Date   event_time,
	               event_endtime;
	
	private Admin event_publisher;
	
	private Set<Event_summary> event_summary;
	
	public  Event(){};

	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	
	public int getEvent_maxPeople() {
		return event_maxPeople;
	}
	public void setEvent_maxPeople(int event_maxPeople) {
		this.event_maxPeople = event_maxPeople;
	}


	public Admin getEvent_publisher() {
		return event_publisher;
	}
	public void setEvent_publisher(Admin event_publisher) {
		this.event_publisher = event_publisher;
	}

	
	
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	
	
	public String getEvent_intro() {
		return event_intro;
	}
    public void setEvent_intro(String event_intro) {
		this.event_intro = event_intro;
	}

	
    
    public Date getEvent_time() {
		return event_time;
	}
    public void setEvent_time(Date event_time) {
		this.event_time = event_time;
	}

	public Date getEvent_endtime() {
		return event_endtime;
	}
    public void setEvent_endtime(Date event_endtime) {
		this.event_endtime = event_endtime;
	}

	public int getEvent_state() {
		return event_state;
	}

	public void setEvent_state(int event_state) {
		this.event_state = event_state;
	}

	public Set<Event_summary> getEvent_summary() {
		return event_summary;
	}

	public void setEvent_summary(Set<Event_summary> event_summary) {
		this.event_summary = event_summary;
	}

}
