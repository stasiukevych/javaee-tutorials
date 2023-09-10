package javaeetutorials.jpa.orm.inheritance.singeTablePerClass.simple;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Item1 {

    @Id
    @GeneratedValue
    private Long id;
    private String description;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item1 item1 = (Item1) o;
        return Objects.equals(id, item1.id) && Objects.equals(description, item1.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}