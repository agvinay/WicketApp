package com.gcn.utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExtraUtilities {
	
	public ExtraUtilities()
	{
		
	}
	
	public static ArrayList<DemurrageCategory> getCategories(String catclass){
		ArrayList<DemurrageCategory> categoryList = new ArrayList<DemurrageCategory>();
		DemurrageDBManager dbc = new DemurrageDBManager();
		Connection con = dbc.getDbConnection();
		String cat_name;
		try
		{		
			Statement stmtmp = con.createStatement();
			String getcat_query = "Select cat_id, cat_name, category_class, cat_table from t_category where category_class = '"+catclass+"'";
			ResultSet getcat_resultset = stmtmp.executeQuery(getcat_query);
			while(getcat_resultset.next())
			{
				DemurrageCategory dCategory = new DemurrageCategory();
				//cat_name = getcat_resultset.getString(1);
				dCategory.setCategory_name(getcat_resultset.getString(2));
				dCategory.setCategory_id(getcat_resultset.getInt(1));
				dCategory.setCategory_class(getcat_resultset.getString(3));
				dCategory.setTable_name(getcat_resultset.getString(4));
				categoryList.add(dCategory);
			}
			dbc.closeDbConnection();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return categoryList;
	}
	
	public static List<String> getSubCategories(String catname){
		
		ArrayList<String> subCategoryList = new ArrayList<String>();
		DemurrageDBManager dbc = new DemurrageDBManager();
		Connection con = dbc.getDbConnection();
		try
		{		
			Statement stmtmp = con.createStatement();
			String getcat_query = "Select  cat_id, cat_name from t_category where cat_name='"+catname+"'";
			ResultSet getcat_resultset = stmtmp.executeQuery(getcat_query);
			if(getcat_resultset.next())
			{
				String getsubcat_query ="Select subcat_name, subcat_id from t_subcategory where cat_id="+getcat_resultset.getInt(1);
				ResultSet getsubcat_resultset = stmtmp.executeQuery(getsubcat_query);
				while(getsubcat_resultset.next())
				{
 				DemurrageSubCategory dSCategory = new DemurrageSubCategory();
				dSCategory.setSubcat_name(getsubcat_resultset.getString(1));
				dSCategory.setSubcat_id(getsubcat_resultset.getInt(2));
				subCategoryList.add(getsubcat_resultset.getString(1));
				}
			}
			dbc.closeDbConnection();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return subCategoryList;
		
	}

}
