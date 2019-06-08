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
public class Staff {
    //protected int userID;
    protected String firstName;
    protected String lastName;
    protected String phone;
    protected String dob;
    protected String email;
    protected String pass;
    protected String address;
    protected String role;

    public Staff() {
    }

    //Constructor with role
    public Staff(String firstName, String lastName, String phone, String dob, String email, String pass, String address, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.dob = dob;
        this.email = email;
        this.pass = pass;
        this.address = address;
        this.role = role;
    }
    
    
    
    //Constructor without role
    public Staff(String firstName, String lastName, String phone, String dob, String email, String pass, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.dob = dob;
        this.email = email;
        this.pass = pass;
        this.address = address;
    }

    public Staff(String email, String pass) {
        this.email = email;
        this.pass = pass;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
    
    
}
