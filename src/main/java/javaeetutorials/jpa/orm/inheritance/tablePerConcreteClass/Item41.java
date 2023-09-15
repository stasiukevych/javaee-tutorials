package javaeetutorials.jpa.orm.inheritance.tablePerConcreteClass;

import jakarta.persistence.Entity;

@Entity
public class Item41 extends Item4 {

  private Long length;
  private Long height;

  public Long getLength() {
    return length;
  }

  public void setLength(Long length) {
    this.length = length;
  }

  public Long getHeight() {
    return height;
  }

  public void setHeight(Long height) {
    this.height = height;
  }
}