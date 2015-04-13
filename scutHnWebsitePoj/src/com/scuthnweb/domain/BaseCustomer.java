package com.scuthnweb.domain;

import java.util.Set;

public class BaseCustomer {
	
	private String name;
	private int    id;
	
	private  Set<Event_summary> event_summary;
	private  Set<Message> receive_message,publish_message;
	private  Set<Share_link> share_link;
	private  Set<Need> need;
	private  Set<Pub_rec_need> pub_rec_need;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Set<Event_summary> getEvent_summary() {
		return event_summary;
	}
	public void setEvent_summary(Set<Event_summary> event_summary) {
		this.event_summary = event_summary;
	}
	
	public Set<Share_link> getShare_link() {
		return share_link;
	}
	public void setShare_link(Set<Share_link> share_link) {
		this.share_link = share_link;
	}
	public Set<Need> getNeed() {
		return need;
	}
	public void setNeed(Set<Need> need) {
		this.need = need;
	}
	public Set<Pub_rec_need> getPub_rec_need() {
		return pub_rec_need;
	}
	public void setPub_rec_need(Set<Pub_rec_need> pub_rec_need) {
		this.pub_rec_need = pub_rec_need;
	}
	public Set<Message> getReceive_message() {
		return receive_message;
	}
	public void setReceive_message(Set<Message> receive_message) {
		this.receive_message = receive_message;
	}
	public Set<Message> getPublish_message() {
		return publish_message;
	}
	public void setPublish_message(Set<Message> publish_message) {
		this.publish_message = publish_message;
	}
	
}
