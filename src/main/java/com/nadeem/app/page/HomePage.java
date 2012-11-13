package com.nadeem.app.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class HomePage extends WebPage {

	public HomePage() {
		add(new Label("pageTitle", "Wicket Rest Example"));
		add(new Label("message", "Welcome"));
	}
}
