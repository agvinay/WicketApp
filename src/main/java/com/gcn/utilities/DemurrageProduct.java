package com.gcn.utilities;

import java.io.Serializable;


public class DemurrageProduct implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private int product_id;
	private int product_subcat_id;
	private String short_description;
	private String product_descr;
	private String product_name;
	private int qty;
	private float price;
	private String brand;
	private String model;
	private String type;
	private int qtyordered;
	private String prodimage;
	private String producttablename;
	
	
	
	public String getProducttablename() {
		return producttablename;
	}
	public void setProducttablename(String producttablename) {
		this.producttablename = producttablename;
	}
	public String getProdimage() {
		return prodimage;
	}
	public void setProdimage(String prodimage) {
		this.prodimage = "productimages/"+prodimage;
	}
	public int getQtyordered() {
		return qtyordered;
	}
	public void setQtyordered(int qtyordered) {
		this.qtyordered = qtyordered;
	}
	public String getShort_description() {
		return short_description;
	}
	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getProduct_subcat_id() {
		return product_subcat_id;
	}
	public void setProduct_subcat_id(int product_subcat_id) {
		this.product_subcat_id = product_subcat_id;
	}
	public String getProduct_descr() {
		return product_descr;
	}
	public void setProduct_descr(String product_descr) {
		this.product_descr = product_descr;
	}			

					
}
		
			
		
		


