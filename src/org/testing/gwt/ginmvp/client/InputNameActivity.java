package org.testing.gwt.ginmvp.client;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class InputNameActivity extends AbstractActivity implements InputNameView.Presenter {

	private final InputNameView inputNameView;
	private final PlaceController controller;

	@Inject
	public InputNameActivity(InputNameView inputNameView, PlaceController controller) {
		this.controller = controller;
		this.inputNameView = inputNameView;
		this.inputNameView.setPresenter(this);
		this.inputNameView.setName(getPlace().getName());
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		panel.setWidget(inputNameView.asWidget());
	}

	@Override
	public void goTo(Place place) {
		controller.goTo(place);
	}

	public InputNamePlace getPlace() {
		return (InputNamePlace) controller.getWhere();
	}
}
