package com.gcn.offered;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

import org.apache.wicket.Application;
import org.apache.wicket.Session;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.extensions.ajax.markup.html.form.upload.UploadProgressBar;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.file.Files;
import org.apache.wicket.util.file.Folder;
import org.apache.wicket.util.lang.Bytes;

import com.gcn.WicketApplication;
import com.gcn.utilities.DemurrageCategory;
import com.gcn.utilities.DemurrageCustomer;
import com.gcn.utilities.DemurrageDBManager;
import com.gcn.utilities.DemurrageSession;
import com.gcn.utilities.ExtraUtilities;

public class DemurrageProductSellPanel extends Panel {

	
	private static final long serialVersionUID = 1L;
	transient  DemurrageDBManager dbc = new DemurrageDBManager();
	transient  Connection con = dbc.getDbConnection();
	transient  Statement stmtinsertproddata;
	int customerid;
	/** Reference to listview for easy access. */
	//private final FileListView fileListView;

	public DemurrageProductSellPanel(String id){


		super(id);
		
		
		DemurrageCustomer dc= ((DemurrageSession)Session.get()).getDemurrageUser();
		if ((((DemurrageSession) Session.get()).isAuthenticated()) != false)
		{
			customerid= dc.getCustomerid();
		}

		Folder uploadFolder = getUploadFolder();

		// Create feedback panels
		//final FeedbackPanel uploadFeedback = new FeedbackPanel("uploadFeedback");

		// Add uploadFeedback to the page itself
		//add(uploadFeedback);

		//  add(new Image("Oracle_certificate_1",new ContextRelativeResource(uploadFolder+"\\Oracle_certificate_1.jpg")));
		// add(new Image("Oracle_certificate_1",new Model<String>("productimages\\Oracle_certificate_1.jpg")));


		// Add folder view
		//add(new Label("dir", uploadFolder.getAbsolutePath()));
		/*fileListView = new FileListView("fileList", new LoadableDetachableModel<List<File>>()
				{
			@Override
			protected List<File> load()
			{
				return Arrays.asList(getUploadFolder().listFiles());
			}
				});
		add(fileListView);*/

		// Add upload form with ajax progress bar
		final CatForm ajaxSimpleUploadForm = new CatForm("form");
		ajaxSimpleUploadForm.add(new UploadProgressBar("progress", ajaxSimpleUploadForm));
		add(ajaxSimpleUploadForm);

	}
	
	private class FileListView extends ListView<File>
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * Construct.
		 * 
		 * @param name
		 *            Component name
		 * @param files
		 *            The file list model
		 */
		public FileListView(String name, final IModel<List<File>> files)
		{
			super(name, files);
		}

