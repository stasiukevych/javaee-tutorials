package javaeetutorials.jpa.orm.attributes;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(nullable = false)
    private String nameOfCustomer;
    @Temporal(TemporalType.TIME)
    private Date requestToStoreHistory;
    @Enumerated(EnumType.STRING)
    private CustomerType customerType;
    @Embedded
    private Address2 address2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

    public void setNameOfCustomer(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
    }

    public Date getRequestToStoreHistory() {
        return requestToStoreHistory;
    }

    public void setRequestToStoreHistory(Date requestToStoreHistory) {
        this.requestToStoreHistory = requestToStoreHistory;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Address2 getAddress() {
        return address2;
    }

    public void setAddress(Address2 address2) {
        this.address2 = address2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(dateOfBirth, customer.dateOfBirth) && Objects.equals(nameOfCustomer, customer.nameOfCustomer) && Objects.equals(requestToStoreHistory, customer.requestToStoreHistory) && customerType == customer.customerType && Objects.equals(address2, customer.address2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOfBirth, nameOfCustomer, requestToStoreHistory, customerType, address2);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", dateOfBirth=" + dateOfBirth +
                ", nameOfCustomer='" + nameOfCustomer + '\'' +
                ", requestToStoreHistory=" + requestToStoreHistory +
                ", customerType=" + customerType +
                ", address=" + address2 +
                '}';
    }
}