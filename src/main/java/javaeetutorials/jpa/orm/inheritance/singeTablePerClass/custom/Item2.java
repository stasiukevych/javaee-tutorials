package javaeetutorials.jpa.orm.inheritance.singeTablePerClass.custom;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "class_letter", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("I")
public class Item2 {

  @Id
  @GeneratedValue
  private Long id;
  private String description;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Item2 item2 = (Item2) o;
    return Objects.equals(id, item2.id) && Objects.equals(description, item2.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description);
  }
}