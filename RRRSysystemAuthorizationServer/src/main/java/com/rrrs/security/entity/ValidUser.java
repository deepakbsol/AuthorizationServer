package com.rrrs.security.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
@Entity
@Table(name="RRR_REGISTERED_USER")
public class ValidUser implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RRR_REGISTERED_USER_SEQ")
	@SequenceGenerator(name="RRR_REGISTERED_USER_SEQ", sequenceName = "RRR_REGISTERED_USER_SEQ" ,allocationSize = 1)
	@Column(name = "USER_ID")
	private int userId;
	@Column(name="USER_FIRSTNAME",length = 45)
	private String firstName;
	@Column(name = "USER_LASTNAME",length = 45,nullable = true)
	private String lastName;
	@Column(name = "USER_USERNAME",unique = true,length = 45)
	private String username;
	@Column(name = "USER_ROLE_ID",nullable = false)
	private int roleId;
	@Column(name = "USER_CONTACT_NO",length = 15,nullable = false)
	private String contactNo;
	@Column(name = "USER_EMAIL",length = 45,nullable = false)
	private String email;
	@Column(name="USER_PASSWORD",length = 500,nullable = false)
	private String password;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	@Column(name = "START_DATE")
	private Date validatyStartDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	@Column(name = "END_DATE")
	private Date validatyEndDate;
	@Column(name = "COMPANY_ID",length = 15,nullable = false)
	private String companyId;
	@Column(name = "CREATED_BY",length = 45,nullable = false)
	private String createdBy;
	@Column(name = "Date_INS",nullable = false)
	private Date dateOfInsertatio=new Date();
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getValidatyStartDate() {
		return validatyStartDate;
	}
	public void setValidatyStartDate(Date validatyStartDate) {
		this.validatyStartDate = validatyStartDate;
	}
	public Date getValidatyEndDate() {
		return validatyEndDate;
	}
	public void setValidatyEndDate(Date validatyEndDate) {
		this.validatyEndDate = validatyEndDate;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getDateOfInsertatio() {
		return dateOfInsertatio;
	}
	public void setDateOfInsertatio(Date dateOfInsertatio) {
		this.dateOfInsertatio = new Date();
	}
	@Override
	public String toString() {
		return "ValidUser [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", roleId=" + roleId + ", contactNo=" + contactNo + ", email=" + email + ", password="
				+ password + ", validatyStartDate=" + validatyStartDate + ", validatyEndDate=" + validatyEndDate
				+ ", companyId=" + companyId + ", createdBy=" + createdBy + ", dateOfInsertatio=" + dateOfInsertatio
				+ "]";
	}
	

}
