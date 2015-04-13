package com.scuthnweb.dao.interf;

import java.util.List;

import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Need;

public interface NeedDao {
  /**
   * Jun:创建新的需求
   * @param nd
   * @return
   */
   public Need createNeed( Need nd);
   
  
   /**
    * Jun:更新需求
    * @param nd
    * @return
    */
   public void updateNeed( Need nd);
   
   
   /**
    * Jun:
    * @param need_id
    * @param need_name
    * @param need_content
    * @param need_state
    * @return
    * @deprecated
    */
   public List<Need> findNeedM(  int    need_id,
                           String need_name,
                           String need_content,
                           int    need_publisher,
                           int    need_state);
   
   
   /**
    * Jun:通过需求ID查找需求
    * @param need_id
    * @return
    */
   public Need findByNeed_ID( int  need_id);
   
   
   /**
    * Jun:通过需求发布者查找需求
    * @param need_publisher
    * @return
    */
   public List<Need> findByNeed_publisher( int need_publisher);
   
   /**
    * Jun:查看所有的需求
    * @param need_state 0表示未解决，1表示已解决，2表示全部
    * @return
    */
   public List<Object[]> findAllNeed(int need_state);
      
   /**
    * Jun：删除需求
    * @param nd
    * @return
    */
   public void  deleteNeed(Need nd);
}
