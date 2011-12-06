package net.toxbank.client.resource;

import java.net.URL;
import java.util.ArrayList;

public class ToxBankResourceSet<T> extends ArrayList<T>  implements IToxBankResource {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5374523068165504570L;
	private URL resourceURL;
	private String title;

	@Override
	public void setResourceURL(URL resourceURL) {
		this.resourceURL = resourceURL;
		
	}

	@Override
	public URL getResourceURL() {
		return resourceURL;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String getTitle() {
		return title;
	}
}