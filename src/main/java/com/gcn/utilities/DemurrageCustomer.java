package com.gcn.utilities;

import java.io.Serializable;
import java.util.Date;

public class DemurrageCustomer implements Serializable{
	
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String streetaddress;
	private String postcode;
	private String city;
	private String state;
	private String country;
	private String dob;
	private String landlinephone;
	private String mobilephone;
	private int secretquestion;
	private String answertoq;
	private String emailid;
	private int customerid;
	
	
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	public String getStreetaddress() {
		return streetaddress;
	}
	public void setStreetaddress(String streetaddress) {
		this.streetaddress = streetaddress;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String string) {
		this.dob = string;
	}
	public String getLandlinephone() {
		return landlinephone;
	}
	public void setLandlinephone(String landlinephone) {
		this.landlinephone = landlinephone;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	public int getSecretquestion() {
		return secretquestion;
	}
	public void setSecretquestion(int secretquestion) {
		this.secretquestion = secretquestion;
	}
	public String getAnswertoq() {
		return answertoq;
	}
	public void setAnswertoq(String answertoq) {
		this.answertoq = answertoq;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	
	

}
