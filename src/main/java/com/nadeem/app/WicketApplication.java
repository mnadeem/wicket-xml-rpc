package com.nadeem.app;

import java.util.HashMap;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.RequestProcessorFactoryFactory.StatelessProcessorFactoryFactory;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.XmlRpcServletServer;

import com.nadeem.app.page.HomePage;
import com.nadeem.app.page.XmlRpcPage;


public class WicketApplication extends WebApplication {
	//TODO: Extract the XML RPC related to separate API
	private XmlRpcServletServer xmlRpcServer = new XmlRpcServletServer();

	public WicketApplication() {

	}

	@Override
	protected void init() {
		super.init();
		configureXmlRpcServer();
		this.xmlRpcServer.setHandlerMapping(newHandlerMapping());

		mountBookmarkablePage("xmlRpc", XmlRpcPage.class);
	}

	private void configureXmlRpcServer() {
		XmlRpcServerConfigImpl cfg 	= (XmlRpcServerConfigImpl) this.xmlRpcServer.getConfig();
		cfg.setEnabledForExtensions(true);
	}

	private PropertyHandlerMapping newHandlerMapping() {
		PropertyHandlerMapping mapping 	= new PropertyHandlerMapping();
		mapping.setRequestProcessorFactoryFactory(new StatelessProcessorFactoryFactory());

		try {
			mapping.load(getClass().getClassLoader(), newHandlers());
		} catch (XmlRpcException e) {
			// TODO Auto-generated catch block
		}
		return mapping;
	}

	private HashMap<String, String> newHandlers() {
		HashMap<String, String> handlers = new HashMap<String, String>();
		handlers.put("versionService", "com.nadeem.app.service.VersionServiceImpl");
		handlers.put("dateService", "com.nadeem.app.service.DateServiceImpl");
		return handlers;
	}

	public XmlRpcServletServer getXmlRpcServer() {
		return xmlRpcServer;
	}

	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}
}
