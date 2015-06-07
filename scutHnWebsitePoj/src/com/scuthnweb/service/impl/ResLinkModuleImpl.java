package com.scuthnweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scuthnweb.dao.interf.AdminDao;
import com.scuthnweb.dao.interf.MessageDao;
import com.scuthnweb.dao.interf.Share_linkDao;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Message;
import com.scuthnweb.domain.Share_link;
import com.scuthnweb.service.interf.ResLinkModule;
import com.scuthnweb.tools.ParamTools;

public class ResLinkModuleImpl implements ResLinkModule{
	private MessageDao         messageDao;
    private Share_linkDao      share_linkDao;
	private AdminDao           adminDao;
	
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	public void setShare_linkDao(Share_linkDao share_linkDao) {
		this.share_linkDao = share_linkDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public boolean delLink(Share_link sl, BaseCustomer share_link_publisher) {
		//
		if(sl.getShare_link_publisher().getId()!=share_link_publisher.getId())
			return false;
		this.share_linkDao.deleteShare_link(sl);
		return true;
	}

	@Override
	public boolean op_link(Share_link sl,Admin admin, boolean accept) {
		 //设置链接处于哪种状态
		 sl.setShare_link_state(accept?0:1);
		 String _accept = "接受",
				_refuse = "拒绝";
		 Message ms = new Message();
		 ms.setMessage_title("资源链接审核信息");
		 ms.setMessage_content(  "您发布的链接[id:"+sl.getShare_link_id()
				               + " "+sl.getShare_link_name() +"] 已被管理员"
				               + (accept?_accept:_refuse)+",如有相关问题,请联系管理员;");
		 ms.setMessage_publisher(admin);
		 ms.setMessage_receiver(sl.getShare_link_publisher());
		 //设置消息为未读
		 ms.setMessage_state(0);
		 //推送消息
		 this.messageDao.createMessage(ms);
		 //更新链接状态
		 this.share_linkDao.updateShare_link(sl);
		 return true;
	}

	@Override
	public boolean updateLink(Share_link sl, BaseCustomer share_link_publisher,String share_link_name, String share_link_content) {
		//如果当前修改链接者非链接发布者
		if(sl.getShare_link_publisher().getId()!=share_link_publisher.getId())
			return false;
		sl.setShare_link_name(share_link_name);
		sl.setShare_link_content(share_link_content);
		//更新链接信息后
		//链接处于待审核状态
		sl.setShare_link_state(2);
		Message ms = new Message();
		ms.setMessage_title("普通用户更新资源链接审核信息");
		ms.setMessage_content(  "用户更新链接[id:"+sl.getShare_link_id()
				               + " "+sl.getShare_link_name() +"] ,请审核链接内容;");
		ms.setMessage_publisher(share_link_publisher);
		//随机由id:1~10中抽取一个管理员接受消息
		ms.setMessage_receiver(this.adminDao.findAdminByAdminId((int)( 10*Math.random() ) ));
		//设置消息为未读
		ms.setMessage_state(0);
		//推送消息
		this.messageDao.createMessage(ms);
		//更新链接
		this.share_linkDao.updateShare_link(sl);
		return true;
	}

	@Override
	public boolean uploadLink(BaseCustomer share_link_publisher, String share_link_name, String share_link_content) {
		Share_link sl = new Share_link();
		sl.setShare_link_name(share_link_name);
		sl.setShare_link_content(share_link_content);
		sl.setShare_link_publisher(share_link_publisher);
		sl.setShare_link_state(2);
		
		Message ms = new Message();
		ms.setMessage_title("用户发布资源链接审核信息");
		ms.setMessage_content(  "用户发布链接["+ sl.getShare_link_name() +"] ,请审核链接内容;");
		ms.setMessage_publisher(share_link_publisher);
		//随机由id:1~10中抽取一个管理员接受消息
		ms.setMessage_receiver(this.adminDao.findAdminByAdminId(ParamTools.getARandomIntegerInRange(10)));
		//设置消息为未读
		ms.setMessage_state(0);
		//推送消息
		this.messageDao.createMessage(ms);
		//创建资源链接
		this.share_linkDao.createShare_link(sl);
		return true;
	}

	@Override
	public Map<String, String> checkAllResLink(boolean isAdmin) {
		Map<String,String> linkMap = new HashMap<String,String>();
		List<Object[]> ls = this.share_linkDao.findAllShare_link(0);
		//如果为管理员
		//则同时可以看到未审核通过的链接
		if(isAdmin)
			ls.addAll(this.share_linkDao.findAllShare_link(1));
		for(Object[] itr:ls){
			linkMap.put((String)itr[1], "checkLinkAction?share_link_id="+((Integer)itr[0]).toString());
		}
		return linkMap;
	}

	@Override
	public Map<String, String> checkUploadLink(BaseCustomer share_link_publisher) {
		Map<String,String> linkMap = new HashMap<String,String>();
		//由id查询用户所发布的资源链接
		List<Object[]> ls = this.share_linkDao.findByShare_link_publisher(share_link_publisher.getId());
		for(Object[] itr:ls){
			linkMap.put((String)itr[1], "checkLinkAction?share_link_id="+((Integer)itr[0]).toString());
		}
		return linkMap;
	}

	@Override
	public Map<String, String> checkVerifyLink() {
		Map<String,String> linkMap = new HashMap<String,String>();
		//查看所有待审核链接
		List<Object[]> ls = this.share_linkDao.findAllShare_link(2);
		for(Object[] itr:ls){
			linkMap.put((String)itr[1], "checkLinkAction?share_link_id="+((Integer)itr[0]).toString());
		}
		return linkMap;
	}

	@Override
	public Share_link checkLink(int share_link_id) {
		return this.share_linkDao.findByShare_link_id(share_link_id);
	}
}
