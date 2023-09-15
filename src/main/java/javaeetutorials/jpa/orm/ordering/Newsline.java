package javaeetutorials.jpa.orm.ordering;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "NEWS_LINE")
public class Newsline {

  @Id
  @GeneratedValue
  private Long id;
  @Column(nullable = false)
  private String content;
  @OneToMany(fetch = FetchType.EAGER)
  @OrderBy("postedDate DESC")
  @JoinColumn(name = "comment_fk")
  private List<Comment> comments;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Newsline newsline = (Newsline) o;
    return Objects.equals(id, newsline.id) && Objects.equals(content, newsline.content)
        && Objects.equals(comments, newsline.comments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, content, comments);
  }

  @Override
  public String toString() {
    return "Newsline{" +
        "id=" + id +
        ", content='" + content + '\'' +
        ", comments=" + comments +
        '}';
  }
}