package com.erp.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

	@Entity
	@Table(name="SPRING_LOGIN")
	public class EmployeeMaster {
		private int id;
		private String name;
		private String password;
		private String role;

		
		public EmployeeMaster() {
			System.out.println("EmployeeMaster:0-param constructor");
		}

		@Id
		@GenericGenerator(name="gen1",strategy="increment")
		@GeneratedValue(generator="gen1")
		@Column(nullable=false)
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		 
		@Column(length=30,nullable=false)
		@Type(type="string")
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		@Column(length=30,nullable=false)
		@Type(type="string")
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

		@Column(length=30,nullable=false)
		@Type(type="string")
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
	}

