package com.scuthnweb.dao.interf;

import java.util.List;

import com.scuthnweb.domain.Pub_rec_need;

public interface Pub_rec_needDao {
	/**
	 * 
	 * @param need_id
	 * @param need_receiver
	 * @return
	 */
	public  void  createPub_rec_need( Pub_rec_need prn);
	
	
	/**
	 * Jun:
	 * @param prn
	 */
	public  void  updatePub_rec_need( Pub_rec_need prn );
	
	
	/**
	 * Jun:
	 * @param need_id
	 * @param need_receiver
	 * @return
	 * @deprecated
	 */
	public  List<Pub_rec_need>  findPub_rec_needM( int need_id, int need_receiver);
	
	
	/**
	 * 
	 * @param need_id
	 * @return
	 */
	public  List<Pub_rec_need>  findByNeed_id( int need_id);
	
	
	/**
	 * 
	 * @param need_receiver
	 * @return
	 */
	public  List<Pub_rec_need>  findByNeed_reciever( int need_receiver );
	
	/**
	 * 
	 * @param prn
	 */
	public  void deletePub_rec_need( Pub_rec_need prn );

}
