package javaeetutorials.cdi.events;

import java.util.Objects;

public class Laptop {

  public String name;

  public String version;

  @Override
  public String toString() {
    return "processed the next one Laptop{" +
        "name='" + name + '\'' +
        ", version='" + version + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Laptop laptop = (Laptop) o;
    return Objects.equals(name, laptop.name) && Objects.equals(version, laptop.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, version);
  }
}