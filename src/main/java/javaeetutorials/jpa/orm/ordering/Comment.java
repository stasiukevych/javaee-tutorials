package javaeetutorials.jpa.orm.ordering;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "CUSTOM_COMMENTS")
public class Comment {

  @Id
  @GeneratedValue
  private Long id;
  private String nickname;
  private String content;
  private Integer note;
  @Column(name = "posted_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date postedDate;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Integer getNote() {
    return note;
  }

  public void setNote(Integer note) {
    this.note = note;
  }

  public Date getPostedDate() {
    return postedDate;
  }

  public void setPostedDate(Date postedDate) {
    this.postedDate = postedDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Comment comment = (Comment) o;
    return Objects.equals(id, comment.id) && Objects.equals(nickname, comment.nickname)
        && Objects.equals(content, comment.content) && Objects.equals(note, comment.note)
        && Objects.equals(postedDate, comment.postedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nickname, content, note, postedDate);
  }

  @Override
  public String toString() {
    return "Comment{" +
        "id=" + id +
        ", nickname='" + nickname + '\'' +
        ", content='" + content + '\'' +
        ", note=" + note +
        ", postedDate=" + postedDate +
        '}';
  }
}