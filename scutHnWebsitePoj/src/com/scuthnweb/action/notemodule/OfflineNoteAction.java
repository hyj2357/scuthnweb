package com.scuthnweb.action.notemodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.Note;
import com.scuthnweb.service.interf.NoteModule;

public class OfflineNoteAction extends ActionSupport{
    
	private NoteModule noteModule;	
    private ActionContext ctx;
	
    public String execute(){
    	Note nt = (Note)ctx.getSession().get("note");
    	Admin ad = (Admin)ctx.getSession().get("admin");
    	if(this.noteModule.offlineNote(nt, ad)){
            return SUCCESS;
    	}
    	return ERROR;
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
