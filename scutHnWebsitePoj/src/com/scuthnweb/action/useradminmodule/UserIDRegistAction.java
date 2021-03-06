package com.scuthnweb.action.useradminmodule;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.service.interf.UserAdminModule;

public class UserIDRegistAction extends ActionSupport{
    
	private  UserAdminModule userAdminModule;

	private String customer_name, customer_password, confirm_password, customer_grade, customer_major,customer_email,customer_room,customer_phone,customer_qq; 
	private int customer_sex;

	public String execute(){
		ActionContext ctx = ActionContext.getContext();
		if(!this.confirm_password.equals(this.customer_password))
			return ERROR;
		BaseCustomer cs = this.userAdminModule.userIDResgist(customer_name, customer_password, customer_sex, customer_grade, customer_major, customer_phone, customer_qq, customer_email, customer_room);
		if(cs==null)
			return INPUT;
		ctx.getSession().put("customer",cs);
	    return SUCCESS;
	}
	
	public  void validate(){
		
	//校验用户姓名
	String regexName = "^([\\u4E00-\\u9FA5]{2,4})$";
    if( !Pattern.matches(regexName, this.customer_name)){
    	System.out.println(1);
		    this.addFieldError("customer_name","用户姓名必须由2～4个简体中文字符组成");
    }
			
	//校验用户密码
	String regexPassword = "^\\w{5,20}$";
	if( !Pattern.matches(regexPassword, String.valueOf( this.customer_password )) ){
		System.out.println(2);	    
		    this.addFieldError("customer_password", "用户密码由5～20个数字或英文字母组成");
	}
	
	
	//校验年级
	String regexGrade = "^2([\\w]{3})$";
	if( !Pattern.matches(regexGrade, this.customer_grade) ){
		System.out.println(3);
	    
		    this.addFieldError("customer_grade", "年级格式为 2XXX,比如 2013");}
	
	//У校验专业
	String regexMajor = "^([\\u4E00-\\u9FA5]{2,50})$";
	if( !Pattern.matches(regexMajor, this.customer_major) ){
		System.out.println(4);		   
		this.addFieldError("customer_major", "专业名称由2～50个简体中文字符组成");	
	}
	String customer_major;
	
	/**
	 * int ̫С�ˣ�������32λ�����޷����ճ���Ϊ11���������֣�����
	 */
	//校验电话号码 customer_phone
	String regexPhone = "^([\\d]{11})$";
	if( !Pattern.matches(regexPhone, String.valueOf( this.customer_phone ) )){
		System.out.println(5);
	    
		   this.addFieldError("customer_phone", "�绰���볤�ȴ��󣡵绰����Ϊ����11�������ַ�");
	}
	
	//校验QQ customer_qq
	String regexQq = "^(\\d{5,20})$";
	if( !Pattern.matches(regexQq, String.valueOf(this.customer_qq)) ){
		System.out.println(6 );		   
		this.addFieldError("customer_qq", "qq��ʽΪ����5~11�������ַ�");
	}	
	//校验邮箱 customer_email
    String regexEmail = "^(\\w{2,25}@)(\\w{2,25})(\\.(com|cn))$";	    
    if(!Pattern.matches(regexEmail, this.customer_email)){
    	System.out.println(7);
	    
    	this.addFieldError("customer_email", "邮箱格式为 xxx@xxx.com 或 xxx@xxx.cn");
    }
    
    if( this.customer_email.length()>50 ){
    	System.out.println(8);
	    
    	this.addFieldError("customer_email", "邮箱长度不能超过50");
    }
	//校验宿舍号 customer_room
	String regexRoom = "^([\\u4E00-\\u9FA5\\w]{5,20})$";
	if(!Pattern.matches(regexRoom, this.customer_room)){
		System.out.println(9);
	    
		this.addFieldError("customer_room", "宿舍地址由5～20个简体中文或英文字母与数字构成" );	
	 }
   }

	public UserAdminModule getUserAdminModule() {
		return userAdminModule;
	}

	public void setUserAdminModule(UserAdminModule userAdminModule) {
		this.userAdminModule = userAdminModule;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}

	public String getCustomer_grade() {
		return customer_grade;
	}

	public void setCustomer_grade(String customer_grade) {
		this.customer_grade = customer_grade;
	}

	public String getCustomer_major() {
		return customer_major;
	}

	public void setCustomer_major(String customer_major) {
		this.customer_major = customer_major;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_room() {
		return customer_room;
	}

	public void setCustomer_room(String customer_room) {
		this.customer_room = customer_room;
	}

	public int getCustomer_sex() {
		return customer_sex;
	}

	public void setCustomer_sex(int customer_sex) {
		this.customer_sex = customer_sex;
	}

	public String getCustomer_phone() {
		return customer_phone;
	}

	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}

	public String getCustomer_qq() {
		return customer_qq;
	}

	public void setCustomer_qq(String customer_qq) {
		this.customer_qq = customer_qq;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
}
