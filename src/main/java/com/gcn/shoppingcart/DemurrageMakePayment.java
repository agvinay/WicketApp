package com.gcn.shoppingcart;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

import com.gcn.HomePage;
import com.gcn.utilities.DemurrageCustomer;
import com.gcn.utilities.DemurrageDBManager;
import com.gcn.utilities.DemurrageProduct;
import com.gcn.utilities.DemurrageSession;

public class DemurrageMakePayment extends WebPage{
	
	private static final long serialVersionUID = 1L;

	public DemurrageMakePayment()
	{
		int arraylistcounter;
		String insertquery;
		String updatequery;
		int customer_id;
		int product_id;
		int product_subcat_id;
		int quantity_ordered;
		float totalprice;
		int updateqty;
		String prodtablename;
		ArrayList<DemurrageProduct> sessshopcart = ((DemurrageSession)Session.get()).getShoppingCart();
		DemurrageCustomer dc= ((DemurrageSession)Session.get()).getDemurrageUser();
		
		final FeedbackPanel paymentFeedback = new FeedbackPanel("paymentFeedback");
		add(paymentFeedback);
		
		DemurrageDBManager dbc = new DemurrageDBManager();
		Connection con = dbc.getDbConnection();
		try
		{

			Statement stmtfinalpayment = con.createStatement();
			
			for(arraylistcounter=0;arraylistcounter<sessshopcart.size();arraylistcounter++)
			{
				customer_id = dc.getCustomerid();
				
				product_id = sessshopcart.get(arraylistcounter).getProduct_id();
				product_subcat_id = sessshopcart.get(arraylistcounter).getProduct_subcat_id();
				quantity_ordered = sessshopcart.get(arraylistcounter).getQtyordered();
				prodtablename = sessshopcart.get(arraylistcounter).getProducttablename();
				totalprice = sessshopcart.get(arraylistcounter).getPrice() * sessshopcart.get(arraylistcounter).getQtyordered();
				insertquery = " Insert into t_shopcart_transaction (customer_id,prod_id,prod_subcat_id,qty_ordered,totalprice) values("+customer_id+","+product_id+","+product_subcat_id+","+quantity_ordered+","+totalprice+")";
				System.out.println("Insert query="+insertquery);
				updateqty = sessshopcart.get(arraylistcounter).getQty() - quantity_ordered;
				updatequery = "Update "+prodtablename+" set qty="+updateqty+" where product_id="+product_id;
				System.out.println("update query="+updatequery);
								
				stmtfinalpayment.executeUpdate(insertquery);
				stmtfinalpayment.executeUpdate(updatequery);
				
				
			}
			info("Payment received successfully");
			((DemurrageSession)Session.get()).setShoppingCart(null);
			
			dbc.closeDbConnection();
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			info("Some error on page contact administrator.");
		}
		
		add(new Link<String>("mainpage"){
			
			private static final long serialVersionUID = 1L;

			public void onClick() {
				setResponsePage(HomePage.class);
			}
		});
	}

}
