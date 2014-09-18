package com.gcn.wanted;

import java.util.ArrayList;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.panel.Panel;

import com.gcn.search.DemurrageSearchPanel;
import com.gcn.shoppingcart.DemurrageCart;
import com.gcn.utilities.DemurrageCategoryPresentation;
import com.gcn.utilities.DemurrageCustomer;
import com.gcn.utilities.DemurrageProduct;
import com.gcn.utilities.DemurrageProductPresentation;
import com.gcn.utilities.DemurrageSession;

public class DemurrageWantProductPanel extends Panel{
	
		
         
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// code for first time default search
 	//DemurrageProduct dpini = new DemurrageProduct();
 	@SuppressWarnings({ "rawtypes", "unchecked" })
	//ArrayList <DemurrageProduct> aldpini = new ArrayList();
 	//public static DemurrageProductPresentation prdprespanel;
 	public DemurrageViewController dViewController;
 	
	
	
    public DemurrageWantProductPanel(String id, DemurrageCart shoppingcartpanel) {
    	super(id);
    	         	    	
    	/*//code for initial search
    			dpini.setProduct_id(1);
    			dpini.setProduct_subcat_id(1);
    			dpini.setProduct_name("Offer 1");
    			dpini.setShort_description("Attractive Offer 1");
    			aldpini.add(dpini);*/
    			
        
    	//prdprespanel = new DemurrageProductPresentation("dpprespanel",shoppingcartpanel,aldpini);
    	this.dViewController = new DemurrageViewController("viewcontroller", shoppingcartpanel, "PRODUCTS");
		add(dViewController);
    	
    	add(new DemurrageSearchPanel("searchpanel",dViewController,"PRODUCTS"));
    	add(new DemurrageCategoryPresentation("productcategories",dViewController));
    	

	    }

}
