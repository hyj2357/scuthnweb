package com.scuthnweb.domain;

public class Pub_rec_need {
	private  int  pub_rec_need_id;
    private  BaseCustomer need_receiver;
    private  Need need;
    
	public   Pub_rec_need(){};
	
	
	public Need getNeed() {
		return need;
	}
	public void setNeed(Need need) {
		this.need = need;
	}

	
	
	public BaseCustomer getNeed_receiver() {
		return need_receiver;
	}
    public void setNeed_receiver(BaseCustomer need_receiver) {
		this.need_receiver = need_receiver;
	}


	public int getPub_rec_need_id() {
		return pub_rec_need_id;
	}


	public void setPub_rec_need_id(int pub_rec_need_id) {
		this.pub_rec_need_id = pub_rec_need_id;
	}
}
