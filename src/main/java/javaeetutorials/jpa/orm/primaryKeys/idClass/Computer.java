package javaeetutorials.jpa.orm.primaryKeys.idClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(LaptopID.class)
public class Computer {

  @Id
  private Long id;
  @Id
  private String version;
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Computer{" +
        "id=" + id +
        ", version='" + version + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}