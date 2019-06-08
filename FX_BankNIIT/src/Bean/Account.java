/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author Ferdinand
 */
public class Account {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String dob;
    private String city;
    private String address;
    private String gender;
    private String nationality;
    private String acctNo;
    private String acctBal;

    public Account() {
    }

    public Account(String acctNo, String acctBal) {
        this.acctNo = acctNo;
        this.acctBal = acctBal;
    }

    public Account(String firstName, String lastName, String phone, String email, String dob, String city, String address, String gender, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.city = city;
        this.address = address;
        this.gender = gender;
        this.nationality = nationality;
    }
    
    

    public Account(String firstName, String lastName, String phone, String email, String dob, String city, String address, String gender, String nationality, String acctNo, String acctBal) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.city = city;
        this.address = address;
        this.gender = gender;
        this.nationality = nationality;
        this.acctNo = acctNo;
        this.acctBal = acctBal;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getAcctBal() {
        return acctBal;
    }

    public void setAcctBal(String acctBal) {
        this.acctBal = acctBal;
    }
    
    
    
}
