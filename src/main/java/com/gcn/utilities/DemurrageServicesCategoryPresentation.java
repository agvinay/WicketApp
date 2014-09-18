package com.gcn.utilities;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

public class DemurrageServicesCategoryPresentation extends Panel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DemurrageServicesCategoryPresentation(String id)
	{
		super(id);
		
		 // Menu1 
	    add(new Link<String>("Electrician") {
	      private static final long serialVersionUID = 1L;
   
	      @Override
	      public void onClick() {
	       	 
	    	  }
	    });
	    
	   // Menu2
	    add(new Link<String>("Plumber") {
		      private static final long serialVersionUID = 1L;
	   
		      @Override
		      public void onClick() {
		       	 
		    	  }
		    });
	    
	 // Menu3
	    add(new Link<String>("Gardener") {
		      private static final long serialVersionUID = 1L;
	   
		      @Override
		      public void onClick() {
		       	 
		    	  }
		    });
	    
	 // Menu4
	    add(new Link<String>("Cleaner") {
		      private static final long serialVersionUID = 1L;
	   
		      @Override
		      public void onClick() {
		       	 
		    	  }
		    });
	    
	 // Menu5
	    add(new Link<String>("Janitor") {
		      private static final long serialVersionUID = 1L;
	   
		      @Override
		      public void onClick() {
		       	 
		    	  }
		    });
	    
	 // Menu6
	    add(new Link<String>("Helper") {
		      private static final long serialVersionUID = 1L;
	   
		      @Override
		      public void onClick() {
		       	 
		    	  }
		    });
	   
	 // Menu7 
	    add(new Link<String>("Cook") {
		      private static final long serialVersionUID = 1L;
	   
		      @Override
		      public void onClick() {
		       	 
		    	  }
		    });
	}

}
