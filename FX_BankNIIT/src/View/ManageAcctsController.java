/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Bean.Account;
import Bean.DBHandler;
import Bean.FinalUser;
import Bean.Staff;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Ferdinand
 */
public class ManageAcctsController implements Initializable {

    @FXML
    private TextField txtFName;
    @FXML
    private TextField txtLName;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtCity;
    @FXML
    private TextField txtAccountNo;
    @FXML
    private TextField txtAccountBal;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnCreateAcct;
    @FXML
    private DatePicker dateDOB;
    @FXML
    private ComboBox<String> comboGender;
    @FXML
    private ComboBox<String> comboNational;
    @FXML
    private Button btnGenAcctNo;

    ObservableList<String> gender = FXCollections.observableArrayList();

    ObservableList<String> national = FXCollections.observableArrayList();

//    final ObservableList<FinalUser> list=FXCollections.observableArrayList();
//    @FXML
//    private TableView<FinalUser> tableViewFinalU;
//    @FXML
//    private TableColumn<FinalUser, String> colFname;
//    @FXML
//    private TableColumn<FinalUser, String> colLName;
//    @FXML
//    private TableColumn<FinalUser, String> colPhone;
//    @FXML
//    private TableColumn<FinalUser, String> colEmail;
//    @FXML
//    private TableColumn<FinalUser, String> colAcctNo;
//    @FXML
//    private TableColumn<FinalUser, String> colAcctBal;
    DBHandler connect = new DBHandler();
    public PreparedStatement pstmt = null;
    public Statement st = null;
    public ResultSet rs = null;

//    @FXML
//    private Button btnVsearchAcct;
//    @FXML
//    private TextField txtVfName;
//    @FXML
//    private TextField txtVlName;
//    @FXML
//    private TextField txtVPhone;
//    @FXML
//    private TextField txtVEmail;
//    @FXML
//    private TextField txtAdd;
//    @FXML
//    private TextField txtVAcctNo;
//    @FXML
//    private TextField txtVAcctBal;
//    @FXML
//    private Button btnDeletAcct;
//    @FXML
//    private Button txtUpdateAcct;
//    @FXML
//    private DatePicker txtDateEditor;
//    @FXML
//    private Button txtVEdit;
//    private ComboBox<String> comboVGender;
//    private ComboBox<String> comboVNat;
    DBHandler conneect = new DBHandler();
    Account acct = new Account();
//    @FXML
//    private TextField txtSearchVAcct;
//    @FXML
//    private TextField txtVCity;
    @FXML
    private TextField txtVSearchVAcct;
    @FXML
    private Button btnVsearchAcct;
    @FXML
    private TextField txtVfName;
    @FXML
    private TextField txtVlName;
    @FXML
    private TextField txtVPhone;
    @FXML
    private TextField txtVEmail;
    @FXML
    private TextField txtVAdd;
    @FXML
    private TextField txtVCity;
    @FXML
    private TextField txtVAcctNo;
    @FXML
    private TextField txtVAcctBal;
    @FXML
    private Button btnDeletAcct;
    @FXML
    private Button txtUpdateAcct;
    @FXML
    private DatePicker txtDateEditor;
    @FXML
    private Button txtVEdit;
    @FXML
    private ComboBox<String> combVAGendr;
    @FXML
    private ComboBox<String> combVANat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Load ListAccout TableView
        //   ListAcct();
        //populate gender observablelist
        gender.add("Male");
        gender.add("Female");
        comboGender.setItems(gender);
        combVAGendr.setItems(gender);
//        comboVGender.setItems(gender);

        //populate Nationality observablelist
        national.add("Nigeria");
        national.add("USA");
        national.add("Canada");
        national.add("UK");
        comboNational.setItems(national);
        combVANat.setItems(national);
//        comboVNat.setItems(national);

        //Button action to generate Account Numbers
        btnGenAcctNo.setOnMouseClicked(event -> {
            RandomAcct();
        });

