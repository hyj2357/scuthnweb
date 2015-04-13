package com.scuthnweb.dao.interf;

import java.util.List;

import com.scuthnweb.domain.Note;

public interface NoteDao {
	/**
	 * Jun:
	 * @param nt
	 * @return
	 */
	public void createNote( Note nt);
	
	
	/**
	 * Jun:
	 * @param nt
	 * @return
	 */
	public void updateNote( Note nt );
	
	
	/**
	 * Jun:
	 * @param note_id
	 * @param note_name
	 * @param note_type
	 * @param note_content
	 * @param note_publisher
	 * @return
	 */
	public List<Note> findNoteM( int    note_id,
                           String note_name,
                           int    note_type,
                           String note_content,
                           int    note_publisher,
                           int    note_state);
	
	/**
	 * 
	 * @param note_id
	 * @return
	 */
	public Note findByNote_id( int note_id );

	/**
	 * Jun:查看所有的信息
	 * @param note_state 0表示查看已上线信息 1表示查看未上线信息 2表示查看所有信息
	 * @return
	 */
	public List<Object[]> findAllNote(int note_state);
	
	/**
	 * Jun: 
	 * @param note_publisher
	 * @return
	 */
	public List<Object[]> findByNotePublisher(int note_publisher);
	
	/**
	 * Jun:
	 * @param nt
	 * @return
	 */
	public void deleteNote( Note nt );
}
