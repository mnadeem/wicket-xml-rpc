package com.nadeem.app.page;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.IBehavior;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebRequest;
import org.apache.wicket.protocol.http.WebResponse;
import org.apache.xmlrpc.webserver.XmlRpcServletServer;

import com.nadeem.app.WicketApplication;

public final class XmlRpcPage extends WebPage {

	public XmlRpcPage() throws ServletException, IOException {
		setStatelessHint(true);

		processXMLRpcRequest(((WebRequest) getRequestCycle().getRequest()), ((WebResponse) getRequestCycle().getResponse()));
	}

	private void processXMLRpcRequest(final WebRequest request, final WebResponse response) throws ServletException, IOException {
		getXMLRpcServer().execute(request.getHttpServletRequest(), response.getHttpServletResponse());
	}

	private XmlRpcServletServer getXMLRpcServer() {
		return ((WicketApplication) getApplication()).getXmlRpcServer();
	}

	@Override
	public boolean hasAssociatedMarkup() {
		return false;
	}

	public String getMarkupType() {
		return "text/xml";
	}

	@Override
	protected void onRender(final MarkupStream markupStream) {

	}

	@Override
	public Component add(final IBehavior... behaviors) {
		throw new UnsupportedOperationException("XmlRpcPage does not support IBehaviours");
	}
}
