package javaeetutorials.cdi.events;

import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

public class LaptopService {

    @Inject
    @Additional
    private Event<Laptop> addedLaptop;

    @Inject
    @Removable
    private Event<Laptop> removedLaptop;

    public Laptop create(String name, String version) {
        Laptop laptop = new Laptop();
        laptop.name = name;
        laptop.version = version;
        addedLaptop.fire(laptop);
        return laptop;
    }

    public Laptop remove(Laptop laptop) {
        removedLaptop.fire(laptop);
        return laptop;
    }
}