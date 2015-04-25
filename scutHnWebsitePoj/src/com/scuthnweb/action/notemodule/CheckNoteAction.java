package com.scuthnweb.action.notemodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.interf.NeedModule;
import com.scuthnweb.service.interf.NoteModule;

public class CheckNoteAction extends ActionSupport{
    
	private NoteModule noteModule;	
    private ActionContext ctx;
	private int note_id;
    
    public String execute(){
        ctx.getSession().put("note", this.noteModule.checkNote(note_id));
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

	public int getNote_id() {
		return note_id;
	}

	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}
}
