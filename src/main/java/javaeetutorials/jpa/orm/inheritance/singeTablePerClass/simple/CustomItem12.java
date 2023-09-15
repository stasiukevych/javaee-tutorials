package javaeetutorials.jpa.orm.inheritance.singeTablePerClass.simple;

import jakarta.persistence.Entity;

@Entity
public class CustomItem12 extends Item1 {

  private String customName12;

  public String getCustomName12() {
    return customName12;
  }

  public void setCustomName12(String customName12) {
    this.customName12 = customName12;
  }
}