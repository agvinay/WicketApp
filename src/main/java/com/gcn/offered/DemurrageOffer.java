package com.gcn.offered;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

public class DemurrageOffer extends Panel{
	
	public DemurrageProductSellPanel dsellprod = new DemurrageProductSellPanel("offer");
	public DemurrageServiceOfferPanel dofferservice = new DemurrageServiceOfferPanel("offer");
	public DemurrageJobOfferPanel dofferjob = new DemurrageJobOfferPanel("offer");
	public Panel current = dsellprod;
	
	public DemurrageOffer(String id)
	{
		super(id);
		add(new Link<String>("Offer Products") {
	  	      private static final long serialVersionUID = 1L;
	  	     
	  	      @Override
	  	      public void onClick() {   
	  	    	  
	  	    	  current.replaceWith(dsellprod);
	  	    	  current = dsellprod;
	  	    	
	            }
	  	      /*@Override
	  	  	  public boolean isEnabled() {
	  	    	  return current != sot;
	  	  	  }*/
	  	});
			
			add(new Link<String>("Offer Services") {
	  	      private static final long serialVersionUID = 1L;
	  	     
	  	      @Override
	  	      public void onClick() { 
	  	    	  
	  	    	current.replaceWith(dofferservice);
	  	    	  current = dofferservice;
	  	    	  
	            }
	  	      
	  	});
			
			add(new Link<String>("Offer Jobs") {
	  	      private static final long serialVersionUID = 1L;
	  	     
	  	      @Override
	  	      public void onClick() {
	  	    	  
	  	    	current.replaceWith(dofferjob);
	  	    	  current = dofferjob;
	  	    	  
	            }
	  	     
	  	});
			
		add(current);
		
	}
}
