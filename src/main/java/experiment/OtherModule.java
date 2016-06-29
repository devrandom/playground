package experiment;

import dagger.Module;
import dagger.Provides;

import javax.inject.Named;
import javax.inject.Singleton;

@Module
public class OtherModule {
    private final String name;

    public OtherModule(String name) {
        this.name = name;
    }

    public OtherModule() {
        this.name = "default";
    }

    @Singleton
    @Provides
    @Named("name") String getName() {
        return name;
    }

}
