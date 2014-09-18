package com.gcn.wanted;

import java.util.ArrayList;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

import com.gcn.search.DemurrageSearchPanel;
import com.gcn.shoppingcart.DemurrageCart;
import com.gcn.utilities.DemurrageProduct;
import com.gcn.utilities.DemurrageProductPresentation;
import com.gcn.utilities.DemurrageServices;
import com.gcn.utilities.DemurrageServicesCategoryPresentation;
import com.gcn.utilities.DemurrageServicesPresentation;

public class DemurrageWantServicePanel extends Panel {
	
	
	private static final long serialVersionUID = 1L; 
	public DemurrageViewController dViewController;
	
	public DemurrageWantServicePanel(String id)
	{
		super(id); 
		this.dViewController = new DemurrageViewController("viewcontroller", null, "SERVICES");
		add(dViewController);
		add(new DemurrageSearchPanel("searchpanel",dViewController,"SERVICES"));
		add(new DemurrageServicesCategoryPresentation("servicecategories"));
		
		//add(new Label("temp","Service Under Construction"));
	}

}
