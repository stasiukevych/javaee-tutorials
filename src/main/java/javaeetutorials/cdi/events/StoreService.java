package javaeetutorials.cdi.events;

import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Singleton
public class StoreService {

    @Inject
    private Logger logger;

    private final List<Laptop> laptops = new ArrayList<>();

    public void addLaptop(@Observes @Additional Laptop laptop) {
        laptops.add(laptop);
        logger.info("was added: " + laptop);
    }

    public void removeLaptop(@Observes @Removable Laptop laptop) {
        laptops.remove(laptop);
        logger.info("was removed: " + laptop);
    }
}