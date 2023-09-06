package javaeetutorials.jpa.orm.attributes;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Address2 {

    private String country;
    private String region;
    private String settlement;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address2 address2 = (Address2) o;
        return Objects.equals(country, address2.country) && Objects.equals(region, address2.region) && Objects.equals(settlement, address2.settlement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, region, settlement);
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", settlement='" + settlement + '\'' +
                '}';
    }
}