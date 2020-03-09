package org.jkan997.booklibrary.scheduled;

import org.slf4j.LoggerFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.jkan997.booklibrary.servlet.ImportBooks;

@Component(name = "Reservation Purge Service", service = Runnable.class, immediate = true, property = {"scheduler.period:Long=10"}) // Executed every 10 seconds
public class ReservationPurgeJob implements Runnable {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ImportBooks.class);

    public void run() {
        LOGGER.info("Executing a perodic job " + getClass().getSimpleName());
        // YOUR IMPLEMENTATION HERE
    }

}
