package by.shpak.laba1.counter;

import org.apache.log4j.Logger;

public class Counter {
    public static Logger logger = Logger.getLogger(Counter.class);
    private static int counter = 0;
    public static synchronized void inc(){
        counter++;
        logger.info("counter incremented, current value: " + counter);
    }
}
