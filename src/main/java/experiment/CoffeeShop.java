package experiment;

import dagger.Component;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Component(modules = {MyModule.class, OtherModule.class})
interface CoffeeShop {
    CoffeeMaker maker();
    @Named("blah") Heater heater();
    @Named("name") String getName();
    void inject(CoffeeApp app);
}
