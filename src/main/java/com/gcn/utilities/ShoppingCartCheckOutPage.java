package com.gcn.utilities;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.gcn.HomePage;
import com.gcn.shoppingcart.DemurrageMakePayment;


public class ShoppingCartCheckOutPage extends WebPage{

	public PageableListView<?> plvshopcart;
	//public PagingNavigator navigator;
	 	
	private static final long serialVersionUID = 1L;

	public ShoppingCartCheckOutPage() {
		//super(id);
		ArrayList<DemurrageProduct> sessshopcart = ((DemurrageSession)Session.get()).getShoppingCart();
		plvshopcart = DemurrageShoppingCartProductshow(sessshopcart);
		add(plvshopcart);
		add(new Link("makepayment"){
			
			private static final long serialVersionUID = 1L;

			public void onClick(){
				setResponsePage(DemurrageMakePayment.class);
				
			}
		});
		
		add(new Link("continueshopping"){
			
			private static final long serialVersionUID = 1L;

			public void onClick(){
				setResponsePage(HomePage.class);
				
			}
		});
		
		
		/*navigator = new PagingNavigator("navigator", plvshopcart);
		add(navigator);*/
		
	}
	
		
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  PageableListView<?> DemurrageShoppingCartProductshow(final ArrayList<DemurrageProduct> aldpdcart)
	{
		 
		plvshopcart = new PageableListView<Object>("shopcart", aldpdcart,10) { 
			int counter=0;
			
			
			 
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("rawtypes")
			@Override
	    	 protected void populateItem(ListItem  item) {
				 counter = counter+1;
				 System.out.println("value of counter======="+counter);
				 
	    		 final DemurrageProduct dpd = (DemurrageProduct)item.getModelObject();
		 	    			    		 
	    		 item.add(new Label("prodid", new PropertyModel(dpd, "product_id")));
	    		 item.add(new Label("prod_name", new PropertyModel(dpd, "product_name")));    		   
	    		 item.add(new Label("short_desc", new PropertyModel(dpd, "short_description")));
	    		 item.add(new Label("price", new PropertyModel(dpd, "price")));    		   
	    		 item.add(new Label("brand", new PropertyModel(dpd, "brand")));
	    		 item.add(new Label("model", new PropertyModel(dpd, "model")));    		   
	    		 item.add(new Label("type", new PropertyModel(dpd, "type")));
	    		 item.add(new Image("img",new PropertyModel(dpd, "prodimage")));
	    		 item.add(new Label("qtyordered", new PropertyModel(dpd, "qtyordered")));
	    		 Form removecartform = new Form("removecartform",new CompoundPropertyModel(dpd))
	    		 {
					private static final long serialVersionUID = 1L;
					protected void onSubmit()
					{
						aldpdcart.remove(dpd);
						
					}
	    			 
	    		 };
	    		 removecartform.add(new Button("submitremovecart"));
	    		 item.add(removecartform);
	    		 
	 				    		 	    		 
	    		 System.out.println("prod desc in listview="+dpd.getProduct_name());
	    		 System.out.println("image name="+dpd.getProdimage());
	    		 
	    	 } 
			
		};
		System.out.println("in dp shopping cart page");
		add(new Label("totalprice",new Model(){
			
			private static final long serialVersionUID = 1L;

			@Override
			public Serializable getObject() {
			Float price=new Float(0.0);
			//NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.GERMAN);
			for(int i=0;i<aldpdcart.size();i++)
			{
				price = price +( aldpdcart.get(i).getPrice() * aldpdcart.get(i).getQtyordered()) ;
			}
			
			return price.toString();
			}
		}));
		
        add(new Label("totalqty",new Model(){
			
			private static final long serialVersionUID = 1L;

			@Override
			public Serializable getObject() {
			//int qty=0;
			//NumberFormat nf = NumberFormat.getIntegerInstance();
			Integer qty = new Integer(0);
			for(int i=0;i<aldpdcart.size();i++)
			{
				qty = qty + aldpdcart.get(i).getQtyordered();
			}
			
			return qty.toString();
			}
		}));
				
		
		return plvshopcart;
		
		}     
}
