package com.gcn.utilities;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/*import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;*/
import org.apache.wicket.Application;
//import org.apache.wicket.PageParameters;
import org.apache.wicket.extensions.ajax.markup.html.form.upload.UploadProgressBar;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.file.Files;
import org.apache.wicket.util.file.Folder;
import org.apache.wicket.util.lang.Bytes;

import com.gcn.WicketApplication;

public class DemurrageUploadPage extends Panel{
	
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * List view for files in upload folder.
     */
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
            listItem.add(new Image("newfile",new Model<String>("productimages\\"+file.getName())));
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
    
    /**
     * Form for uploads.
     */
    private class FileUploadForm extends Form<Void>
    {
        private FileUploadField fileUploadField;

        /**
         * Construct.
         * 
         * @param name
         *            Component name
         */
        public FileUploadForm(String name)
        {
            super(name);

            // set this form to multipart mode (allways needed for uploads!)
            setMultiPart(true);

            // Add one file input field
            add(fileUploadField = new FileUploadField("fileInput"));

            // Set maximum size to 1000K 
            setMaxSize(Bytes.kilobytes(1000));
        }

        /**
         * @see org.apache.wicket.markup.html.form.Form#onSubmit()
         */
        @Override
        protected void onSubmit()
        {
            final FileUpload upload = fileUploadField.getFileUpload();
            if (upload != null)
            {
                // Create a new file
                File newFile = new File(getUploadFolder(), upload.getClientFileName());

                // Check new file, delete if it allready existed
                checkFileExists(newFile);
                try
                {
                    // Save to new file
                    newFile.createNewFile();
                    upload.writeTo(newFile);

                    DemurrageUploadPage.this.info("saved file: " + upload.getClientFileName());
                    
                    
                }
                catch (Exception e)
                {
                    throw new IllegalStateException("Unable to write file");
                }
            }
        }
    }

    /** Log. */
//    private static final Log log = LogFactory.getLog(DemurrageUploadPage.class);

    /** Reference to listview for easy access. */
    private final FileListView fileListView;

    /**
     * Constructor.
     * 
     * @param parameters
     *            Page parameters
     */
    public DemurrageUploadPage(String id)
    {
        super(id);
    	Folder uploadFolder = getUploadFolder();

        // Create feedback panels
        final FeedbackPanel uploadFeedback = new FeedbackPanel("uploadFeedback");

        // Add uploadFeedback to the page itself
        add(uploadFeedback);
        
      //  add(new Image("Oracle_certificate_1",new ContextRelativeResource(uploadFolder+"\\Oracle_certificate_1.jpg")));
       // add(new Image("Oracle_certificate_1",new Model<String>("productimages\\Oracle_certificate_1.jpg")));

        
        // Add folder view
        //add(new Label("dir", uploadFolder.getAbsolutePath()));
        fileListView = new FileListView("fileList", new LoadableDetachableModel<List<File>>()
        {
            @Override
            protected List<File> load()
            {
                return Arrays.asList(getUploadFolder().listFiles());
            }
        });
        add(fileListView);

        // Add upload form with ajax progress bar
        final FileUploadForm ajaxSimpleUploadForm = new FileUploadForm("ajax-simpleUpload");
        ajaxSimpleUploadForm.add(new UploadProgressBar("progress", ajaxSimpleUploadForm));
        add(ajaxSimpleUploadForm);

    }

    /**
     * Check whether the file allready exists, and if so, try to delete it.
     * 
     * @param newFile
     *            the file to check
     */
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
