package com.gcn.authorization;

import java.io.Serializable;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import org.apache.wicket.Component;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.validation.validator.EmailAddressValidator;
import org.apache.wicket.validation.validator.PatternValidator;
import org.apache.wicket.validation.validator.StringValidator;
import org.apache.wicket.validation.validator.StringValidator.LengthBetweenValidator;
import org.apache.wicket.extensions.markup.html.form.select.Select;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.validation.EqualPasswordInputValidator;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.gcn.utilities.DemurrageCategory;
import com.gcn.utilities.DemurrageDBManager;
import java.util.*;
import java.text.*;


public class DemurrageRegistration extends WebPage  {
	private static final long serialVersionUID = 1L;
	private static final List<String> select_country = Arrays.asList("Germany", "others");
	private static final List<String> day = Arrays.asList("01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31");
	private static final List<String> month = Arrays.asList("December","November","October","September","August","July","June","May","April","March","February","January");
	//private static final List<String> select_secretquestion = Arrays.asList("What is the name of the company of your first job?", "What is your pet's name?","What is your mother's maiden name?","In what city were you born?");
	private static final List<String> select_secretquestion = new ArrayList<String>();
	
	private static final List<String> nationality = Arrays.asList("Germany","Others");
	private static final List<String> sex = Arrays.asList("male","female");
	private final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	public String selected_day = "01";
	public String selected_month = "December";
	public String selected_nation = "Germany";
	public String selected = "male";
	
	
	
	transient  DemurrageDBManager dbc = null;
	transient  Connection con;
	transient  Statement stmtinsertcustdata;
	DropDownChoice selectsecretques = null;
	
