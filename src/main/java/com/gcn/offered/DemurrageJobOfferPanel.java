package com.gcn.offered;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class DemurrageJobOfferPanel extends Panel {
	
	public DemurrageJobOfferPanel(String id)
	{
		super(id);
		add(new Label("temp","Job offer under construction"));
	}

}
