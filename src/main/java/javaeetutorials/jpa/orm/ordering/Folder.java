package javaeetutorials.jpa.orm.ordering;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "FOLDERS")
public class Folder {

  @Id
  @GeneratedValue
  private Long id;
  private String name;
  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "file_fk")
  @OrderColumn(name = "file_index")
  private List<Files> files;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Files> getFiles() {
    return files;
  }

  public void setFiles(List<Files> files) {
    this.files = files;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Folder folder = (Folder) o;
    return Objects.equals(id, folder.id) && Objects.equals(name, folder.name) && Objects.equals(
        files, folder.files);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, files);
  }

  @Override
  public String toString() {
    return "Folder{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", files=" + files +
        '}';
  }
}