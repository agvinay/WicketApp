package com.gcn.wanted;

import java.util.ArrayList;

import org.apache.wicket.markup.html.panel.Panel;

import com.gcn.shoppingcart.DemurrageCart;
import com.gcn.utilities.DemurrageProduct;
import com.gcn.utilities.DemurrageProductPresentation;
import com.gcn.utilities.DemurrageServices;
import com.gcn.utilities.DemurrageServicesPresentation;

public class DemurrageViewController extends Panel{
	
	public DemurrageWelcomePanel dWelcome =new DemurrageWelcomePanel("view");
	public DemurrageProductPresentation prdprespanel;
	public Panel current = dWelcome;
 	public static DemurrageServicesPresentation serviceprespanel;
	
	public DemurrageViewController(String pname, DemurrageCart shoppingcartpanel, String forTab){
		super(pname);
		if(forTab == "PRODUCTS"){
			DemurrageProduct dpini = new DemurrageProduct();
			ArrayList <DemurrageProduct> aldpini = new ArrayList();
			dpini.setProduct_id(1);
			dpini.setProduct_subcat_id(1);
			dpini.setProduct_name("Offer 1");
			dpini.setShort_description("Attractive Offer 1");
			aldpini.add(dpini);
			prdprespanel = new DemurrageProductPresentation("view",shoppingcartpanel,aldpini);
			add(current);
		}
		else if(forTab == "SERVICES"){
			/*DemurrageServices dserini = new DemurrageServices();
			ArrayList <DemurrageServices> alserviceini = new ArrayList<DemurrageServices>();
			dserini.setDuration(0);
			dserini.setDuration_unit("Hours");
			dserini.setEmployer_address("Demurrage GMBH, Deutschland");
			dserini.setEmployer_desc("Demurrage description");
			dserini.setService_id(1);
			dserini.setShort_desc("Inital highlighted service");	
			alserviceini.add(dserini);
			serviceprespanel = new DemurrageServicesPresentation("serviceprespanel",alserviceini);*/
			add(current);
			//add(serviceprespanel);
			
		}
	}
	
	public void setView(String type, ArrayList<DemurrageProduct> aldpdao){
		if(type == "PRODUCT_LIST_VIEW"){
			prdprespanel.DemurrageProductshp(aldpdao);
			current.replaceWith(prdprespanel);
	    	current=prdprespanel;
		}		
	}

}