		/**
		 * @see ListView#populateItem(ListItem)
		 */
		@Override
		protected void populateItem(ListItem<File> listItem)
		{
			final File file = listItem.getModelObject();
			listItem.add(new Label("file", file.getName()));
			//listItem.add(new Image("newfile",new Model<String>("productimages\\"+file.getName())));
			listItem.add(new Link("delete")
			{
				@Override
				public void onClick()
				{
					Files.remove(file);
					info("Deleted " + file);
				}
			});
		}
	}

	private class CatForm extends Form <Void>
	{

		private String selectedcategory;
		private String selectedsubcategory;
		String selected_condition = "New";
		String selected_currency = "Euros";
		final DropDownChoice cat_drop_down;
		final DropDownChoice subcat;
		final TextField<String> productname;
		final TextField<String> brand;
		final TextField<String> mpn;
		final TextField<String> price;
		final DropDownChoice shipping;
		final TextField<String> time;
		final TextField<String> payment;
		final DropDownChoice itemcondition;
		final DropDownChoice currency_list_drop_down;
		final TextArea<String> proddesc;
		final TextField<String> quantity;
		final TextField<String> modelv;
		final TextField<String> type;
		final TextField<String> shortdescr;
		String selectedshippingmethod="DHL";

		String getcattable;
		int getsubcatid;
		private FileUploadField fileUploadField;



		private static final long serialVersionUID = 1L;

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public CatForm(String id)
		{
			super(id);



			IModel prodcat = new AbstractReadOnlyModel()
			{
				int i=0;
				String catname;
				ArrayList alcat = new ArrayList();
				public  Object getObject()
				{
					List<DemurrageCategory> categories = ExtraUtilities.getCategories("PRODUCTS");
					while(i<categories.size())
					{
						catname=categories.get(i).getCategory_name();
						alcat.add(catname);
						i++;
					}
					return alcat;
				}

			};

			IModel prodsubcat = new AbstractReadOnlyModel()
			{
				@Override
				public Object getObject()
				{
					if (selectedcategory == null) {
						return Collections.EMPTY_LIST;
					}
					return ExtraUtilities.getSubCategories(selectedcategory);
				}
			};

			// set this form to multipart mode (allways needed for uploads!)
			setMultiPart(true);

			// Add one file input field
			add(fileUploadField = new FileUploadField("fileInput"));

			// Set maximum size to 1000K 
			setMaxSize(Bytes.kilobytes(1000));

			@SuppressWarnings("rawtypes")
			//DemurrageUploadPage prodimgupload = new DemurrageUploadPage("prodimgupload");

			List<String> item_condition = Arrays.asList("New", "Used");
			
			List<String> shippingtype = Arrays.asList("DHL", "Deutsche Post","UPS","Ordinary Post");
			
			List<String> currency_list = Arrays.asList("Euros","Dollars");
			currency_list_drop_down = new DropDownChoice("currencies",new PropertyModel(this, "selected_currency"), currency_list);

			cat_drop_down = new DropDownChoice("categories",new PropertyModel(this, "selectedcategory"), prodcat);
			cat_drop_down.setOutputMarkupId(true);

			subcat = new DropDownChoice<String>("subcat",new PropertyModel(this,"selectedsubcategory"), prodsubcat);
			subcat.setOutputMarkupId(true);

			productname	=	new TextField<String>("productname",Model.of(""));  
			productname.setRequired(true); 
			//productname.add(new PatternValidator("a-z"));

			brand	=	new TextField<String>("brand",Model.of(""));  
			brand.setRequired(true); 
			//brand.add(new PatternValidator("a-z"));

			mpn	=	new TextField<String>("mpn",Model.of(""));  
			mpn.setRequired(true); 

			price	=	new TextField<String>("price",Model.of(""));  
			price.setRequired(true); 
			//price.add(new PatternValidator("0-9"));

			shipping	=	new DropDownChoice("shipping",new PropertyModel(this,"selectedshippingmethod"),shippingtype);  
			shipping.setRequired(true); 
			//shipping.add(new PatternValidator("a-z"));

			time	=	new TextField<String>("time",Model.of(""));  
			time.setRequired(true); 
			//time.add(new PatternValidator("0-9"));

			payment	=	new TextField<String>("payment",Model.of(""));  
			payment.setRequired(true); 
			//payment.add(new PatternValidator("a-z"));

			proddesc = new TextArea<String>("proddesc",Model.of(""));  
			proddesc.setRequired(true);

			quantity = new TextField<String>("quantity",Model.of(""));  
			quantity.setRequired(true);

			modelv = new TextField<String>("modelv",Model.of(""));  
			modelv.setRequired(true);

			type = new TextField<String>("type",Model.of(""));  
			type.setRequired(true);

			shortdescr = new TextField<String>("shortdescr",Model.of(""));  
			shortdescr.setRequired(true);

			itemcondition = new DropDownChoice<String>("ItemCondition",new PropertyModel(this,"selected_condition"),item_condition);



			add(new FeedbackPanel("feedback"));
			add(cat_drop_down);
			add(subcat);
			add(productname);
			add(brand);
			add(mpn);
			add(price);
			add(shipping);
			add(time);
			add(payment);
			add(itemcondition);
			add(currency_list_drop_down);
			add(new Button("submit"));
			add(proddesc);
			add(quantity);
			add(modelv);
			add(type);
			add(shortdescr);
			//add(prodimgupload);

			cat_drop_down.add(new AjaxFormComponentUpdatingBehavior("onchange")
			{
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@SuppressWarnings("deprecation")
				@Override
				protected void onUpdate(AjaxRequestTarget target)
				{
					target.addComponent(subcat);

				}
			});

		}


		protected void onSubmit(){

			String user_cat = (String) cat_drop_down.getModelObject();
			String user_scat = (String) subcat.getModelObject();
			String prod_name = (String) productname.getModelObject();
			String brand_name = (String) brand.getModelObject();
			String mpn_value = (String) mpn.getModelObject();
			String price_value = (String) price.getModelObject();
			String shipping_value = (String) shipping.getModelObject();
			String time_value = (String) time.getModelObject();
			String payment_value = (String) payment.getModelObject();
			String itemcondition_value = (String) itemcondition.getModelObject();
			String currency_value = (String) currency_list_drop_down.getModelObject();
			String proddesc_value = (String) proddesc.getModelObject();
			String quantity_value = (String) quantity.getModelObject();
			String model_value = (String) modelv.getModelObject();
			String type_value = (String) type.getModelObject();
			String short_descr_value = (String)shortdescr.getModelObject();
			

			try {

				Statement stmtgetsecque = con.createStatement();
				String getcattableandid = "Select cat.cat_table,subcat.subcat_id from  t_category cat,t_subcategory subcat where cat.cat_id= subcat.cat_id and cat.cat_name='"+user_cat+"' and subcat.subcat_name='"+user_scat+"'";

				String insertproddata="";
				int prodid = 0;
				// Create a new file
				
				
				
				ResultSet rsgetcatdata = stmtgetsecque.executeQuery(getcattableandid);
				if(rsgetcatdata.next())
				{
					getcattable = rsgetcatdata.getString(1);
					getsubcatid = rsgetcatdata.getInt(2);
					insertproddata = "Insert into "+getcattable+" (`product_subcat_id`, `product_descr`, `product_name`, `image`, `brand`, `qty`, `price`, `model`, `type`,`shipping_method`,`handling_time`,`payment_type`,`condition`,`customer_id`,`short_descr`,`currency`) values("+getsubcatid+",'"+proddesc_value+"','"+prod_name+"',NULL,'"+brand_name+"',"+quantity_value+","+price_value+",'"+model_value+"','"+type_value+"','"+shipping_value+"',"+time_value+",'"+payment_value+"','"+itemcondition_value+"',"+customerid+",'"+short_descr_value+"','"+currency_value+"')";
					System.out.println(insertproddata);
					stmtgetsecque.executeUpdate(insertproddata);
					ResultSet rsgetprodiddata = stmtgetsecque.executeQuery("Select last_insert_id()");
					if(rsgetprodiddata.next())
					{
						prodid = rsgetprodiddata.getInt(1);
						System.out.println("prod id fetched=============="+prodid);
					}
					
					final FileUpload upload = fileUploadField.getFileUpload();
					int dotlocation = upload.getClientFileName().indexOf(".");
					String fileextension = upload.getClientFileName().substring(dotlocation+1);
					String tempfilename = upload.getClientFileName().replace('.', '_');
					//String newfilename = upload.getClientFileName()+"ci-"+customerid+"pi-"+prodid+"."+fileextension;
					String newfilename = tempfilename+"_"+"ci-"+customerid+"pi-"+prodid+"."+fileextension;
					File newFile = new File(getUploadFolder(), newfilename);
					rsgetprodiddata.close();
					
					if (upload != null)
					{
						
						// Check new file, delete if it allready existed
						checkFileExists(newFile);
						try
						{
							// Save to new file
							newFile.createNewFile();
							upload.writeTo(newFile);
							ResultSet rsgetlastprodid = stmtgetsecque.executeQuery("Select max(product_id) from "+getcattable);
							if(rsgetlastprodid.next())
							{
							int maxprodid = rsgetlastprodid.getInt(1);
							
							String update_imgname="Update "+getcattable+" set image='"+newfilename+"' where product_id="+maxprodid;
							System.out.println(update_imgname);
							stmtgetsecque.executeUpdate(update_imgname);
							}

							DemurrageProductSellPanel.this.info("saved file: " + upload.getClientFileName()+"ci"+customerid);
							rsgetlastprodid.close();


						}
						catch (Exception e)
						{
							//throw new IllegalStateException("Unable to write file");
							e.printStackTrace();
						}
					}
					
					dbc.closeDbConnection();
					

				}
			}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


			System.out.println("=====cat_drop_down="+user_cat+"subcat==="+user_scat) ;

		}

		public String getSelectedCategory()
		{
			return selectedcategory;
		}

		public void setSelectedCategory(String selectcategory)
		{
			this.selectedcategory = selectedcategory;
		}

		public String getselectedsubcategory()
		{
			return selectedsubcategory;
		}

		public void setselectedsubcategory(String selectedsubcategory)
		{
			this.selectedsubcategory = selectedsubcategory;
		}

	}

	private void checkFileExists(File newFile)
	{
		if (newFile.exists())
		{
			// Try to delete the file
			if (!Files.remove(newFile))
			{
				throw new IllegalStateException("Unable to overwrite " + newFile.getAbsolutePath());
			}
		}
	}

	private Folder getUploadFolder()
	{
		return ((WicketApplication)Application.get()).getUploadFolder();
	}

}

