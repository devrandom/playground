package experiment;

import javax.inject.Inject;
import javax.inject.Named;

public class CoffeeMaker {
    private final Heater heater;

    @Inject
    public CoffeeMaker(@Named("blah") Heater heater) {
        this.heater = heater;
    }

    public void make() {
        heater.heat();
    }
}
