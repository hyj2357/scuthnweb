package com.scuthnweb.service.interf;

import java.util.List;
import java.util.Map;

import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Share_link;

public interface ResLinkModule {
	
	/**
	 * Jun:删除id指向的链接
	 * @validate  no
	 * @intercept yes
	 * @param share_link_id
	 * @return
	 */
	public boolean delLink( Share_link sl , BaseCustomer share_link_publisher);
	
	
	/**
	 * Jun:审核链接
	 * @validate  no
	 * @intercept yes
	 * @param sl
	 * @param share_link_publisher
	 * @param accept
	 * @return
	 */
	public boolean op_link( Share_link sl, Admin admin, boolean accept);
	
	
	/**
	 * Jun:修改更新链接
	 * @validate  yes
	 * @intercept yes
	 * @param share_link_id
	 * @param share_link_publisher
	 * @param share_link_name
	 * @param share_link_Content
	 * @return
	 */
	public boolean updateLink(Share_link sl,BaseCustomer share_link_publisher,String share_link_name, String share_link_content);
	
	
	/**
	 * Jun:上传链接
	 * @validate  yes
	 * @intercept yes
	 * @param share_link_publisher
	 * @param share_link_name
	 * @param share_link_content
	 * @return
	 */
	public boolean uploadLink( BaseCustomer share_link_publisher,String share_link_name,String share_link_content);

	
	/**
	 * Jun:查看所有的资源链接
	 * @validate  no
	 * @intercept no 
	 * @param isAdmin
	 * @return
	 */
	public Map<String,String> checkAllResLink( boolean isAdmin);
	

	/**
	 * Jun:查看上传的资源链接
	 * @validate  no
	 * @intercept yes 
	 * @param share_link_publisher
	 * @return
	 */
	public Map<String,String> checkUploadLink( BaseCustomer share_link_publisher );
	
	
	/**
	 * Jun:管理员查看所有待审核的链接
	 * @validate  no
	 * @intercept yes
	 * @return
	 */
	public Map<String,String> checkVerifyLink( );
	
	/**
	 * Jun:根据 share_link_id 查看链接
	 * @param share_link_id
	 * @return
	 */
	public Share_link checkLink(int share_link_id);
}
