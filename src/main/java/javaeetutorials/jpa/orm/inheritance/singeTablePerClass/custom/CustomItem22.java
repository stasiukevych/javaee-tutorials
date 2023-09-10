package javaeetutorials.jpa.orm.inheritance.singeTablePerClass.custom;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class CustomItem22 extends Item2 {

    private String customName3;

    public String getCustomName3() {
        return customName3;
    }

    public void setCustomName3(String customName3) {
        this.customName3 = customName3;
    }
}