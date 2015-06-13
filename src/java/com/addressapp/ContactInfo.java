
package com.addressapp;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

public class ContactInfo {
    private String name;
    @Id
    private String mobileNumber;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private String city;    
    private String gender;
    private String category;
    private String userName;

    public ContactInfo() {
    }

    public ContactInfo(String name, String mobileNumber, String email, Date dateOfBirth, String city, String gender, String category, String userName) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.gender = gender;
        this.category = category;
        this.userName = userName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String MobileNumber) {
        this.mobileNumber = MobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.dateOfBirth = DateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String City) {
        this.city = City;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String Gender) {
        this.gender = Gender;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String Category) {
        this.category = Category;
    }
    
    public String getDob(){
        SimpleDateFormat fmt= new SimpleDateFormat("MM/dd/yyyy");
        String str=fmt.format(dateOfBirth);
        return str;
    }
    
}
