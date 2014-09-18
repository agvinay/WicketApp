package com.gcn.utilities;

import java.io.Serializable;

public class DemurrageServices implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int service_id;
	private String short_desc;
	private String detailed_desc;
	private int wage;
	private String wage_unit;
	private int duration;
	private String duration_unit;
	private String job_city;
	private String job_state;
	private String job_country;
	private String employer_name;
	private String employer_desc;
	private String employer_address;
	
	public int getService_id() {
		return service_id;
	}
	public void setService_id(int service_id) {
		this.service_id = service_id;
	}
	public String getShort_desc() {
		return short_desc;
	}
	public void setShort_desc(String short_desc) {
		this.short_desc = short_desc;
	}
	public String getDetailed_desc() {
		return detailed_desc;
	}
	public void setDetailed_desc(String detailed_desc) {
		this.detailed_desc = detailed_desc;
	}
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		this.wage = wage;
	}
	public String getWage_unit() {
		return wage_unit;
	}
	public void setWage_unit(String wage_unit) {
		this.wage_unit = wage_unit;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getDuration_unit() {
		return duration_unit;
	}
	public void setDuration_unit(String duration_unit) {
		this.duration_unit = duration_unit;
	}
	public String getJob_city() {
		return job_city;
	}
	public void setJob_city(String job_city) {
		this.job_city = job_city;
	}
	public String getJob_state() {
		return job_state;
	}
	public void setJob_state(String job_state) {
		this.job_state = job_state;
	}
	public String getJob_country() {
		return job_country;
	}
	public void setJob_country(String job_country) {
		this.job_country = job_country;
	}
	public String getEmployer_name() {
		return employer_name;
	}
	public void setEmployer_name(String employer_name) {
		this.employer_name = employer_name;
	}
	public String getEmployer_desc() {
		return employer_desc;
	}
	public void setEmployer_desc(String employer_desc) {
		this.employer_desc = employer_desc;
	}
	public String getEmployer_address() {
		return employer_address;
	}
	public void setEmployer_address(String employer_address) {
		this.employer_address = employer_address;
	}
	

}
