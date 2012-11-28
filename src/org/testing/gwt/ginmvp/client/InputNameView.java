package org.testing.gwt.ginmvp.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface InputNameView extends IsWidget {

    void setPresenter(Presenter presenter);

    void setError(String message);
    void setName(String name);

    public interface Presenter {
        void goTo(Place place);
    }
}
