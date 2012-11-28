package org.testing.gwt.ginmvp.client;

import com.google.code.ginmvp.client.ActivityAsyncProxy;
import com.google.code.ginmvp.client.SimpleActivityMapper;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class AppActivityMapper extends SimpleActivityMapper {

    @Inject
    public AppActivityMapper(
    		final Provider<InputNameActivity> inputNameActivityProvider,
    		final Provider<ActivityAsyncProxy<HelloActivity>> helloActivityProvider) {

    	addProvider(InputNamePlace.class, inputNameActivityProvider);
    	addProvider(HelloPlace.class, helloActivityProvider);
    }

}