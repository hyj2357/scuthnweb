package com.scuthnweb.service.interf;

import java.util.List;
import java.util.Map;

import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.Note;

public interface NoteModule{
	
	/**
	 * Jun:查看所有管理员发布的信息
	 * @validate no
	 * @interrupt no	
	 * @return
	 */
	public  Map<String,String> checkAllNote( boolean isAdmin );
	
	/**
	 * Jun:管理员查看自己所发布的信息
	 * @validate no
	 * @interrupt yes  
	 * @param note__publisher
	 * @return
	 */
	public  Map<String,String> checkPostNote( Admin note_publisher );
	
	
	/**
	 * Jun:管理员修改所发布的信息
	 * @validate yes
	 * @interrupt yes
	 * @param note_id
	 * @param note_name
	 * @param note_type
	 * @param note_content
	 * @param note_publisher
	 * @return
	 */
	public  boolean    modifyNote( Note note, String note_name, int note_type, String note_content, Admin note_publisher);
	
	
	/**
	 * Jun:管理员下线信息
	 * @validate no
	 * @interrupt yes
	 * @param note_id
	 * @return
	 */
	public  boolean    offlineNote( Note note, Admin note_publisher);
	
	
	/**
	 * Jun: 管理员发布信息
	 * @validate yes
	 * @interrupt yes
	 * @param note_name
	 * @param note_type
	 * @param note_content
	 * @param note_publisher
	 * @return
	 */
	public  boolean    postNote( String note_name, int note_type, String note_content, Admin note_publisher);


	/**
	 * Jun: 管理员删除信息
	 * @validate no
	 * @interrupt yes 
	 * @param note_id
	 * @param note_publisher
	 * @return
	 */
    public  boolean  deleteNote( Note note, Admin note_publisher);
    
    
    /**
     * Jun:查看单条信息
     * @param note_id
     * @return
     */
    public  Note checkNote(int note_id);
}
