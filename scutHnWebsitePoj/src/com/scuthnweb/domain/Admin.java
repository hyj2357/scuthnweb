package com.scuthnweb.domain;

import java.util.Set;

public class Admin extends BaseCustomer{
       
	private  int    id,admin_state;
    private  String name,admin_password;
	
    private  Set<Note> note;
    private  Set<Event> event;
	
    public Set<Note> getNote() {
		return note;
	}
	public void setNote(Set<Note> note) {
		this.note = note;
	}
	public Set<Event> getEvent() {
		return event;
	}
	public void setEvent(Set<Event> event) {
		this.event = event;
	}	
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public int getAdmin_state() {
		return admin_state;
	}
	public void setAdmin_state(int admin_state) {
		this.admin_state = admin_state;
	}	
}