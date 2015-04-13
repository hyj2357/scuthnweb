package com.scuthnweb.service.impl;

import java.util.Map;

import com.scuthnweb.dao.interf.MessageDao;
import com.scuthnweb.dao.interf.Share_linkDao;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Share_link;
import com.scuthnweb.service.interf.ResLinkModule;

public class ResLinkModuleImpl implements ResLinkModule{
	private MessageDao         messageDao;
    private Share_linkDao      share_linkDao;
	
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	public void setShare_linkDao(Share_linkDao share_linkDao) {
		this.share_linkDao = share_linkDao;
	}

	@Override
	public boolean delLink(int share_link_id, BaseCustomer share_link_publisher) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean op_Link(int share_link_id,Admin admin, BaseCustomer share_link_publisher,boolean accept) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateLink(int share_link_id, BaseCustomer share_link_publisher,String share_link_name, String share_link_content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean uploadLink(BaseCustomer share_link_publisher, String share_link_name, String share_link_content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, String> checkAllResLink(boolean isAdmin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> checkUploadLink(BaseCustomer share_link_publisher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> checkVerifyLink() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Share_link checkLink(int share_link_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
