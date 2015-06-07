package com.scuthnweb.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.scuthnweb.dao.interf.NoteDao;
import com.scuthnweb.domain.Note;

public class NoteDaoImpl  extends HibernateDaoSupport implements NoteDao{

	public void createNote(Note nt) {
		//调用 Hibernate 模版存储对象
	    this.getHibernateTemplate().save(nt);
	}

	
	@Override
	public Note findByNote_id(int note_id) {
		//调用 Hibernate 模版获取对象
	    return (Note)this.getHibernateTemplate().get(Note.class, note_id);
	}

	@Override
	public void updateNote(final Note nt) {
		//调用 Hibernate 模版更新对象
	    //this.getHibernateTemplate().update(nt);
		this.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session) throws HibernateException,
					SQLException {

						session.setFlushMode(FlushMode.AUTO); 

						session.update(nt); 

						session.flush(); 

						return null; 
					}
		});
	}

	@Override
	public List<Note> findNoteM(int note_id, String note_name, int note_type,
			String note_content, int  note_publisher, int note_state) {
	    return null;
	}


	@Override
	public void deleteNote(final Note nt) {
		//调用 Hibernate 模版删除对象
	    //this.getHibernateTemplate().delete(nt);
		this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						session.setFlushMode(FlushMode.AUTO);
						session.beginTransaction();

						Query query = session.createSQLQuery("DELETE FROM note WHERE note_id=?")
								.setInteger(0, nt.getNote_id());
						query.executeUpdate();
						
						session.getTransaction().commit();
						return null; 
					}
				});
	}


	@Override
	public List<Object[]> findAllNote(int note_state) {
		//
	    if(note_state==2)
	    	return this.getSession().getNamedQuery("findAllNote_note_query").list();
	    else return this.getSession().getNamedQuery("findAllNote_note_query_state")
	    		                     .setInteger(0, note_state)
	    		                     .list();
	}


	@Override
	public List<Object[]> findByNotePublisher(int note_publisher) {
		return this.getSession().getNamedQuery("findByNotePublisher_note_query")
				                .setInteger(0, note_publisher).list();
	}

}
