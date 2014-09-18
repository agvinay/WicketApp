package com.gcn.utilities;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import com.gcn.search.DemurrageSearchPanel;
import com.gcn.wanted.DemurrageViewController;
import com.gcn.wanted.DemurrageWelcomePanel;






public class DemurrageCategoryPresentation extends Panel{
	
	//public DemurrageSearchPanel Dspanel = new DemurrageSearchPanel("dmp");
	//private DemurrageSearchPanel current = Dspanel;
	
	// code for first time default search
	//DemurrageProduct dpini = new DemurrageProduct();
	//ArrayList <DemurrageProduct> aldpini = new ArrayList();
	
	
	//public DemurrageProductPresentation prdprespanel;
	public Panel current ;
	
	ArrayList<DemurrageProduct> aldp;
	
	@SuppressWarnings("unchecked")
	public DemurrageCategoryPresentation(String id,final DemurrageViewController dViewController)
	{
		super(id);
		
		// code for initial search
		/*dpini.setProduct_id(1);
		dpini.setProduct_subcat_id(1);
		dpini.setProduct_name("Initial page load");
		dpini.setProduct_descr("initial page load description");
		
		aldpini.add(dpini);
		prdprespanel = new DemurrageProductPresentation("dpprespanel",aldpini);
		current = prdprespanel;*/
		//current = dprdpresentation; 
		 
		 // Menu1 
	    add(new Link<String>("Electronics") {
	      private static final long serialVersionUID = 1L;

	     
	      @Override
	      public void onClick() {
	       	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Electronics");
	       	  //current.replaceWith(dprdpresentation);
	    	  //dprdpresentation.DemurrageProductshp(aldp);
	    	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
	    	  
	    	  }
	    });
	    
	    // Sub Menu 1 start
	    
	    add(new Link<String>("Cameras_Photo") {
		      private static final long serialVersionUID = 1L;

		     
		      @Override
		      public void onClick() {
		       	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Cameras & Photo");
		    	  //dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		    	  }
		    });
	    
	    add(new Link<String>("Cell_phones_pdas_accessories") {
		      private static final long serialVersionUID = 1L;

		     
		      @Override
		      public void onClick() {
		       	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Cell Phones, PDAs & Accessories");
		    	  //dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		    	  }
		    });
	    
	    add(new Link<String>("Computers_Networking") {
		      private static final long serialVersionUID = 1L;

		     
		      @Override
		      public void onClick() {
		       	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Computers & Networking");
		    	  //dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		    	  }
		    });
	    
	    add(new Link<String>("More_electronics") {
		      private static final long serialVersionUID = 1L;

		     
		      @Override
		      public void onClick() {
		       	  aldp = DemurrageSearchUtility.demurrageMenuSearch("More Electronics");
		       	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		    	  }
		    });
	    
	    add(new Link<String>("TV_Video_Audio") {
		      private static final long serialVersionUID = 1L;

		     
		      @Override
		      public void onClick() {
		       	  aldp = DemurrageSearchUtility.demurrageMenuSearch("TV, Video & Audio");
		       	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		    	  }
		    });
	    
	    add(new Link<String>("Video_games_systems") {
		      private static final long serialVersionUID = 1L;

		     
		      @Override
		      public void onClick() {
		       	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Video Games & Systems");
		       	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		    	  }
		    });
	    
        // Sub Menu 1 ends
	    // Menu2  
	    add(new Link<String>("Books") {
	      private static final long serialVersionUID = 1L;

	      /** Upon clicking this link, go to FormPage. */
	      @Override
	      public void onClick() {
	    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Books");
	    	//dprdpresentation.DemurrageProductshp(aldp);
	       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
	    	  }
	    });

	    // Sub Menu 2 starts
	    add(new Link<String>("Children_young_adults") {
	      private static final long serialVersionUID = 1L;

	       @Override
	      public void onClick() {
	       	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Children & Young Adults"); 
	       	//dprdpresentation.DemurrageProductshp(aldp);
	       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
	    	  }
	    });

	    add(new Link<String>("Fiction_Literature") {
	      private static final long serialVersionUID = 1L;
	      @Override
	      public void onClick() {
	       	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Fiction & Literature");
	       	//dprdpresentation.DemurrageProductshp(aldp);
	       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
	    	  }
	    });
	    
	    add(new Link<String>("Nonfiction") {
		      private static final long serialVersionUID = 1L;
		      @Override
		      public void onClick() {
		       	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Nonfiction");
		       	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		    	  }
		    });
	    add(new Link<String>("Textbooks_education") {
		      private static final long serialVersionUID = 1L;
		      @Override
		      public void onClick() {
		       	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Textbooks, Education");
		       	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		    	  }
		    });
	    add(new Link<String>("Magazine_back_issues") {
		      private static final long serialVersionUID = 1L;
		      @Override
		      public void onClick() {
		       	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Magazine Back Issues");
		       	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		    	  }
		    });
	    add(new Link<String>("Antiquarian_collectible") {
		      private static final long serialVersionUID = 1L;
		      @Override
		      public void onClick() {
		       	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Antiquarian & Collectible");
		       	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		    	  }
		    });
	    add(new Link<String>("Audiobooks") {
		      private static final long serialVersionUID = 1L;
		      @Override
		      public void onClick() {
		       	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Audiobooks");
		       	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		    	  }
		    });
	    add(new Link<String>("Cookbooks") {
		      private static final long serialVersionUID = 1L;
		      @Override
		      public void onClick() {
		       	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Cookbooks");
		       	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		    	  }
		    });
	    add(new Link<String>("Otherbooks") {
		      private static final long serialVersionUID = 1L;
		      @Override
		      public void onClick() {
		       	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Otherbooks");
		       	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		    	  }
		    });
	    
	  // Sub Menu 2 ends  
	    add(new Link<String>("Antiques") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    // Sub Menu 3 begins
	    add(new Link<String>("Silver") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Silver");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Decorative_arts") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Decorative Arts");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Asian_antiques") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Asian Antiques");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Maps_atlases_globes") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Maps, Atlases & Globes");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Furniture") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Furniture");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Books_manuscripts") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Books & Manuscripts");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Antiquities") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Antiquities");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Otherantiques") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Otherantiques");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    // Sub Menu 3 ends
	    add(new Link<String>("Art") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    // Sub menu 4 starts
	    
	    add(new Link<String>("Art_from_dealers_resellers") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Art from Dealers & Resellers");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    add(new Link<String>("Direct_from_the_artist") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Direct from the Artist");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    
	    add(new Link<String>("Wholesale_lots") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Wholesale Lots");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    
	    
	    // Sub menu 4 ends
	    add(new Link<String>("Baby") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	     // Sub Menu 5 starts
	    
	    add(new Link<String>("Nursery_bedding") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Nursery Bedding");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Feeding") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Feeding");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Toys_for_baby") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Toys for Baby");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Nursery_furniture") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Nursery Furniture");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Diapering") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Diapering");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Car_safety_seats") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Car Safety Seats");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Nursery_decor") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Nursery Decor");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Otherbaby") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Otherbaby");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Baby_safety_health") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Baby Safety & Health");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Baby_gear") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Baby Gear");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Bathing_grooming") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Bathing & Grooming");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    
	    // Sub Menu 5 ends
	    add(new Link<String>("Business_&_Industrial") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    // sub menu 6 starts
	    
	    add(new Link<String>("Electrical_test_equipment") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Electrical & Test Equipment");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    add(new Link<String>("Industrial_supply_mro") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Industrial Supply & MRO");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    add(new Link<String>("Office") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Office");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    add(new Link<String>("manufacturing_metalworking") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Manufacturing & Metalworking");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    
	    // sub menu 6 ends
	   
	  
	    add(new Link<String>("Charity_Listings") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Charity Listings");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    add(new Link<String>("Coins_Paper_Money") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    // sub menu 7 starts
	    
	    add(new Link<String>("Coins_Deutschland") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Coins: Deutschland");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Coins_World") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Coins: World");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Exonumia") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Exonumia");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Bullion") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Bullion");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Coins_ancient") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Coins ancient");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Publications_supplies") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Publications supplies");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Coins_medieval") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Coins: Medieval");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Othercoins") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Othercoins");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    // sub menu 7 ends
	    
	    add(new Link<String>("Collectibles") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Collectibles");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    // sub menu 8 starts
	    add(new Link<String>("Comics") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Comics");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Photographic_images") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Photographic Images");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Decorative_collectibles") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Decorative Collectibles");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    add(new Link<String>("Advertising") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Advertising");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Transportation") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Transportation");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Postcards") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Postcards");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    
	    // sub menu 8 ends
	    
	   
	    
	    add(new Link<String>("DVDs_Movies") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    // sub menu 9 starts
	    
	    add(new Link<String>("Action_adventure") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Action & Adventure");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Animation") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Animation");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Children_family") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Children & Family");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Comedy") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Comedy");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Documentary") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Documentary");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Drama") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Drama");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Sports") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Sports");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    // sub menu 9 ends
	    add(new Link<String>("Entertainment_Memorabilia") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    // sub menu 10 starts
	    add(new Link<String>("Movie_memorabilia") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Movie Memorabilia");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Music_memorabilia") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Music Memorabilia");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    
	    
	    // sub menu 10 ends
	    
	    add(new Link<String>("Gift_Cards_Coupons") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    // sub menu 11 starts
	    
	    add(new Link<String>("Gift_certificates") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Gift Certificates");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    add(new Link<String>("Coupons") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Coupons");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    add(new Link<String>("Gift_cards") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Gift Cards");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    
	    // sub menu 11 ends
	    
	    
	    add(new Link<String>("Health_Beauty") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    // sub menu 12 starts
	    add(new Link<String>("Makeup") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Makeup");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    add(new Link<String>("Fragrances") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Fragrances");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    
	    
	    // sub menu 12 ends
	    
	   
	    add(new Link<String>("Jewelry_Watches") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    // Sub menu 13 starts
	    
	    add(new Link<String>("Fashion_jewelry") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Fashion Jewelry");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    add(new Link<String>("Fine_jewelry") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Fine Jewelry");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	      
	    // Sub menu 13 ends
	    
	    add(new Link<String>("Music") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    // Sub menu 14 starts
	    
	    add(new Link<String>("Classical") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Classical");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    add(new Link<String>("Dance_dj_electronic") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Dance, DJ & Electronic");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    add(new Link<String>("Jazz") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Jazz");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    add(new Link<String>("Metal") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Metal");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    add(new Link<String>("Pop") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Pop");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    
	    // Sub menu 14 ends
	    add(new Link<String>("Pet_Supplies") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    // Sub menu 15 starts
	    add(new Link<String>("Dogsupplies") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Dog Supplies");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Aquarium_fish") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Aquarium & Fish");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Cat_supplies") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Cat Supplies");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Bird_supplies") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Bird Supplies");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    // sub menu 15 ends
	    
	    
	    add(new Link<String>("Pottery_Glass") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    // sub menu 16 starts
	    
	    add(new Link<String>("Pottery_china") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Pottery & China");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    add(new Link<String>("Glass") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Glass");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    // sub menu 16 ends
	    
	    add(new Link<String>("Specialty_Services") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    // sub menu 17 starts
	    
	    add(new Link<String>("Advice_instruction") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Advice & Instruction");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    add(new Link<String>("Custom_clothing_jewelry") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Custom Clothing & Jewelry");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    // sub menu 17 ends
	   
	  
	    add(new Link<String>("Travel") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    // sub menu 18 starts
	    
	    add(new Link<String>("Luggage") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Luggage");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    
	    add(new Link<String>("Travel_accessories") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Travel Accessories");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Luggage_accessories") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Luggage Accessories");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Lodging") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Lodging");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Othertravel") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Othertravel");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    add(new Link<String>("Maps") {
		      private static final long serialVersionUID = 1L;

		      /** Upon clicking this link, go to FormPage. */
		      @Override
		      public void onClick() {
		      	    	  
		    	  aldp = DemurrageSearchUtility.demurrageMenuSearch("Maps");
		    	//dprdpresentation.DemurrageProductshp(aldp);
		       	  dViewController.setView("PRODUCT_LIST_VIEW", aldp);
		      }
		    });
	    // sub menu 18 ends
	    
	   
	    
	  
	    
	    
	  // add(new TabPanel1("initial")); 
	 //   add(prdprespanel);
		 
	}
	
}
