package com.scuthnweb.action.reslinkmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Share_link;
import com.scuthnweb.service.interf.ResLinkModule;

public class CheckLinkAction extends ActionSupport{
    
	private ResLinkModule resLinkModule;	
    private ActionContext ctx;
	private int share_link_id;
    
    public String execute(){
    	ctx = ActionContext.getContext();
    	Share_link sl = this.resLinkModule.checkLink(share_link_id);
    	ctx.getSession().put("resLink", sl);
    	//
    	BaseCustomer cs = (BaseCustomer)ctx.getSession().get("admin");
    	if(cs==null)
    		cs = (BaseCustomer)ctx.getSession().get("customer");
    	//如果当前登录者为该链接发布者
    	//设置一个发布标志
    	if(cs!=null)
    		if(sl.getShare_link_publisher().getId()==cs.getId())
    			ctx.getSession().put("link_pub_state", new Integer(0));
    		else 
    			ctx.getSession().put("link_pub_state", new Integer(-1));
    	return SUCCESS;
    }

	public ResLinkModule getResLinkModule() {
		return resLinkModule;
	}

	public void setResLinkModule(ResLinkModule resLinkModule) {
		this.resLinkModule = resLinkModule;
	}

	public int getShare_link_id() {
		return share_link_id;
	}

	public void setShare_link_id(int share_link_id) {
		this.share_link_id = share_link_id;
	}

	public ActionContext getCtx() {
		return ctx;
	}

	public void setCtx(ActionContext ctx) {
		this.ctx = ctx;
	}
}
