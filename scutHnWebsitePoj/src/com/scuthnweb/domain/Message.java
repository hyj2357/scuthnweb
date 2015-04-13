package com.scuthnweb.domain;

import com.scuthnweb.domain.BaseCustomer;

public class Message extends com.scuthnweb.domain.BaseDomain{
       private int     message_id,
                       message_state;
       private String  message_title,
                       message_content;
       private BaseCustomer message_publisher;
       private BaseCustomer message_receiver;
       
	public int getMessage_id() {
		return message_id;
	}
	
	public void setMessage_id(int  message_id) {
		this.message_id = message_id;
	}
	
	public String getMessage_content() {
		return message_content;
	}
	
	public void setMessage_content(String  message_content) {
		this.message_content = message_content;
	}

	public int getMessage_state() {
		return message_state;
	}

	public void setMessage_state(int message_state) {
		this.message_state = message_state;
	}


	public BaseCustomer getMessage_publisher() {
		return message_publisher;
	}

	public void setMessage_publisher(BaseCustomer message_publisher) {
		this.message_publisher = message_publisher;
	}

	public BaseCustomer getMessage_receiver() {
		return message_receiver;
	}

	public void setMessage_receiver(BaseCustomer message_receiver) {
		this.message_receiver = message_receiver;
	}

	public String getMessage_title() {
		return message_title;
	}

	public void setMessage_title(String message_title) {
		this.message_title = message_title;
	}
	
}
