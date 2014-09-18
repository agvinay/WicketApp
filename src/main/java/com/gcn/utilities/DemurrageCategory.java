package com.gcn.utilities;

import java.io.Serializable;

import org.apache.wicket.model.IModel;

public class DemurrageCategory implements Serializable{
	
	private String category_name;
	private int category_id;
	private String category_class;
	private String table_name;
	
	/*public DemurrageCategory(int category_id) {
		this.category_id = category_id;
	}*/
	
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory_class() {
		return category_class;
	}
	public void setCategory_class(String category_class) {
		this.category_class = category_class;
	}
	/*public void detach() {
		// TODO Auto-generated method stub
		
	}
	public Object getObject() {
		// TODO Auto-generated method stub
		return new DemurrageCategory() ;
	}
	public void setObject(Object object) {
		// TODO Auto-generated method stub
				
	}
	*/
	
	

}
