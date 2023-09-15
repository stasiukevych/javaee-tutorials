package javaeetutorials.jpa.orm.inheritance.joinedSubclass;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Item3 {

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
    Item3 item3 = (Item3) o;
    return Objects.equals(id, item3.id) && Objects.equals(description, item3.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description);
  }
}