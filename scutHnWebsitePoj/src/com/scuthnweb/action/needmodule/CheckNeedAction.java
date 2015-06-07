package com.scuthnweb.action.needmodule;

import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Need;
import com.scuthnweb.domain.Pub_rec_need;
import com.scuthnweb.service.interf.NeedModule;

public class CheckNeedAction extends ActionSupport{
    
	private NeedModule needModule;	
    private ActionContext ctx;
	private int need_id;
    
	public String execute(){    
		ctx = ActionContext.getContext();
		Need nd =  this.needModule.checkNeed(need_id);
    	//调用业务逻辑组件
    	ctx.getSession().put("need", nd);
    	//
    	BaseCustomer cs = (BaseCustomer)ctx.getSession().get("admin");
    	if(cs==null)
    		cs = (BaseCustomer)ctx.getSession().get("customer");
    	//如果当前登录者为该需求发布者
    	//设置一个发布标志
    	if(cs!=null)
    		if(nd.getNeed_publisher().getId()==cs.getId())
    			ctx.getSession().put("need_pub_state", new Integer(0));
    		else{ 
    			ctx.getSession().put("need_pub_state", new Integer(-1));
    			//如果不是发布者
    			//则设置需求接受标志
				ctx.getSession().put("need_rec_state", new Integer(0));
    			Set<Pub_rec_need> prn = nd.getPub_rec_need();
    			for(Pub_rec_need itr:prn)
    				if(itr.getNeed_receiver().getId()==cs.getId()){
    					ctx.getSession().put("need_rec_state", new Integer(-1));
    					break;
    				}
    		}
    	return SUCCESS;
    }

	public NeedModule getNeedModule() {
		return needModule;
	}

	public void setNeedModule(NeedModule needModule) {
		this.needModule = needModule;
	}

	public ActionContext getCtx() {
		return ctx;
	}

	public void setCtx(ActionContext ctx) {
		this.ctx = ctx;
	}

	public int getNeed_id() {
		return need_id;
	}

	public void setNeed_id(int need_id) {
		this.need_id = need_id;
	}
}