/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Ferdinand
 */
public class FinalStaff {
    protected SimpleStringProperty firstName;
    protected SimpleStringProperty lastName;
    protected SimpleStringProperty email;
    protected SimpleStringProperty phone;
    protected SimpleStringProperty address;
    protected SimpleStringProperty dob;

    public FinalStaff(String fName, String lName, String eml, String phne, String add, String DOB) {
        this.firstName =new SimpleStringProperty(fName) ;
        this.lastName =new SimpleStringProperty (lName);
        this.email =new SimpleStringProperty (eml);
        this.phone =new SimpleStringProperty (phne);
        this.address = new SimpleStringProperty (add);
        this.dob = new SimpleStringProperty (DOB);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public String getLastName() {
        return lastName.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getPhone() {
        return phone.get();
    }

    public String getAddress() {
        return address.get();
    }

    public String getDob() {
        return dob.get();
    }
    
    
    
    
   
    
}
