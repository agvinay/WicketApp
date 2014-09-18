package com.gcn.utilities;

import java.io.Serializable;

public class DemurrageSubCategory extends DemurrageCategory implements Serializable{
	
	private int subcat_id;
	private String subcat_name;
	
		
	/*public DemurrageSubCategory(int cat_id) {
		super(cat_id);
	}*/
	
	public int getSubcat_id() {
		return subcat_id;
	}
	public void setSubcat_id(int subcat_id) {
		this.subcat_id = subcat_id;
	}
	public String getSubcat_name() {
		return subcat_name;
	}
	public void setSubcat_name(String subcat_name) {
		this.subcat_name = subcat_name;
	}
	
	

}
