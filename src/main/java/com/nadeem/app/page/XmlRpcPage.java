package com.nadeem.app.page;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebRequest;
import org.apache.wicket.protocol.http.WebResponse;

import com.nadeem.app.WicketApplication;

public final class XmlRpcPage extends WebPage {

	public XmlRpcPage() throws ServletException, IOException {
		setStatelessHint(true);

		((WicketApplication) getApplication()).getXmlRpcServer().execute(((WebRequest)getRequestCycle().getRequest()).getHttpServletRequest(),
													((WebResponse)getRequestCycle().getResponse()).getHttpServletResponse());
	}

	@Override
	public boolean hasAssociatedMarkup() {
		return false;
	}

	public final String getMarkupType() {
		return "text/xml";
	}

	@Override
	protected void onRender(MarkupStream markupStream) {

	}
}
