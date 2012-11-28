package org.testing.gwt.ginmvp.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class InputNamePlace extends Place {

	private final String name;

	public InputNamePlace() { this(null); }

	public InputNamePlace(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Prefix("input")
    public static class Tokenizer implements PlaceTokenizer<InputNamePlace> {
        @Override
        public String getToken(InputNamePlace place) {
            return place.getName();
        }

        @Override
        public InputNamePlace getPlace(String name) {
            return new InputNamePlace(name);
        }
    }

}
