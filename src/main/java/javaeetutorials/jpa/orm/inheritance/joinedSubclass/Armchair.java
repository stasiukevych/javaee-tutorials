package javaeetutorials.jpa.orm.inheritance.joinedSubclass;

import jakarta.persistence.Entity;

@Entity
public class Armchair extends Item3 {

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