    public DemurrageRegistration() {
    	
    	//super(panelid);
    	//super();
    	
    	dbc = new DemurrageDBManager();
    	con = dbc.getDbConnection();
    	int secretqueid;
    	String secretquestion;
    	ArrayList<SecretQuestion> secretqueslist = new ArrayList<SecretQuestion>();
    	
    	SecretQuestion sq = null;
    	
    	try {
    		
			Statement stmtgetsecque = con.createStatement();
			String getsecque= "select sqid, question from t_secret_question ";
			ResultSet rsgetsecqu = stmtgetsecque.executeQuery(getsecque);
			while(rsgetsecqu.next())
			{
			    sq = new SecretQuestion();
				sq.setSecqueid(rsgetsecqu.getInt(1));
				sq.setSecretquestion(rsgetsecqu.getString(2));
				secretqueslist.add(sq);
				
				
			}
			ChoiceRenderer renderer = new ChoiceRenderer("secretquestion", "secqueid");
			selectsecretques = new DropDownChoice("select_secretquestion",new Model(sq),secretqueslist,renderer);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	add(new FeedbackPanel("feedback"));
    	
    	
    	           	        	
    	
    	final TextField<String> username	=	new TextField<String>("username",Model.of(""));  
    	username.setRequired(true); 
    	username.add(StringValidator.lengthBetween(5, 8));
		username.add(new PatternValidator("[a-z0-9_-]+"));
    	
       	final TextField<String> email		= 	new TextField<String>("email",Model.of(""));
    	email.setRequired(true);
    	email.add( EmailAddressValidator.getInstance());
    	
    	final TextField<String> repeatemail = 	new TextField<String>("repeat email",Model.of(""));
    	repeatemail.setRequired(true);
    	
    	final PasswordTextField password 	= new PasswordTextField("password",Model.of(""));
    	password.setRequired(true);
    	password.add(new PatternValidator(PASSWORD_PATTERN));
    	
    	final PasswordTextField repeatpassword = new PasswordTextField("repeatpassword",Model.of(""));
    	repeatpassword.setRequired(true);
    	
    	final TextField<String> firstname 		= 	new TextField<String>("firstname",Model.of(""));
    	firstname.setRequired(true);
    	
    	final TextField<String> lastname 		= 	new TextField<String>("lastname",Model.of(""));
    	lastname.setRequired(true);
    	
    	final TextField<String> mobilephone 	= 	new TextField<String>("mobilephone",Model.of(""));
    	mobilephone.setRequired(true);
    	
    	final TextField<String> date 			= 	new TextField<String>("date",Model.of(""));
    	date.setRequired(true);
    	
    	final TextField<String> streetaddress	= 	new TextField<String>("streetaddress",Model.of(""));
    	streetaddress.setRequired(true);
    	
    	final TextField<String> city 			= 	new TextField<String>("city",Model.of("")); 
    	city.setRequired(true);
    	
    	final TextField<String> year 			= 	new TextField<String>("year",Model.of(""));
    	year.setRequired(true);
    	
    	final TextField<String> postcode 		= 	new TextField<String>("postcode",Model.of(""));
    	postcode.setRequired(true);
    	
    	final TextField<String> state 	= 	new TextField<String>("state",Model.of(""));
    	state.setRequired(true);
    	
    	final DropDownChoice<String> selectcountry  = new DropDownChoice<String>("select_country",new PropertyModel(this,"selected_nation"),select_country);
    	
    	//final DropDownChoice<String> selectsecretques  = new DropDownChoice<String>("select_secretquestion",new PropertyModel(this,"selected_secret_ques"),select_secretquestion);
    	
    	final TextField<String> secretqueansw 	= 	new TextField<String>("secretqueansw",Model.of(""));
    	secretqueansw.setRequired(true);
    	
    	final DropDownChoice<String> selectdate = new DropDownChoice<String>("date",new PropertyModel(this,"selected_day"),day);
    	
    	final DropDownChoice<String> selectmonth = new DropDownChoice<String>("month",new PropertyModel(this,"selected_month"), month);
    	
    	final DropDownChoice<String> selectnationality = new DropDownChoice<String>("nationality", new PropertyModel(this,"selected_nation"),nationality);
    	
    	final RadioChoice<String> gender = new RadioChoice<String>("sex", new PropertyModel<String>(this, "selected"), sex);
    	
    	//final String dateval = 
    	
    	
    	
    	
      	Form<?> form = new Form<Object> ("form") {
      		
    
			private static final long serialVersionUID = 1L;

	protected void onSubmit() {
		
		
		
		final String usernamevalue 	 = 	username.getModelObject();
		final String emailvalue		 = 	email.getModelObject();
		final String passwordvalue   = 	password.getModelObject();
		final String firstnamevalue = firstname.getModelObject();
		final String lastnamevalue = lastname.getModelObject();
		final String streetaddressvalue = streetaddress.getModelObject();
		final String cityvalue = city.getModelObject();
		final String statevalue = state.getModelObject();
		 
		final String postcodevalue = postcode.getModelObject();
		final String mobilephonevalue = mobilephone.getModelObject();
		final String countryvalue = selectcountry.getModelObject();
		final String datevalue = selectdate.getModelObject();
		final String monthvalue = selectmonth.getModelObject();
		final String nationalityvalue = selectnationality.getModelObject();
		final String hostingTypevalue = gender.getModelObject();
		final String yearvalue = year.getModelObject();
		final SecretQuestion secretquesid =  (SecretQuestion) selectsecretques.getModelObject();
		final String answersecretques= secretqueansw.getModelObject();
		final int secretquesidval= secretquesid.getSecqueid();
		
		String str_date=datevalue+"-"+monthvalue+"-"+yearvalue;
		
		//final Date d= new Date( date);
		/* Date dob = null ; 
		try
		
		{
		 String str_date=datevalue+"-"+monthvalue+"-"+yearvalue;
		 SimpleDateFormat  formatter ; 
		 
		 formatter = new SimpleDateFormat("dd-MMM-yyyy");
		 dob = (Date)formatter.parse(str_date);  
		 System.out.println("Today is " + dob );
		} 
		
		catch (ParseException e)
		{
		 System.out.println("Exception :"+e); 
		 }  */
		 
		 
	
		
		try
		{
			System.out.println("values="+countryvalue+" "+datevalue+"selectmonth type"+monthvalue);
			System.out.println("values="+usernamevalue+" "+emailvalue+"hosting type"+firstnamevalue);
			
			stmtinsertcustdata = con.createStatement();
			String insertcustomerdata = "insert into  t_customer values('"+firstnamevalue+"','"+lastnamevalue+"','"+usernamevalue+"','"+passwordvalue+"','"+streetaddressvalue+"','"+postcodevalue+"','"+cityvalue+"','"+statevalue+"','"+countryvalue+"','"+str_date+"','"+mobilephonevalue+"','"+mobilephonevalue+"',"+secretquesidval+",'"+answersecretques+"','"+emailvalue+"',NULL)";
			System.out.println("query="+insertcustomerdata);
			stmtinsertcustdata.executeUpdate(insertcustomerdata);
			
			System.out.println("insertion done");
			dbc.closeDbConnection();
			
			setResponsePage(DemurrageLogin.class);
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
		
    }
      	
};
      	add(form); 
      	form.add(username);
    	form.add(email);
    	form.add(repeatemail);
    	form.add(password);
    	form.add(repeatpassword);
    	form.add(new EqualPasswordInputValidator(password, repeatpassword));
    	form.add(firstname);
    	form.add(lastname);
    	form.add(mobilephone);
    	form.add(streetaddress);
    	form.add(year);
    	form.add(city);
    	form.add(postcode);
    	form.add(state);
    	form.add(selectcountry);
    	form.add(selectdate);
    	form.add(selectmonth);
    	form.add(selectnationality);
    	
       	form.add(gender); 
       	form.add(selectsecretques);
       	form.add(secretqueansw);
      
       	form.add(new Button("submit"));
      	
      	
      	
    
      	
		//username.add(new UsernameValidator());
		//add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
        // TODO Add your page's components here
    
}
    
    private class SecretQuestion implements Serializable {
    	int secqueid;
    	String secretquestion;
		public int getSecqueid() {
			return secqueid;
		}
		public void setSecqueid(int secqueid) {
			this.secqueid = secqueid;
		}
		public String getSecretquestion() {
			return secretquestion;
		}
		public void setSecretquestion(String secretquestion) {
			this.secretquestion = secretquestion;
		}
    }
    
}
