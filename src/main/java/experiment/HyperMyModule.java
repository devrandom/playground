package experiment;

import java.util.concurrent.Executor;

public class HyperMyModule extends MyModule {
    public HyperMyModule(Executor executor) {
        super(executor, new NegativeEnergyHeater());
    }
}