        btnCreateAcct.setOnMouseClicked(event -> {
            try {
                SaveNewAcct();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StaffViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //Clear Create account fields if decision to proceed is negative
                btnClear.setOnMouseClicked(event -> {
            clearCrtAcctFields();
        });

        btnVsearchAcct.setOnMouseClicked(event -> {
            try {
                searchAcctToEdit();
            } catch (Exception e) {
                e.getMessage();
            }
            
        });
    }

    public void SaveNewAcct() throws ClassNotFoundException {
        String fname = txtFName.getText();
        String lname = txtLName.getText();
        String phone = txtPhone.getText();
        String email = txtEmail.getText();
        String dateB = ((TextField) dateDOB.getEditor()).getText();
        String city = txtCity.getText();
        String addr = txtAddress.getText();
        String gender = comboGender.getValue();
        String national = comboNational.getValue();
        String acttNo = txtAccountNo.getText();
        String acctBal = txtAccountBal.getText();

        if (fname.isEmpty() || lname.isEmpty() || phone.isEmpty() || dateB.isEmpty() || email.isEmpty() || city.isEmpty()
                || addr.isEmpty() || gender.isEmpty() || national.isEmpty() || acttNo.isEmpty() || acctBal.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Enter all fields!");
            alert.showAndWait();
            return;
        }
        int minBal = 500;
        if (Integer.parseInt(acctBal) <= minBal) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Minimum Balance to create an Accout is #500!");
            alert.showAndWait();
            return;
        } else {

            try {
                Account acct = new Account(fname, lname, phone, email, dateB, city, addr, gender, national, acttNo, acctBal);

                DBHandler connect = new DBHandler();
                connect.addAccount(acct);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Account Created Successfully!");
                alert.showAndWait();

            } catch (Exception e) {
                System.err.println(e);
            }
            //clearFields();     
            clearCrtAcctFields();
        }

    }
   
    private void clearCrtAcctFields() {
                txtFName.setText("");
        txtLName.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        ((TextField)dateDOB.getEditor()).setText("");
        txtCity.setText("");
         txtAddress.setText("");
        comboGender.setValue("");
        comboNational.setValue("");
        txtAccountNo.setText("");
        txtAccountBal.setText("");
    }
    
    
    //#### Code to generate Account Numbers
    public void RandomAcct() {
        Random ra = new Random();

        txtAccountNo.setText("00" + ra.nextInt(10000 + 1));
    }
    
    
    //########## CODE TO SEARCH ACCOUNT TO PERFORM UPDATE OR DELETE OPERATION

    public void searchAcctToEdit() {

        String AcctToEdit = txtVSearchVAcct.getText();
        if (AcctToEdit.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Account number!");
            alert.showAndWait();
            return;
            
        } else {
            try {
                
                acct.setAcctNo(AcctToEdit);

                rs = connect.fetchAccount(acct);
                    
                while (rs.next()) {
                  

                    String afName = rs.getString("a_fname");
                    String alName = rs.getString("a_lname");
                    String aPhone = rs.getString("a_phone");
                    String aEmail = rs.getString("a_email");
                    String aDob=rs.getString("a_dob");
                    //String aDob = ((DatePicker)dateDOB.getValue(rs.getDate("a_dob")));
                    String aCty = rs.getString("a_city");
                    String aAdd = rs.getString("a_address");
                    String aGendr = rs.getString("a_gender");
                    String aNat = rs.getString("a_national");
                    String aNo = rs.getString("a_acctNo");
                    String aBal = rs.getString("a_acctBal");

//        a_fname, a_lname, a_phone,a_email, a_dob,  a_city, a_address,a_gender,a_national,a_acctNo,a_acctBal        
//               txtVfName.setEditable(true);
//    txtVlName.setEditable(true);
//    txtVPhone.setEditable(true);
//    txtVEmail.setEditable(true);
//    txtAdd.setEditable(true);
//    txtVAcctNo.setEditable(true);
//    txtVAcctBal
//    txtDateEditor.setEditable(true);
                    txtVfName.setText(afName);
                    txtVlName.setText(alName);
                    txtVPhone.setText(aPhone);
                    txtVEmail.setText(aEmail);
                    //((TextField)date.getEditor().setText(aDob));
                    //txtDateEditor
                    txtDateEditor.getEditor().setText(aDob);
                    txtVCity.setText(aCty);
                    txtVAdd.setText(aAdd);
                    combVAGendr.setValue(aGendr);
                    combVANat.setValue(aNat);
                    txtVAcctNo.setText(aNo);
                    txtVAcctBal.setText(aBal);

                   
                    rs.close();
//            pstmt.close();

                }
            } catch (SQLException e) {
                e.getMessage();
            }

        }

          Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Such Account does not exist!");
                    alert.showAndWait();
    }

    @FXML
    private void delAcctMan(ActionEvent event) {
    }

    @FXML
    private void updtAcctMan(ActionEvent event) {
        
        String UVfname = txtVfName.getText();
        String UVlname = txtVlName.getText();
        String UVphone = txtVPhone.getText();
        String UVemail = txtVEmail.getText();
        String UVdateB = ((TextField) txtDateEditor.getEditor()).getText();
        String UVcity = txtVCity.getText();
        String UVaddr = txtAddress.getText();
        String UVgender = combVAGendr.getValue();
        String UVnational = combVANat.getValue();
//        String UVacttNo = txtAccountNo.getText();
//        String UVacctBal = txtAccountBal.getText();

        if (UVfname.isEmpty() || UVlname.isEmpty() || UVlname.isEmpty() || UVemail.isEmpty() || UVdateB.isEmpty() || UVcity.isEmpty()
                || UVaddr.isEmpty() || UVgender.isEmpty() || UVnational.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Enter all fields!");
            alert.showAndWait();
            return;
        }
        
// txtVfName;
//    txtVlName;
//  txtVPhone;
//  txtVEmail;
//    txtVAdd;
//  txtVCity;
//   txtVAcctNo'
//   txtVAcctBal;
//    txtUpdateAcct;
//  txtDateEditor;
//   txtVEdit;
//   combVAGendr;
//  combVANat;

            try {
                Account acct = new Account(UVfname, UVlname, UVlname, UVemail, UVdateB, UVcity, UVaddr, UVgender, UVnational);

                DBHandler connect = new DBHandler();
                connect.addAccount(acct);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Account Created Successfully!");
                alert.showAndWait();

            } catch (Exception e) {
                System.err.println(e);
            }
            //clearFields();     
            clearCrtAcctFields();
        }
    
    @FXML
    private void setFldsEditable(ActionEvent event) {

        txtVfName.setEditable(true);
        txtVlName.setEditable(true);
        txtVPhone.setEditable(true);
        txtVEmail.setEditable(true);
        //((TextField)date.getEditor().setText(aDob));
        //txtDateEditor
        txtDateEditor.getEditor().setEditable(true);
        txtVCity.setEditable(true);
        txtVAdd.setEditable(true);

    }
    
    
    
    
}



