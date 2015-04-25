package com.scuthnweb.action.notemodule;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.interf.NeedModule;
import com.scuthnweb.service.interf.NoteModule;

public class CheckAllNoteAction extends ActionSupport{
    
	private NoteModule noteModule;	
    private ActionContext ctx;
	
    public String execute(){
        ctx.getSession().put("noteMap", this.noteModule.checkAllNote(ctx.getSession().get("admin")!=null));
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
