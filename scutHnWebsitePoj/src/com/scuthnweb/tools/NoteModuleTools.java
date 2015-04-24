package com.scuthnweb.tools;
/**
 * noteModule 工具类
 * @author mac
 *
 */
public class NoteModuleTools {
	/**
	 * Jun:返回对应的信息类别String
	 * @param type
	 * @return
	 */
    public static String convertTypeToString(int type){
    	switch(type){
    	  case 0:return "事务通知";
    	  case 1:return "活动总结";
    	  case 2:return  "大杂烩";
    	  default:return  "自定义";
    	}
    }
}
