package com.gcn;

import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.http.WebRequest;
import org.apache.wicket.util.file.Folder;


import com.gcn.utilities.DemurrageCategoryPresentation;
import com.gcn.utilities.DemurrageSession;
import com.gcn.utilities.DemurrageUploadPage;


/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see com.gcn.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{    	
	
	private Folder uploadFolder = null;
	
	
	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<HomePage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

		// add your configuration here
		getResourceSettings().setThrowExceptionOnMissingResource(false);
		uploadFolder = new Folder(System.getProperty("Demurragefileupload"), "src/main/java/com/gcn/utilities/productimages");
		// Ensure folder exists
        uploadFolder.mkdirs();
       // mountBookmarkablePage("/single", DemurrageUploadPage.class);
        
	}
	
	public Session newSession(Request request , Response response)
	{
		return new DemurrageSession(request);
	}
	
	/**
     * @return the folder for uploads
     */
    public Folder getUploadFolder()
    {
        return uploadFolder;
    }
    
   /* @Override
    protected WebRequest newWebRequest(HttpServletRequest servletRequest)
    {
        return new UploadWebRequest(servletRequest);
    }*/
	
	
}
