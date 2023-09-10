package javaeetutorials.jpa.orm.inheritance.singeTablePerClass.custom;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("S")
public class CustomItem21 extends Item2 {

    private String customName2;

    public String getCustomName2() {
        return customName2;
    }

    public void setCustomName2(String customName2) {
        this.customName2 = customName2;
    }
}