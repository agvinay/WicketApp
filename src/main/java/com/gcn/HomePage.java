package com.gcn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

import org.apache.wicket.Session;
import org.apache.wicket.extensions.markup.html.captcha.CaptchaImageResource;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.TabbedPanel;
import org.apache.wicket.extensions.markup.html.tree.Tree;
import org.apache.wicket.extensions.*;


import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.tree.LinkType;
import org.apache.wicket.model.Model;

import com.gcn.authorization.DemurrageLogin;
import com.gcn.authorization.DemurrageRegistration;
import com.gcn.authorization.DemurrageLogout;
import com.gcn.offered.DemurrageOffer;
import com.gcn.search.DemurrageSearchPanel;
import com.gcn.shoppingcart.DemurrageCart;
import com.gcn.utilities.DemurrageCategoryPresentation;
import com.gcn.utilities.DemurrageCustomer;
import com.gcn.utilities.DemurrageProduct;
import com.gcn.utilities.DemurrageProductPresentation;
import com.gcn.utilities.DemurrageSession;
import com.gcn.utilities.DemurrageUploadPage;
import com.gcn.wanted.DemurrageWant;

public class HomePage extends WebPage {
	
	
	

    public DemurrageWant wantedtab = new DemurrageWant("maintab");
    public DemurrageOffer offerredtab = new DemurrageOffer("maintab");
    public Panel current = wantedtab;
    
    public HomePage() {
    	super();
    	
    	// Add CSS definitions for use in all pages
          	String firstname="Guest";
    	
    	final DemurrageCustomer dc= ((DemurrageSession)Session.get()).getDemurrageUser();	
    	
    	   	
    	add(new Link<String>("login"){
    		private static final long serialVersionUID = 1L;
   		 
    		@Override
  	      	public void onClick() {
    			
    			setResponsePage(DemurrageLogin.class);
		
    		}
    		
    		@Override
    	      public boolean isVisible()
    	      {
  			
    	    	  return (dc == null);
    	    	  
    	      }
     	});
    	
    	   	
    	
    	add(new Link<String>("logout"){
    		private static final long serialVersionUID = 1L;
    		 
    		@Override
  	      	public void onClick() {
    			
    			DemurrageLogout lp = new DemurrageLogout();
    			
    			setResponsePage(HomePage.class);
  			
    		}
    		
    		@Override
    	      public boolean isVisible()
    	      {
  			
    	    	  return (dc != null);
    	    	  
    	      }
   		
    	});
    			
    	
    	
    	add(new Link<String>("wanted") {
    		private static final long serialVersionUID = 1L;
 
    		@Override
  	      	public void onClick() {  	      	    	  
    			current.replaceWith(wantedtab);
    			current = wantedtab;
  	  	    }
    		@Override
    		public boolean isEnabled() {
    			return current != wantedtab;
    		}
  	    });
    	
    	add(new Link<String>("offered") {
    	      private static final long serialVersionUID = 1L;
    	     
    	      @Override
    	      public void onClick() {   	         	    	  
    	    	  current.replaceWith(offerredtab);
    	    	  current = offerredtab;
              }
    	      @Override
    	  	  public boolean isEnabled() {
    	    	  return current != offerredtab;
    	  	  }
    	});
    	
    	add(current);
    	
    	
    	
    	    	
    	add(new Link<String>("registration") {
  	      private static final long serialVersionUID = 1L;
  	     
  	      @Override
  	      public void onClick() {   	         	    	  
  	    	/*currentprodandregpnl.replaceWith(demrregistrationpanel);
  	    	currentprodandregpnl = demrregistrationpanel;*/
  	    	  
  	    	setResponsePage(DemurrageRegistration.class);
            }
  	      @Override
  	  	  public boolean isEnabled() {
  	    	  //return currentprodandregpnl != demrregistrationpanel;
  	    	  return true;
  	  	  }
  	    
  	      @Override
  	      public boolean isVisible()
  	      {
			
  	    	  return (dc == null);
  	    	  
  	      }
  	});
    	
    	if (dc != null)
    	{
    		firstname= dc.getFirstname();
    		
    		
    	}
    	add(new Label("firstname",firstname));
    	
    	
    	
    	
	    }
    
 } 
