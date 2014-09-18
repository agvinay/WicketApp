package com.gcn.shoppingcart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.validation.IFormValidator;
import org.apache.wicket.markup.html.panel.Panel;
import com.gcn.utilities.DemurrageCustomer;
import com.gcn.utilities.DemurrageDBManager;
import com.gcn.utilities.DemurrageProduct;
import com.gcn.utilities.DemurrageSession;
import com.gcn.utilities.ShoppingCartCheckOutPage;

public class DemurrageCart extends Panel{
	

	private static final long serialVersionUID = 1L;
	public ArrayList<DemurrageProduct> alshopcart= new ArrayList<DemurrageProduct>();
	public  Integer totnumberofprod = new Integer(0);
	public  Float totalprice = new Float(0.0);
	Label totalprodqty ;
	Label totalprodprice ;
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DemurrageCart(String id) {
		super(id);
		String username;
		DemurrageDBManager dbc ;
		Connection con ;
		DemurrageCustomer dc= ((DemurrageSession)Session.get()).getDemurrageUser();
		
		//ArrayList<DemurrageProduct> shopcart = ((DemurrageSession)Session.get()).getShoppingCart();
		
		if ((((DemurrageSession) Session.get()).isAuthenticated()) != false)
        {
    	username= dc.getUsername();
    	dbc = new DemurrageDBManager();
    	con = dbc.getDbConnection();
    	Statement stmt;
		try {
			/*stmt = con.createStatement();
		
		    String getshc = "Select shop_cart_id,prod_id,catg_id,subcatg_id from t_shopping_cart where username='"+username+"'";
		    System.out.println(getshc);
		    ResultSet rs_shcart = stmt.executeQuery(getshc);
		    rs_shcart.next();
		    int shop_cart_id = rs_shcart.getInt(1);
		    int prod_id = rs_shcart.getInt(2);
		    int catg_id = rs_shcart.getInt(3);
		    int subcatg_id = rs_shcart.getInt(4);
		    
		    sc = new ShoppingCart();
		    sc.setShop_cart_id(shop_cart_id);
		    sc.setProd_id(prod_id);
		    sc.setCatg_id(catg_id);
		    sc.setSubcatg_id(subcatg_id);
		    
		    String getprodtab = " Select cat_name , cat_table from t_category where  cat_id ="+catg_id;
		    System.out.println(getprodtab);
		    ResultSet rsprodtab = stmt.executeQuery(getprodtab);
		    rsprodtab.next();
		    
		    String prod_tab = rsprodtab.getString(2);
		    
		    String getproddet ="Select product_id,product_subcat_id,product_descr from "+prod_tab+" where product_id="+prod_id;
		    System.out.println(getproddet);
		    ResultSet rsgetproddet = stmt.executeQuery(getproddet);
		    rsgetproddet.next();*/
			
			ArrayList<DemurrageProduct> sessshopcart = ((DemurrageSession)Session.get()).getShoppingCart();
			if(((DemurrageSession)Session.get()).isCartEmpty()!=false)
			{
				alshopcart = sessshopcart;
			}
			
			for(int i=0;i<sessshopcart.size();i++)
			{
				totnumberofprod = totnumberofprod + sessshopcart.get(i).getQtyordered();
				totalprice = totalprice + (sessshopcart.get(i).getQtyordered() * sessshopcart.get(i).getPrice());
			}
			
			
		    
		    
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	}
		
		        
		totalprodqty = new Label("totalprodqty",totnumberofprod.toString());
		totalprodprice = new Label("totalprodprice",totalprice.toString());
		
		
		add(totalprodqty);
		add(totalprodprice);
		
				
		Form chkoutform = new Form<Void>("chkout")
		{

			private static final long serialVersionUID = 1L;
			protected void onSubmit()
			{
				setResponsePage(ShoppingCartCheckOutPage.class);
				
			}
		};
		Button checkoutbutton = new Button("checkoutbutton"){
			private static final long serialVersionUID = 1L;
			public boolean isEnabled(){
				if(((DemurrageSession)Session.get()).isCartEmpty()!=false)
				{
					return true;
				}
				else{
					return false;
				}
			}
			
		};
		chkoutform.add(checkoutbutton);
		add(chkoutform);
		
		
		
		//DemurrageProduct dptempobj = new DemurrageProduct();
		//alshopcart.add(dptempobj);
		
	}
	
	public void updateCart(DemurrageProduct dp)
	{
		totnumberofprod = getTotalProducts(dp);
		totalprice = getTotalPrice(dp);
		totalprodqty = new Label("totalprodqty",totnumberofprod.toString());
		totalprodprice = new Label("totalprodprice",totalprice.toString());
		replace(totalprodqty);
		replace(totalprodprice);
		
		alshopcart.add(dp);
		((DemurrageSession)Session.get()).setShoppingCart(alshopcart);
		
	}
	
		
	
	public Float getTotalPrice(DemurrageProduct dp)
	{
		
		totalprice = totalprice + (dp.getQtyordered() * dp.getPrice());
		return totalprice;
		
	}
	
	public Integer getTotalProducts(DemurrageProduct dp)
	{
		totnumberofprod = totnumberofprod + dp.getQtyordered();
		
		return totnumberofprod;
	}
	

}
