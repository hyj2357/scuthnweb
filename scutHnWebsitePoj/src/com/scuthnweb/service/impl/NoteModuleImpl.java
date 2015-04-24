package com.scuthnweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scuthnweb.dao.interf.AdminDao;
import com.scuthnweb.dao.interf.NoteDao;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.Note;
import com.scuthnweb.service.interf.NoteModule;
import com.scuthnweb.tools.NoteModuleTools;

public class NoteModuleImpl implements NoteModule{
	private  AdminDao adminDao;
	private  NoteDao  noteDao;

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public void setNoteDao(NoteDao noteDao) {
		this.noteDao = noteDao;
	}

	@Override
	public Map<String, String> checkAllNote(boolean isAdmin) {
		Map<String,String> noteMap = new HashMap<String,String>();
		List<Object[]> ls = this.noteDao.findAllNote(isAdmin?2:0);
		for(Object[] itr:ls){
			noteMap.put("["+NoteModuleTools.convertTypeToString((int)itr[2])+"]"+(String)itr[1], "CheckNoteAction?note="+itr[0]);
		}
		return noteMap;
	}

	@Override
	public Map<String, String> checkPostNote(Admin note_publisher) {
		Map<String,String> noteMap = new HashMap<String,String>();
		List<Object[]> ls = this.noteDao.findByNotePublisher(note_publisher.getId());
		for(Object[] itr:ls){
			noteMap.put("["+NoteModuleTools.convertTypeToString((int)itr[2])+"]"+(String)itr[1], "CheckNoteAction?note="+itr[0]);
		}
		return noteMap;
	}

	@Override
	public boolean modifyNote(Note note, String note_name, int note_type,String note_content, Admin note_publisher) {
		if( note.getNote_publisher().getId() != note_publisher.getId())
			return false;
		note.setNote_name(note_name);
		note.setNote_content(note_content);
		note.setNote_type(note_type);
		//更新公告信息
		this.noteDao.updateNote(note);
		return true;
	}

	@Override
	public boolean offlineNote(Note note, Admin note_publisher) {
		if(note.getNote_publisher().getId()!=note_publisher.getId())
			return false;
		note.setNote_state(1);
		//更新公告信息状态
		this.noteDao.updateNote(note);
		return true;
	}

	@Override
	public boolean postNote(String note_name, int note_type,String note_content, Admin note_publisher) {
		Note nt = new Note();
		nt.setNote_name(note_name);
		nt.setNote_type(note_type);
		nt.setNote_content(note_content);
		nt.setNote_publisher(note_publisher);
		nt.setNote_state(0);
		//发布公告信息
        this.noteDao.createNote(nt);
		return true;
	}

	@Override
	public boolean deleteNote(Note note, Admin note_publisher) {
		if(note.getNote_publisher().getId()!=note_publisher.getId())
		   return false;
		this.noteDao.deleteNote(note);
		return true;
	}

	@Override
	public Note checkNote(int note_id) {
		return this.noteDao.findByNote_id(note_id);
	}

}
