package org.testing.gwt.ginmvp.client;

import org.testing.gwt.ginmvp.shared.FieldVerifier;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class InputNameViewImpl extends Composite implements InputNameView, ClickHandler, KeyUpHandler {

    private Presenter presenter;

    private final Button sendButton;
    private final TextBox nameField;
    private final Label errorLabel;

    public InputNameViewImpl() {
		sendButton = new Button("Send");
		nameField = new TextBox();
		nameField.setText("GWT User");
		errorLabel = new Label();
		Label label = new Label("Please enter your name:");

		// We can add style names to widgets
		errorLabel.addStyleName("errorLabel");
		sendButton.addStyleName("sendButton");
		label.addStyleName("label");

    	Grid table = new Grid(3, 2);
    	table.setWidget(0, 0, label);
    	table.setWidget(1, 0, nameField);
    	table.setWidget(1, 1, sendButton);
    	table.setWidget(2, 0, errorLabel);

    	table.addStyleName("input");

    	Element elLabel = table.getCellFormatter().getElement(0, 0);
    	DOM.setElementAttribute(elLabel, "colspan", "2");

    	Element elErrLabel = table.getCellFormatter().getElement(2, 0);
    	DOM.setElementAttribute(elErrLabel, "colspan", "2");

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		sendButton.addClickHandler(this);
		nameField.addKeyUpHandler(this);

    	initWidget(table);
    }

	/**
	 * Fired when the user clicks on the sendButton.
	 */
	@Override
	public void onClick(ClickEvent event) {
		verifyAndProceed();
	}

	/**
	 * Fired when the user types in the nameField.
	 */
	@Override
	public void onKeyUp(KeyUpEvent event) {
		if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
			verifyAndProceed();
		}
	}


	void verifyAndProceed() {
		String textToServer = nameField.getText();

		errorLabel.setText("");

		if (!FieldVerifier.isValidName(textToServer)) {
			errorLabel.setText("Please enter at least four characters");
			return;
		}

		presenter.goTo(new HelloPlace(textToServer));
	}


    @Override
    public void setPresenter(Presenter presenter) {
    	this.presenter = presenter;
    }

	@Override
	public void setError(String message) {
		errorLabel.setText(message);
	}

	@Override
	public void setName(String name) {
		nameField.setText(name);
	}
}
