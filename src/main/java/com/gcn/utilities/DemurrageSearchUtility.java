package com.gcn.utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DemurrageSearchUtility {
	
	static int prdsubcatid=0;
	static String pdesc;
	static String prdname;
	static int pid;
	static int pscid;
	static String brand;
	static int qty;
	static float price;
	static String model;
	static String type;
	static String short_description;
	static String imagename;
	
	public static ArrayList<DemurrageProduct> DemurrageProductSearchDao(DemurrageCategory dCat, String searchstr, String currency_value)
	{   
		ArrayList<DemurrageProduct> alDatabaseQuery = new ArrayList<DemurrageProduct>();
		
		DemurrageDBManager dbc = new DemurrageDBManager();
		Connection con = dbc.getDbConnection();
		String getpdt ="";
		ResultSet rsgetprddet;
		
		String prdtablename = dCat.getTable_name();
	
			try
			{		
				Statement stmtmp = con.createStatement();
				//String getprdtab = "Select cat.product_table, subcat.subcat_id, cat.cat_id  from t_category cat, t_subcategory subcat where subcat.cat_id = cat.cat_id and subcat.subcat_name="+id;
				//ResultSet rsgetprdtab = stmtmp.executeQuery(getprdtab);
			//	if(rsgetprdtab.next() != false)
				//{
					//String ptab = rsgetprdtab.getString(1);
					//int psubcat = rsgetprdtab.getInt(2);
					//int pcatid = rsgetprdtab.getInt(3);
					
				if (currency_value.equals("All"))
				{
					getpdt = "Select product_id, product_subcat_id, product_descr, product_name, brand, qty, price, model, type, short_descr,image from "+prdtablename+" where (product_name like '%"+searchstr+"%' or product_descr like '%"+searchstr+"%') and qty>0 ";
					
				}
				else
				{
					
					getpdt = "Select product_id, product_subcat_id, product_descr, product_name, brand, qty, price, model, type, short_descr,image from "+prdtablename+" where (product_name like '%"+searchstr+"%' or product_descr like '%"+searchstr+"%') and qty>0 and currency='"+currency_value+"'";
				}	
					rsgetprddet = stmtmp.executeQuery(getpdt);
					System.out.println(getpdt);
					
					while(rsgetprddet.next())
					{
						 pid =  rsgetprddet.getInt(1);
						 pscid = rsgetprddet.getInt(2);
						 pdesc = rsgetprddet.getString(3);
						 prdname = rsgetprddet.getString(4);
						 brand =  rsgetprddet.getString(5);
						 qty = rsgetprddet.getInt(6);
						 price = rsgetprddet.getFloat(7);
						 model = rsgetprddet.getString(8);
						 type = rsgetprddet.getString(9);
						 short_description = rsgetprddet.getString(10);
						 imagename = rsgetprddet.getString(11);
						 DemurrageProduct dpdao = new DemurrageProduct();
						 dpdao.setProduct_id(pid);
						 dpdao.setProduct_subcat_id(pscid);
						 dpdao.setProduct_descr(pdesc);
						 dpdao.setProduct_name(prdname);
						 dpdao.setBrand(brand);
						 dpdao.setQty(qty);
						 dpdao.setPrice(price);
						 dpdao.setModel(model);
						 dpdao.setType(type);
						 dpdao.setShort_description(short_description);
						 dpdao.setProdimage(imagename);
						 dpdao.setProducttablename(prdtablename);
						 alDatabaseQuery.add(dpdao);
						 
						 
						 System.out.println("From Resultset======"+rsgetprddet.getString(3));					 
					}				
				
				System.out.println("search panel dao sql="+getpdt);
				dbc.closeDbConnection();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			//DemurrageProduct dp = new DemurrageProduct(aldpdao);
			//setResponsePage(new DemurrageProduct(aldpdao));
			System.out.println("product display 1.2");
			int i=0;
			while(i<alDatabaseQuery.size())
			{
				System.out.println("Before Returning>>>>>>>>>>>>"+alDatabaseQuery.get(i).getProduct_descr());
				i++;
			// dp = (DemurrageProductDao) itr.next();
			//System.out.println("product desc before listview:"+dp.getProduct_descr());
			}
			return 	alDatabaseQuery;		
	}
	
	public static ArrayList<DemurrageProduct> demurrageMenuSearch(String subcatname)
	{
		DemurrageDBManager dbc = new DemurrageDBManager();
		Connection con = dbc.getDbConnection();
		ResultSet rsgetproducttable;
		ResultSet rsgetproductdesc;
		String getprdtable;
		String getprddetails;
		String prdtable="";
		
		
		ArrayList<DemurrageProduct> alDatabaseQueryprd = new ArrayList<DemurrageProduct>();
		
		try
		{		
			Statement stmtmp = con.createStatement();
			getprdtable = " Select tsc.subcat_id, tc.cat_table from t_subcategory tsc, t_category tc where tsc.subcat_name ='"+subcatname+"' and tc.cat_id= tsc.cat_id";
			rsgetproducttable = stmtmp.executeQuery(getprdtable);
			while(rsgetproducttable.next())
			{
				prdsubcatid = rsgetproducttable.getInt(1);
				prdtable = rsgetproducttable.getString(2);
			}
			
			getprddetails = "Select product_id, product_subcat_id, product_descr, product_name, brand, qty, price, model, type, short_descr,image from "+prdtable+" where product_subcat_id="+prdsubcatid+" and qty>0";
			rsgetproductdesc = stmtmp.executeQuery(getprddetails);
			while(rsgetproductdesc.next())
			{
				pid =  rsgetproductdesc.getInt(1);
				pscid = rsgetproductdesc.getInt(2);
				pdesc = rsgetproductdesc.getString(3);
				prdname = rsgetproductdesc.getString(4);
				brand =  rsgetproductdesc.getString(5);
				qty = rsgetproductdesc.getInt(6);
				price = rsgetproductdesc.getFloat(7);
				model = rsgetproductdesc.getString(8);
				type = rsgetproductdesc.getString(9);
				short_description = rsgetproductdesc.getString(10);
				imagename = rsgetproductdesc.getString(11);
				DemurrageProduct dpdao = new DemurrageProduct();
				dpdao.setProduct_id(pid);
				dpdao.setProduct_subcat_id(pscid);
				dpdao.setProduct_descr(pdesc);
				dpdao.setProduct_name(prdname);
				dpdao.setBrand(brand);
				dpdao.setQty(qty);
				dpdao.setPrice(price);
				dpdao.setModel(model);
				dpdao.setType(type);
				dpdao.setShort_description(short_description);
				dpdao.setProdimage(imagename);
				dpdao.setProducttablename(prdtable);
				alDatabaseQueryprd.add(dpdao);
							
			}
			
			dbc.closeDbConnection();
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alDatabaseQueryprd;
		
	}
}
