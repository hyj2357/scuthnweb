package com.scuthnweb.domain;

import java.util.Set;

public class Need {
	
	private int    need_id, need_state;
	private BaseCustomer need_publisher;
	private String need_name, need_content;
	
	private Set<Pub_rec_need> pub_rec_need;
	
	public Need(){};
	
	public int getNeed_id() {
		return need_id;
	}
	public void setNeed_id(int need_id) {
		this.need_id = need_id;
	}
	
	
	public BaseCustomer getNeed_publisher() {
		return need_publisher;
	}
	public void setNeed_publisher(BaseCustomer need_publisher) {
		this.need_publisher = need_publisher;
	}
	
	
	public int getNeed_state() {
		return need_state;
	}
	public void setNeed_state(int need_state) {
		this.need_state = need_state;
	}
	
	
	public String getNeed_name() {
		return need_name;
	}
	public void setNeed_name(String need_name) {
		this.need_name = need_name;
	}
	
	
	public String getNeed_content() {
		return need_content;
	}
	public void setNeed_content(String need_content) {
		this.need_content = need_content;
	}

	public Set<Pub_rec_need> getPub_rec_need() {
		return pub_rec_need;
	}

	public void setPub_rec_need(Set<Pub_rec_need> pub_rec_need) {
		this.pub_rec_need = pub_rec_need;
	}	
	
	
}
