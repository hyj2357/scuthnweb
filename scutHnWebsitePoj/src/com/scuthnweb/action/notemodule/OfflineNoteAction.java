package com.scuthnweb.action.notemodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.Note;
import com.scuthnweb.service.interf.NoteModule;

public class OfflineNoteAction extends ActionSupport{
    
	private NoteModule noteModule;	
    private ActionContext ctx;
	private int note_state;
    public String execute(){
    	ctx = ActionContext.getContext();
    	Note nt = (Note)ctx.getSession().get("note");
    	Admin ad = (Admin)ctx.getSession().get("admin");
    	//该处为紧急修改
    	//并不符合设计原则
    	nt.setNote_state(note_state);
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

	public int getNote_state() {
		return note_state;
	}

	public void setNote_state(int note_state) {
		this.note_state = note_state;
	}

}
