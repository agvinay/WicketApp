package com.gcn.authorization;

import java.io.Serializable;

import org.apache.wicket.Session;

import com.gcn.utilities.DemurrageSession;

public class DemurrageLogout implements Serializable{
	
	public DemurrageLogout()
	{
		
		((DemurrageSession)Session.get()).invalidate();
		
		
	}

}
