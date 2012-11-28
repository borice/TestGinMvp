package org.testing.gwt.ginmvp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TestGinMvp implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		AppGinjector ginjector = GWT.create(AppGinjector.class);
        RootPanel.get().add(ginjector.getMainView());
        ginjector.getPlaceHistoryHandler().handleCurrentHistory();
	}
}
