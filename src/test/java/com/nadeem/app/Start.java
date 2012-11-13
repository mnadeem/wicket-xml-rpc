package com.nadeem.app;

import java.net.URL;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;


public class Start {

	public static void main(String[] args) throws Exception {
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://127.0.0.1:8080/wicket-xml-rpc/xmlRpc"));

        XmlRpcClient client = new XmlRpcClient();
        client.setTransportFactory(new XmlRpcCommonsTransportFactory(client));
        client.setConfig(config);

        Object response = client.execute("dateService.getDate", new Object[0]);
        System.out.println("Response: " + response);
	}
}
