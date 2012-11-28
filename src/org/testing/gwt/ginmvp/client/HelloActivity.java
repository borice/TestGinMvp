package org.testing.gwt.ginmvp.client;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class HelloActivity extends AbstractActivity implements HelloView.Presenter {

	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	@Inject private HelloView helloView;
	@Inject private PlaceController controller;
	@Inject private GreetingServiceAsync service;

	@Override
	public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
		String textToServer = getPlace().getHelloName();

		helloView.setPresenter(this);
		helloView.setTextToServer(textToServer);
		helloView.setServerResponse("");

		service.greetServer(textToServer, new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				helloView.setText("Remote Procedure Call");
				helloView.clearError();
				helloView.setServerResponse(result);
				helloView.center();
			}

			@Override
			public void onFailure(Throwable caught) {
				helloView.setText("Remote Procedure Call - Failure");
				helloView.setError();
				helloView.setServerResponse(SERVER_ERROR);
				helloView.center();
			}
		});
	}

	@Override
	public String mayStop() {
		helloView.hide();
		return super.mayStop();
	}

	@Override
	public void goTo(Place place) {
		controller.goTo(place);
	}

	public HelloPlace getPlace() {
		return (HelloPlace) controller.getWhere();
	}
}
