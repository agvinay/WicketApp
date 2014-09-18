package com.gcn.shoppingcart;

import java.io.Serializable;
import java.util.ArrayList;

import com.gcn.utilities.DemurrageProduct;

public class ShoppingCart implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<DemurrageProduct> shopcart;

	public ArrayList<DemurrageProduct> getShopcart() {
		return shopcart;
	}

	public void setShopcart(ArrayList<DemurrageProduct> shopcart) {
		this.shopcart = shopcart;
	}
	

}
