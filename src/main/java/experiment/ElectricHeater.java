package experiment;

import java.util.concurrent.atomic.AtomicInteger;

public class ElectricHeater implements Heater {
    static AtomicInteger c = new AtomicInteger();
    private final int count;

    public ElectricHeater() {
        count = c.incrementAndGet();
    }
    public void heat() {
        System.out.println("HEATING " + count);
    }
}
