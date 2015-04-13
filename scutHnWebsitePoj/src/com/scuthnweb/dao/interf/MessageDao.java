package com.scuthnweb.dao.interf;

import java.util.List;

import com.scuthnweb.domain.Message;

public interface MessageDao {
	      /**
	       * 创建新消息
	       * @param message_id
	       * @param message_content
	       */
          public void createMessage( Message message);
          
          
          /**
           * Jun:
           * @param message_id
           * @return
           */
          public List<Message> findMessageM( int message_i, String message_content );
          
          /**
           * Jun:通过message ID查询消息
           * @param message_id
           * @return
           */
          public Message findByMessage_ID( int message_id );
          
          /**
           * Jun:通过message_publisher查询消息
           * @param message_publisher
           * @return
           */
          public List<Object[]> findByMessage_publisher( int message_publisher);
          
          /**
           * Jun:通过message_receiver查询消息
           * @param message_receiver
           * @return
           */
          public List<Object[]> findByMessage_receiver( int message_receiver);
          
}
