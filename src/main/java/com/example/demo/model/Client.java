package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Clients")
public class Client {
    
    @Id
    @GeneratedValue
    @Column(name="Id")
    private int id;

    @Column(name="companyName")
    private String companyName;
    
    @Column(name="contactName")
    private String contactName;
    
    @Column(name="phoneNumber")
    private String phoneNumber;


    public Client() {
    }

    public Client(String companyName, String contactName, String phoneNumber) {
        this.companyName = companyName;
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public String toString() {
        return "Client [id=" + id + ", companyName=" + companyName + ", contactName=" + contactName + ", phoneNumber="
                + phoneNumber + "]";
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
