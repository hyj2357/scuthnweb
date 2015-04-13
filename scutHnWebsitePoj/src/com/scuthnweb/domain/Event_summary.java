package com.scuthnweb.domain;

public class Event_summary {
	private int event_summary_id;
	private Event event;
	private BaseCustomer event_customer;
	
	public   Event_summary(){};
	
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	
	
	public BaseCustomer getEvent_customer() {
		return event_customer;
	}
	public void setEvent_customer(BaseCustomer event_customer) {
		this.event_customer = event_customer;
	}

	public int getEvent_summary_id() {
		return event_summary_id;
	}

	public void setEvent_summary_id(int event_summary_id) {
		this.event_summary_id = event_summary_id;
	}
}
