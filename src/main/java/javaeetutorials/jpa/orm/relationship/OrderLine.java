package javaeetutorials.jpa.orm.relationship;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "ORDER_LINE")
public class OrderLine {

    @Id
    @GeneratedValue
    private Long id;
    private Integer numberOfLine;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberOfLine() {
        return numberOfLine;
    }

    public void setNumberOfLine(Integer numberOfLine) {
        this.numberOfLine = numberOfLine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return Objects.equals(id, orderLine.id) && Objects.equals(numberOfLine, orderLine.numberOfLine) && Objects.equals(description, orderLine.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOfLine, description);
    }
}