package com.gcn.utilities;

import java.util.List;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;

public class DemurrageRecursivePanel extends Panel{
	
	    /**
	     * Constructor.
	     * 
	     * @param id
	     *            The id of this component
	     * @param list
	     *            a list where each element is either a string or another list
	     */
	    public DemurrageRecursivePanel(final String id, List<Object> list)
	    {
	        super(id);
	        add(new Rows("rows", list));
	        setVersioned(false);
	    }

	    /**
	     * The list class.
	     */
	    private static class Rows extends ListView<Object>
	    {
	        /**
	         * Construct.
	         * 
	         * @param name
	         *            name of the component
	         * @param list
	         *            a list where each element is either a string or another list
	         */
	        public Rows(String name, List<Object> list)
	        {
	            super(name, list);
	        }

	        /**
	         * @see org.apache.wicket.markup.html.list.ListView#populateItem(org.apache.wicket.markup.html.list.ListItem)
	         */
	        @SuppressWarnings("unchecked")
	        @Override
	        protected void populateItem(ListItem<Object> listItem)
	        {
	            Object modelObject = listItem.getDefaultModelObject();

	            if (modelObject instanceof List)
	            {
	                // create a panel that renders the sub list
	            	DemurrageRecursivePanel nested = new DemurrageRecursivePanel("nested", (List<Object>)modelObject);
	                listItem.add(nested);
	                // if the current element is a list, we create a dummy row/
	                // label element
	                // as we have to confirm to our HTML definition, and set it's
	                // visibility
	                // property to false as we do not want LI tags to be rendered.
	                WebMarkupContainer row = new WebMarkupContainer("row");
	                row.setVisible(false);
	                row.add(new WebMarkupContainer("label"));
	                listItem.add(row);
	            }
	            else
	            {
	                // if the current element is not a list, we create a dummy panel
	                // element
	                // to confirm to our HTML definition, and set this panel's
	                // visibility
	                // property to false to avoid having the UL tag rendered
	            	DemurrageRecursivePanel nested = new DemurrageRecursivePanel("nested", null);
	                nested.setVisible(false);
	                listItem.add(nested);
	                // add the row (with the LI element attached, and the label with
	                // the
	                // row's actual value to display
	                WebMarkupContainer row = new WebMarkupContainer("row");
	                row.add(new Label("label", modelObject.toString()));
	                listItem.add(row);
	            }
	        }
	    }
	}


