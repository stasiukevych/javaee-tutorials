package javaeetutorials.jpa.orm.relationship;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CUSTOM_ORDER")
@Cacheable(value = true)
public class Order {

  @Id
  @GeneratedValue
  private Long id;
  @Version
  private Integer version;
  @Temporal(TemporalType.DATE)
  private Date creation;
  private String description;
  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "order_fk")
  private List<OrderLine> orderLines;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getCreation() {
    return creation;
  }

  public void setCreation(Date creation) {
    this.creation = creation;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<OrderLine> getOrderLines() {
    return orderLines;
  }

  public void setOrderLines(List<OrderLine> orderLines) {
    this.orderLines = orderLines;
  }

  public Integer getVersion() {
    return version;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(id, order.id) && Objects.equals(creation, order.creation)
        && Objects.equals(description, order.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, creation, description);
  }

  @Override
  public String toString() {
    return "Order{" +
        "id=" + id +
        ", creation=" + creation +
        ", description='" + description +
        '}';
  }
}