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
public class FinalUser {
    
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty phone;
    private final SimpleStringProperty email;
    private final SimpleStringProperty acctNo;
    private final SimpleStringProperty acctBal;

    public FinalUser(String fName, String lName, String phne, String eml, String aNo, String aBal) {
       
        this.firstName= new SimpleStringProperty(fName);
        this.lastName= new SimpleStringProperty(lName);
        this.phone= new SimpleStringProperty(phne);
        this.email= new SimpleStringProperty(eml);
        this.acctNo= new SimpleStringProperty(aNo);     
        this.acctBal= new SimpleStringProperty(aBal);
    }
        

    public String getFirstName() {
        return firstName.get();
    }

    public String getLastName() {
        return lastName.get();
    }

    public String getPhone() {
        return phone.get();
    }

    public String getEmail() {
        return email.get();
    }

    
    public String getAcctNo() {
        return acctNo.get();
    }

    public String getAcctBal() {
        return acctBal.get();
    }
    
    
    //SETTERS
    public void setFirstName(String fName) {
        firstName.set(fName);
    }
//String ftName, String lName, String phne, String eml, String dOb, String cty, String add, String gndr, String nat, String aNo, String aBal
        
    public void setLastName(String lName) {
        lastName.set(lName);
    }


    public void setPhone(String phne) {
        phone.set(phne);
    }

        public void setEmail(String eml) {
        email.set(eml);
    }

    public void setAcctNo(String aNo) {
        acctNo.set(aNo);
    }

             public void setAcctBal(String aBal) {
        acctBal.set(aBal);
    }
    
    
}
