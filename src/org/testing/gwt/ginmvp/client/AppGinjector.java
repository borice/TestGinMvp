package org.testing.gwt.ginmvp.client;

import com.google.code.ginmvp.client.GinMvpDisplay;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceHistoryHandler;

@GinModules({AppGinModule.class})
public interface AppGinjector extends Ginjector {

        PlaceHistoryHandler getPlaceHistoryHandler();
        GinMvpDisplay getMainView();

}