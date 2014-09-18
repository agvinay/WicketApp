package com.gcn.wanted;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

import com.gcn.shoppingcart.DemurrageCart;

public class DemurrageWant extends Panel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DemurrageWantProductPanel dwantprod;
	public DemurrageWantServicePanel dwantservice;
	public DemurrageWantJobPanel dwantjob;
	DemurrageCart shoppingcart;
	public Panel current;
	
	
	public DemurrageWant(String panelid)
	{
		super(panelid);
			
		this.shoppingcart = new DemurrageCart("shoppingcart");
		this.dwantprod = new DemurrageWantProductPanel("want", shoppingcart);
		this.dwantservice = new DemurrageWantServicePanel("want");
		this.dwantjob = new DemurrageWantJobPanel("want");
		
		current = dwantprod;
		
		
		add(new Link<String>("Want Products") {
  	      private static final long serialVersionUID = 1L;
  	     
  	      @Override
  	      public void onClick() {   
  	    	  
  	    	  current.replaceWith(dwantprod);
  	    	  current=dwantprod;
  	    	  
            }
  	      /*@Override
  	  	  public boolean isEnabled() {
  	    	  return current != sot;
  	  	  }*/
  	});
		
		add(new Link<String>("Want Services") {
  	      private static final long serialVersionUID = 1L;
  	     
  	      @Override
  	      public void onClick() {
  	    	  
  	    	  current.replaceWith(dwantservice);
	    	  current=dwantservice;
  	    	  
            }
  	      
  	});
		
		add(new Link<String>("Want Jobs") {
  	      private static final long serialVersionUID = 1L;
  	     
  	      @Override
  	      public void onClick() { 
  	    	  
  	    	 current.replaceWith(dwantjob);
	    	  current=dwantjob;
  	    	  
            }
  	     
  	});
	
	add(current);	
	add(shoppingcart);
	}

}
