package javaeetutorials.jpa.orm.inheritance.singeTablePerClass.simple;

import jakarta.persistence.Entity;

@Entity
public class CustomItem11 extends Item1{

    private String customName1;

    public String getCustomName1() {
        return customName1;
    }

    public void setCustomName1(String customName1) {
        this.customName1 = customName1;
    }
}