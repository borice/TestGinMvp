package org.testing.gwt.ginmvp.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class HelloPlace extends Place {
    private final String helloName;

    public HelloPlace() { this(null); }

    public HelloPlace(String name) {
        this.helloName = name;
    }

    public String getHelloName() {
        return helloName;
    }

    @Prefix("hello")
    public static class Tokenizer implements PlaceTokenizer<HelloPlace> {
        @Override
        public String getToken(HelloPlace place) {
            return place.getHelloName();
        }

        @Override
        public HelloPlace getPlace(String name) {
            return new HelloPlace(name);
        }
    }
}