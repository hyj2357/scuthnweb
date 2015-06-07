package com.scuthnweb.action.notemodule;

import java.io.File;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.Note;
import com.scuthnweb.service.interf.NoteModule;

public class PostNoteAction extends ActionSupport{
    
	private NoteModule noteModule;	
    private ActionContext ctx;
    private String note_name,note_content;
    private int note_type;
	
    public String execute(){
    	ActionContext ctx = ActionContext.getContext();
    	Admin ad = (Admin)ctx.getSession().get("admin");
    	if(this.noteModule.postNote( note_name, note_type, note_content, ad))
    		return SUCCESS;
    	return ERROR;
    }

    public void validate(){
        
        //校验公告信息名称
        String regexNote_name = "^[\\u4E00-\\u9FA5\\w]{2,20}$";
        if( !Pattern.matches(regexNote_name, this.note_name) )
             this.addFieldError("note_name","公告信息名称为2～20个简体中文");
        
        //校验公告信息内容
        String regexNote_content = "^(([\\u4E00-\\u9FA5]|\\w|,|，|.|。|:|：){10,8000})$";
        if( !Pattern.matches(regexNote_content, this.note_content))
            this.addFieldError("note_content","公告信息内容长度为10～8000");
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
