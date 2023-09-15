package javaeetutorials.jpa.orm.primaryKeys.embeddable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class News {

  @EmbeddedId
  private NewsId id;
  private String content;
  private String description;

  public NewsId getId() {
    return id;
  }

  public void setId(NewsId id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "News{" +
        "id=" + id +
        ", content='" + content + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}