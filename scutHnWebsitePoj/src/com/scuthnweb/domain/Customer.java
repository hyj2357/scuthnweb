package com.scuthnweb.domain;

import java.util.Set;

public class Customer extends BaseCustomer {
		
		private String name,customer_password,customer_email,customer_grade,
		               customer_major,customer_room;
		
		private int    id,customer_sex,customer_phone,customer_qq,customer_state;
        
		public String getCustomer_password() {
			return customer_password;
		}

		public void setCustomer_password(String customer_password) {
			this.customer_password = customer_password;
		}

		public String getCustomer_email() {
			return customer_email;
		}

		public void setCustomer_email(String customer_email) {
			this.customer_email = customer_email;
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

		public String getCustomer_room() {
			return customer_room;
		}

		public void setCustomer_room(String customer_room) {
			this.customer_room = customer_room;
		}

		public int getCustomer_state() {
			return customer_state;
		}

		public void setCustomer_state(int customer_state) {
			this.customer_state = customer_state;
		}

		public int getCustomer_sex() {
			return customer_sex;
		}

		public void setCustomer_sex(int customer_sex) {
			this.customer_sex = customer_sex;
		}

		public int getCustomer_phone() {
			return customer_phone;
		}

		public void setCustomer_phone(int customer_phone) {
			this.customer_phone = customer_phone;
		}

		public int getCustomer_qq() {
			return customer_qq;
		}

		public void setCustomer_qq(int customer_qq) {
			this.customer_qq = customer_qq;
		}		
}
