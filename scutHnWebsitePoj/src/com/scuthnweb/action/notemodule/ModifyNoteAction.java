package com.scuthnweb.action.notemodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.Note;
import com.scuthnweb.service.interf.NoteModule;

public class ModifyNoteAction extends ActionSupport{
    
	private NoteModule noteModule;	
    private ActionContext ctx;
    private String note_name,note_content;
    private int note_type;
	
    public String execute(){
    	Note nt = (Note)ctx.getSession().get("note");
    	Admin ad = (Admin)ctx.getSession().get("admin");
    	if(this.noteModule.modifyNote(nt, note_name, note_type, note_content, ad))
    		return SUCCESS;
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

	public String getNote_name() {
		return note_name;
	}

	public void setNote_name(String note_name) {
		this.note_name = note_name;
	}

	public String getNote_content() {
		return note_content;
	}

	public void setNote_content(String note_content) {
		this.note_content = note_content;
	}

	public int getNote_type() {
		return note_type;
	}

	public void setNote_type(int note_type) {
		this.note_type = note_type;
	}

}
