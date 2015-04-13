package com.scuthnweb.service.impl;

import java.util.Map;

import com.scuthnweb.dao.interf.AdminDao;
import com.scuthnweb.dao.interf.NoteDao;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.service.interf.NoteModule;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> checkPostNote(Admin note_publisher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyNote(int note_id, String note_name, int note_type,String note_content, Admin note_publisher) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offlineNote(int note_id, Admin note_publisher) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean postNote(String note_name, int note_type,String note_content, Admin note_publisher) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteNote(int note_id, Admin note_publisher) {
		// TODO Auto-generated method stub
		return false;
	}

}
