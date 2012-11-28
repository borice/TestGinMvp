package org.testing.gwt.ginmvp.client;

import com.google.code.ginmvp.client.GinMvpModule;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class AppGinModule extends AbstractGinModule {

    @Override
    protected void configure() {

    	install(new GinMvpModule(AppActivityMapper.class, InputNamePlace.class));

    	bind(InputNameView.class).to(InputNameViewImpl.class).in(Singleton.class);
    	bind(HelloView.class).to(HelloViewImpl.class).in(Singleton.class);

    }

}