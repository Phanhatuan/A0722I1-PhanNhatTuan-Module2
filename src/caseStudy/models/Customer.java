package caseStudy.models;

import java.time.LocalDate;

public class Customer extends Person{
    private static int idOrder = 0;
    private int customerId;
    private String typeCustomer;
    private String address;

    public Customer() {
        this.customerId = idOrder++;
    }

    public Customer(String name, String birthDay, String gender, String id, String tel, String email, String typeCustomer, String address) {
        super(name, birthDay, gender, id, tel, email);
        this.customerId = idOrder++;
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name = " + getName() + '\'' +
                " birthDay = " +getBirthDay() + '\'' +
                " gender = " + getGender() + '\'' +
                " id = " + getId() + '\'' +
                " tel = " + getTel() + '\'' +
                " email = " + getEmail() + '\'' +
                "customerId= " + customerId + '\'' +
                ", typeCustomer= '" + typeCustomer + '\'' +
                ", address= '" + address + '\'' +
                '}';
    }
}
