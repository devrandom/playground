package experiment;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.concurrent.Executors;

public class CoffeeApp {
    @Inject
    CoffeeMaker maker;
    @Inject @Named("blah")
    Heater heater;
    public static void main(String[] args) {
        new CoffeeApp();
    }

    public CoffeeApp() {
        MyModule electricModule = new MyModule(Executors.newSingleThreadExecutor(), new ElectricHeater());
        CoffeeShop electricCoffeeShop = DaggerCoffeeShop
                .builder()
                .myModule(electricModule)
                .build();
        // Runtime binding of a subclassed instance
        MyModule hyperModule = new MyModule(Executors.newSingleThreadExecutor(), new NegativeEnergyHeater());
        CoffeeShop hyperCoffeeShop = DaggerCoffeeShop
                .builder()
                .myModule(hyperModule)
                .build();
        // Module subclass
        MyModule hyperModuleSub = new HyperMyModule(Executors.newSingleThreadExecutor());
        CoffeeShop hyperCoffeeShopSub = DaggerCoffeeShop
                .builder()
                .myModule(hyperModuleSub)
                .build();
        hyperCoffeeShop.inject(this);
        hyperCoffeeShop.maker().make();
        hyperCoffeeShop.maker().make();
        hyperCoffeeShopSub.maker().make();

        electricCoffeeShop.maker().make();
        maker.make();
        heater.heat();
        System.out.println(hyperCoffeeShop.getName());
    }
}
