package org.jkan997.booklibrary.scheduled;

import org.slf4j.LoggerFactory;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.annotations.Property;
import org.jkan997.booklibrary.servlet.ImportBooks;

@Component
@Service(value = Runnable.class)
@Property(name = "scheduler.period", longValue = 10) // Executed every 10 seconds
public class ReservationPurgeJob implements Runnable {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ImportBooks.class);

    public void run() {
        LOGGER.info("Executing a perodic job " + getClass().getSimpleName());
        // YOUR IMPLEMENTATION HERE
    }

}
