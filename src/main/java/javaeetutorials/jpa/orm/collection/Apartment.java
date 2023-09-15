package javaeetutorials.jpa.orm.collection;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Apartment {

  @Id
  private Long id;

  private String description;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "ROOMS")
  @Column(name = "VALUE")
  private List<String> rooms = new ArrayList<>();

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

  public List<String> getRooms() {
    return rooms;
  }

  public void setRooms(List<String> rooms) {
    this.rooms = rooms;
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
    Apartment apartment = (Apartment) o;
    return Objects.equals(id, apartment.id) && Objects.equals(description, apartment.description)
        && Objects.equals(rooms, apartment.rooms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, rooms);
  }
}