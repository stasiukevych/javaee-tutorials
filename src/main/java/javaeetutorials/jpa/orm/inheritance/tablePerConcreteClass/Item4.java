package javaeetutorials.jpa.orm.inheritance.tablePerConcreteClass;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Item4 {

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
    Item4 item4 = (Item4) o;
    return Objects.equals(id, item4.id) && Objects.equals(description, item4.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description);
  }
}