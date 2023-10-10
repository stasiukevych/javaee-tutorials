package javaeetutorials.jaxrs.crud;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "CARS")
@NamedQuery(name = Car.FIND_ALL, query = "SELECT c FROM Car c")
public class Car {

  public static final String FIND_ALL = "Car.FindAll";

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "NAME_OF")
  private String name;

  @Column(name = "DESCRIPTION")
  private String description;

  @Column(name = "PRICE")
  private BigDecimal cost;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getCost() {
    return cost;
  }

  public void setCost(BigDecimal cost) {
    this.cost = cost;
  }

  @Override
  public String toString() {
    return "Car{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", cost=" + cost +
        '}';
  }
}