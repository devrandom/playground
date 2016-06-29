package experiment;

import dagger.Module;
import dagger.Provides;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.concurrent.Executor;

@Module
public class MyModule {
    private final Heater heater;

    public MyModule(Executor executor, Heater heater) {
        this.heater = heater;
    }

    @Singleton @Provides @Named("blah") Heater getHeater() {
        return heater;
    }
}
