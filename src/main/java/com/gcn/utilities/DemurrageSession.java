package com.gcn.utilities;

import java.util.ArrayList;
import java.util.Locale;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

import com.gcn.shoppingcart.ShoppingCart;

public class DemurrageSession extends WebSession {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public static DemurrageSession get() {
		return (DemurrageSession) Session.get();
		}
	
		private DemurrageCustomer user;
		public ArrayList<DemurrageProduct> alshopcart;
		
		public DemurrageSession(Request request) {
		super(request);
		setLocale(Locale.GERMAN);
		}
		
		public synchronized DemurrageCustomer getDemurrageUser() {
		return user;
		}
		
		public synchronized ArrayList<DemurrageProduct> getShoppingCart() {
		return alshopcart;
		}
		
		public synchronized boolean isAuthenticated() {
		return (user != null);
		}
		
		public synchronized boolean isCartEmpty() {
			return (alshopcart != null);
			}
		
		public synchronized void setDemurrageUser(DemurrageCustomer user) {
		this.user = user;
		dirty();
		}
		
		public synchronized void setShoppingCart(ArrayList<DemurrageProduct> alshopcart2) {
			this.alshopcart = alshopcart2;
			dirty();
			}
		
		public DemurrageSession getDemurrageSession()
		{
			return (DemurrageSession) Session.get();
			
		}
		
}
