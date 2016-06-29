package experiment;

import java.util.concurrent.atomic.AtomicInteger;

public class NegativeEnergyHeater implements Heater {
    static AtomicInteger c = new AtomicInteger();
    private final int count;

    public NegativeEnergyHeater() {
        count = c.incrementAndGet();
    }
    public void heat() {
        System.out.println("ATOMIZING " + count);
    }
}
