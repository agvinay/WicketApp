package com.gcn.wanted;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class DemurrageWantJobPanel extends Panel {
	
	public DemurrageWantJobPanel(String id)
	{
		super(id);
		add(new Label("temp"," Job Under Construction"));
	}

}
