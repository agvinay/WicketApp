package com.gcn.utilities;

import java.util.ArrayList;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

public class DemurrageServicesPresentation extends Panel {
	
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	public PageableListView services;
	public PagingNavigator navigator;
	
	public DemurrageServicesPresentation(String id,ArrayList<DemurrageServices> aldserdao)
	{
		super(id);
		
		services= Demurrageservicessh(aldserdao);
		add(services);
		navigator = new PagingNavigator("navigator", services);
		add(navigator);
	}
	
	public void Demurrageservicesshowp(ArrayList<DemurrageServices> aldserdao)
	{
		//DemurrageProductDao dp;
		int i=0;
		while(i<aldserdao.size())
		{
			System.out.println("+++++++"+aldserdao.get(i).getShort_desc());
			i++;
		
		}
		services= Demurrageservicessh(aldserdao);
		replace(services);
		navigator = new PagingNavigator("navigator", services);
		replace(navigator);
				
	} 
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  PageableListView Demurrageservicessh(ArrayList<DemurrageServices> aldserdao)
	{
		    
		services = new PageableListView("services", aldserdao,10) { 
	    	 private static final long serialVersionUID = 1L;

			@SuppressWarnings("rawtypes")
			@Override
	    	 protected void populateItem(ListItem  item) {
	    		 DemurrageServices dsd = (DemurrageServices)item.getModelObject();
		 	    			    		 
	    		 item.add(new Label("service_id", new PropertyModel(dsd, "service_id")));
	    		 item.add(new Label("short_desc", new PropertyModel(dsd, "short_desc")));    		   
	    		// item.add(new Label("detailed_desc", new PropertyModel(dsd, "detailed_desc")));
	    		 item.add(new Label("wage", new PropertyModel(dsd, "wage")));
	    		 //item.add(new Label("wage_unit", new PropertyModel(dsd, "wage_unit")));    		   
	    		 item.add(new Label("duration", new PropertyModel(dsd, "duration")));
	    		 //item.add(new Label("duration_unit", new PropertyModel(dsd, "duration_unit")));    		   
	    		 item.add(new Label("job_city", new PropertyModel(dsd, "job_city")));
	    		 //item.add(new Label("job_state", new PropertyModel(dsd, "job_state")));
	    		 //item.add(new Label("job_country", new PropertyModel(dsd, "job_country")));
	    		 item.add(new Label("employer_name", new PropertyModel(dsd, "employer_name")));
	    		 //item.add(new Label("employer_desc", new PropertyModel(dsd, "employer_desc")));
	    		 item.add(new Label("employer_address", new PropertyModel(dsd, "employer_address")));
	    		 
	    		 System.out.println("prod desc in listview="+dsd.getShort_desc());
	    	 } 
		};
		System.out.println("in dp services page");
		return services;
	}	

}
