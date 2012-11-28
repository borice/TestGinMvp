package org.testing.gwt.ginmvp.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface HelloView extends IsWidget {

	void setText(String text);
    void center();
    void setError();
    void clearError();
    void setHTML(String html);
    void setTextToServer(String text);
    void setServerResponse(String text);
    void hide();

    void setPresenter(Presenter presenter);

    public interface Presenter {
        void goTo(Place place);
    }
}