package com.gcn.search;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.gcn.utilities.DemurrageCategory;
import com.gcn.utilities.DemurrageDBManager;
import com.gcn.utilities.DemurrageProduct;
import com.gcn.utilities.DemurrageProductPresentation;
import com.gcn.utilities.DemurrageSearchUtility;
import com.gcn.utilities.ExtraUtilities;
import com.gcn.wanted.DemurrageViewController;

public class DemurrageSearchPanel extends Panel{
	
	
	
	
	//public DemurrageProductPresentation Dppanel= ; //=  new DemurrageProduct("dmp",aldpdao);

	private ArrayList<DemurrageProduct> alproducts;

	

	public DemurrageSearchPanel(String pname,final DemurrageViewController dViewController,final String catclass)
	{
		super(pname);
		
		//add(new DemurrageProduct("dprd",aldpdao));
		
        class SearchForm extends Form{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private TextField<String> search_text;
			@SuppressWarnings("rawtypes")
			private DropDownChoice cat_drop_down;
			private DropDownChoice currency_list_drop_down;
			String selected_currency = "All";
			
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public SearchForm(String id){
				super(id);
				search_text = new TextField("search_text",new Model<String>());
				List<DemurrageCategory> categories = ExtraUtilities.getCategories(catclass);
		        DemurrageCategory dCat = new DemurrageCategory();
		        @SuppressWarnings("rawtypes")
				ChoiceRenderer renderer = new ChoiceRenderer("category_name", "category_id");
				cat_drop_down = new DropDownChoice("categories",new Model(dCat),categories,renderer);
				List<String> currency_list = Arrays.asList("All","Euros","Dollars");
				currency_list_drop_down = new DropDownChoice("currencies",new PropertyModel(this, "selected_currency"), currency_list);
				Button submitbutton = new Button("search_submit");
				
				add(cat_drop_down);
		        add(search_text);
		        add(currency_list_drop_down);
		        add(submitbutton);
			}
			
			protected void onSubmit(){
				String user_search_text = (String)search_text.getModelObject();
				DemurrageCategory user_dcat = (DemurrageCategory)cat_drop_down.getModelObject();
				String currency_value = (String) currency_list_drop_down.getModelObject();
				
				System.out.println("=====cat_drop_down="+user_dcat.getCategory_name()) ;
				
				if (catclass.equals("PRODUCTS"))
				{
					
				alproducts=DemurrageSearchUtility.DemurrageProductSearchDao(user_dcat, user_search_text,currency_value);
				dViewController.setView("PRODUCT_LIST_VIEW", alproducts);
				//((DemurrageProductPresentation) dprdpresentation).DemurrageProductshp(alproducts);
				}
				  
			}
		};
        add(new SearchForm("search_form"));
        
        
		
		/*ArrayList<DemurrageProduct> alDefault = DemurrageProductSearchDao(id);
		Dppanel = new DemurrageProductPresentation("dmp",alDefault);
		add(Dppanel);
		System.out.println("product display 1");*/
		/*current.replaceWith(Dppanel);
  	    current = Dppanel;
  	    Dppanel.DemurrageProductsh(aldpdao1);  */
		
	}
	
	
	
	/*public void DemurrageProductSearch(String id)
	{
		//ArrayList<DemurrageProductDao> 
		ArrayList<DemurrageProduct> alUserSearch = DemurrageProductSearchDao(id);
		
		int i=0;
		while(i<alUserSearch.size())
		{
			System.out.println("After Receiving***********"+alUserSearch.get(i).getProduct_descr());
			i++;
		// dp = (DemurrageProductDao) itr.next();
		//System.out.println("product desc before listview:"+dp.getProduct_descr());
		}
		
		Dppanel.DemurrageProductshp(alUserSearch);
  	    current = Dppanel;
  	    current.replaceWith(Dppanel);
  	   
  	  System.out.println("product display 2");
		
	}*/
	
}
