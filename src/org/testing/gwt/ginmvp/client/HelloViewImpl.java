package org.testing.gwt.ginmvp.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class HelloViewImpl extends DialogBox implements HelloView, ClickHandler {

	private Presenter presenter;

	private final Button closeButton;
	private final Label textToServerLabel;
	private final HTML serverResponseLabel;

	public HelloViewImpl() {
		setAnimationEnabled(true);
		setText("Remote Procedure Call");

		closeButton = new Button("Close");
		closeButton.addClickHandler(this);
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		textToServerLabel = new Label();
		serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);

		setWidget(dialogVPanel);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void onClick(ClickEvent event) {
		hide();

		presenter.goTo(new InputNamePlace(textToServerLabel.getText()));
	}

	@Override
	public void setError() {
		serverResponseLabel.addStyleName("serverResponseLabelError");
	}

	@Override
	public void clearError() {
		serverResponseLabel.removeStyleName("serverResponseLabelError");
	}

	@Override
	public void center() {
		super.center();
		closeButton.setFocus(true);
	}

	@Override
	public void setTextToServer(String text) {
		textToServerLabel.setText(text);
	}

	@Override
	public void setServerResponse(String text) {
		serverResponseLabel.setHTML(text);
	}
}
