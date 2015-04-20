package com.scuthnweb.service.interf;

import java.util.Map;

import com.scuthnweb.domain.Message;

public interface MessageModule {
	
	 /**
	  * Jun:查看所有接收到的消息
	  * @param message_receiver
	  * @return
	  */
      public Map<String,String> checkReceiveMessages(int message_receiver);
      
      /**
       * Jun:查看所有发送出的消息
       * @param message_publisher
       * @return
       */
      public Map<String,String> checkPublishMessages(int message_publisher);
      
      /**
       * Jun:查看单条消息
       * @param message_id
       * @return
       */
      public Message checkMessage(int message_id);
}
