package com.gcn.authorization;

import java.sql.*;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import com.gcn.HomePage;
import com.gcn.utilities.DemurrageCustomer;
import com.gcn.utilities.DemurrageDBManager;
import com.gcn.utilities.DemurrageSession;

public class DemurrageLogin extends  WebPage {
	private static final long serialVersionUID = 1L;

	Boolean returnval;

	
	public DemurrageLogin()
	{
				
		final TextField<String> username = new TextField<String>("username",Model.of(""));
		final PasswordTextField passwd = new PasswordTextField("passwd",Model.of(""));
		passwd.setRequired(true);



		Form<?> form = new Form<Void>("loginform") {

			private static final long serialVersionUID = 1L;

			protected void onSubmit()
			{
				DemurrageCustomer dc = new DemurrageCustomer();
				DemurrageDBManager dbc = new DemurrageDBManager();
				Connection con = dbc.getDbConnection();

				final String usernameValue = username.getModelObject();
				final String passwdValue = passwd.getModelObject();
				//final String button_value = 
				try
				{

					Statement stmt = con.createStatement();
					String chkuser = "Select 1 from t_customer where username = '"+usernameValue+"' and password = '"+passwdValue+"'";
					ResultSet rschkuser = stmt.executeQuery(chkuser);
					if(rschkuser.next() != false)
					{
						int result = rschkuser.getInt(1);
						if (result == 1)
						{
							System.out.println("entry 1");
							String getuserdata = "Select Firstname, Lastname, streetaddress, postcode, city, state, country, dob, landlinephone, mobilephone, secretquestion, answertoq, emailid, customer_id  from  t_customer where username= '"+usernameValue+"'";
							ResultSet rsgetuserdata = stmt.executeQuery(getuserdata);

							if(rsgetuserdata.next() != false)
							{
								System.out.println("entry 2");
								dc.setUsername(usernameValue);
								dc.setAnswertoq(rsgetuserdata.getString(12));
								dc.setCity(rsgetuserdata.getString(5));
								dc.setCountry(rsgetuserdata.getString(7));
								dc.setDob(rsgetuserdata.getString(8));
								dc.setEmailid(rsgetuserdata.getString(13));
								dc.setFirstname(rsgetuserdata.getString(1));
								dc.setLastname(rsgetuserdata.getString(2));
								dc.setLandlinephone(rsgetuserdata.getString(9));

								dc.setMobilephone(rsgetuserdata.getString(10));
								dc.setPostcode(rsgetuserdata.getString(4));
								dc.setSecretquestion(rsgetuserdata.getInt(11));
								dc.setState(rsgetuserdata.getString(6));
								dc.setStreetaddress(rsgetuserdata.getString(3));
								dc.setCustomerid(rsgetuserdata.getInt(14));

								//ds.getDemurrageSession().setDemurrageUser(dc); 

								((DemurrageSession)Session.get()).setDemurrageUser(dc);								
								returnval= true;
							}

							setResponsePage(HomePage.class);
						}
					}
						else
						{
							returnval= false;

						}
					}
					catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				dbc.closeDbConnection();
				}
			};
			add(form);
			form.add(username);
			form.add(passwd);
			form.add(new Button("signin"));
			form.add(new Link<String>("register"){
	    		private static final long serialVersionUID = 1L; 		 
	    		@Override
	  	      	public void onClick() {    			
	    			setResponsePage(DemurrageRegistration.class);		
	    		}	    		
	     	});


	}
}
