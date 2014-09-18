package com.gcn.utilities;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.gcn.authorization.DemurrageLogin;
import com.gcn.shoppingcart.DemurrageCart;
import com.gcn.shoppingcart.ShoppingCart;
import com.gcn.wanted.DemurrageWelcomePanel;

public class DemurrageProductPresentation  extends Panel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	public PageableListView products;
	public PagingNavigator navigator;
	public DemurrageCustomer dc; 
	
	private DemurrageCart shoppingcartpanel;
	int quantityordered;
	/*public ListView current;
	public WebMarkupContainer listContainern;
	public WebMarkupContainer listContainerc;
	public WebMarkupContainer listContainer;*/
	
	
	
	public DemurrageProductPresentation(String pname,DemurrageCart shoppingcartpanel,ArrayList<DemurrageProduct> aldpdao)
	{
		super(pname);
		this.dc = ((DemurrageSession)Session.get()).getDemurrageUser();
		this.shoppingcartpanel = shoppingcartpanel;
		 products= DemurrageProductsh(aldpdao);
		 add(products);
		 navigator = new PagingNavigator("navigator", products);
		 add(navigator);
		 /*listContainer = new WebMarkupContainer("theContainer");
		 //generate a markup-id so the contents can be updated through an AJAX call
		 listContainer.setOutputMarkupId(true);
		 listContainer.add(lvpda);
		 // finally add the container to the page
		 add(listContainer);*/
		 
		
	}
	
	public void DemurrageProductshp(ArrayList<DemurrageProduct> aldpdao)
	{
		//DemurrageProductDao dp;
		int i=0;
		while(i<aldpdao.size())
		{
			System.out.println("+++++++"+aldpdao.get(i).getProduct_descr());
			i++;
		
		}
		products= DemurrageProductsh(aldpdao);
		replace(products);
		navigator = new PagingNavigator("navigator", products);
		replace(navigator);
		//listContainer.replace(lvpda);
		//Iterator itr = aldpdao.iterator();
		
		//current= lvpda;
		//current.replace(lvpda);
		//add(lvpda);
		//aldpdao.clear();
		//listContainerc =listContainer;
		//listContainerc.replace(listContainern);
		//add(listContainerc);
		
	} 
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  PageableListView DemurrageProductsh(ArrayList<DemurrageProduct> aldpdao)
	{
		    
		products = new PageableListView("products", aldpdao,10) { 
	    	
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("rawtypes")
			@Override
	    	 protected void populateItem(ListItem  item) {
	    		 final DemurrageProduct dpd = (DemurrageProduct)item.getModelObject();
		 	    			    		 
	    		 item.add(new Label("prodid", new PropertyModel(dpd, "product_id")));
	    		 item.add(new Label("prod_name", new PropertyModel(dpd, "product_name")));    		   
	    		 item.add(new Label("short_desc", new PropertyModel(dpd, "short_description")));
	    		 item.add(new Label("qty", new PropertyModel(dpd, "qty")));
	    		 item.add(new Label("price", new PropertyModel(dpd, "price")));    		   
	    		 item.add(new Label("brand", new PropertyModel(dpd, "brand")));
	    		 item.add(new Label("model", new PropertyModel(dpd, "model")));    		   
	    		 item.add(new Label("type", new PropertyModel(dpd, "type")));
	    		 item.add(new Image("img",new PropertyModel(dpd, "prodimage")));
	    		 System.out.println("image data==++++--------====="+dpd.getProdimage());
	    		 final TextField qtyordered = new TextField("qtyordered");
	    		 Form qtyorderedform = new Form("qtyorderedform",new CompoundPropertyModel(dpd))
	    		 {
					private static final long serialVersionUID = 1L;
					protected void onSubmit()
					{
						if(dc != null){
							quantityordered= (Integer) ( qtyordered.getModelObject());
							dpd.setQtyordered(quantityordered);
							System.out.println("quantity ordered========"+quantityordered);
							System.out.println("added:>>>>>>>>>>>"+dpd.getProduct_id());
							shoppingcartpanel.updateCart(dpd);
						}
						else{
							setResponsePage(DemurrageLogin.class);
						}
					}
	    			 
	    		 };
	    		 add(qtyorderedform);
	    		 
	    		 qtyorderedform.add(qtyordered);
	    		 qtyorderedform.add(new Button("submitqtyordered"));
	    		 item.add(qtyorderedform);
	    		 /*item.add(new Link("addtocart", item.getModel())
	    		 {

					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						
						temp = 	(String) qtyordered.getModelObject();
						System.out.println("quantity ordered========"+temp);
						System.out.println("added:>>>>>>>>>>>"+dpd.getProduct_id());
						shoppingcartpanel.updateCart(dpd);
						
					}
	    			 
	    			 
	    		 });*/
	    		 
	    		 System.out.println("prod desc in listview="+dpd.getProduct_name());
	    	 } 
		};
		System.out.println("in dp prod page");
		return products;
	}	
	

}
