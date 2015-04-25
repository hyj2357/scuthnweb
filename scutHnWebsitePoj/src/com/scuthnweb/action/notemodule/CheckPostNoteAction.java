package com.scuthnweb.action.notemodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.service.interf.NoteModule;

public class CheckPostNoteAction extends ActionSupport{
    
	private NoteModule noteModule;	
    private ActionContext ctx;
	
    public String execute(){
    	Admin ad = (Admin)ctx.getSession().get("admin");
        ctx.getSession().put("noteMap", this.noteModule.checkPostNote(ad));
        return SUCCESS;
    }

	public NoteModule getNoteModule() {
		return noteModule;
	}

	public void setNoteModule(NoteModule noteModule) {
		this.noteModule = noteModule;
	}

	public ActionContext getCtx() {
		return ctx;
	}

	public void setCtx(ActionContext ctx) {
		this.ctx = ctx;
	}

}
