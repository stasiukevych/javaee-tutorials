package javaeetutorials.jpa.orm.primaryKeys.idClass;

import java.util.Objects;

public class LaptopID {

  private Long id;
  private String version;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LaptopID laptopID = (LaptopID) o;
    return Objects.equals(id, laptopID.id) && Objects.equals(version, laptopID.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, version);
  }

  @Override
  public String toString() {
    return "LaptopID{" +
        "id=" + id +
        ", version='" + version + '\'' +
        '}';
  }
}