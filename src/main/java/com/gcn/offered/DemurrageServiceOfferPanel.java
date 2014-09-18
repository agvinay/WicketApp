package com.gcn.offered;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class DemurrageServiceOfferPanel extends Panel{
	
	public DemurrageServiceOfferPanel(String id)
	{
		super(id);
		add(new Label("temp","Service offer under construction"));
	}

}
