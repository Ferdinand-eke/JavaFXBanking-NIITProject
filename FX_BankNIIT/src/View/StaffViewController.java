/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Bean.DBHandler;
import Bean.Staff;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ferdinand
 */
public class StaffViewController implements Initializable {

    @FXML
    private PasswordField txtPass;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtAddress;
    @FXML
    private DatePicker dob;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtFname;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnSave;
    @FXML
    private TextField txtLname;
    @FXML
    private Button btnDelStaff;
    @FXML
    private Button btnUpdtStaf;
    @FXML
    private TextField txtStafNoToMan;
    @FXML
    private Button btnSerchStafMan;
    @FXML
    private TableView<?> staffTabView;
    @FXML
    private TableColumn<?, ?> colID;
    @FXML
    private TableColumn<?, ?> colFName;
    @FXML
    private TableColumn<?, ?> colLName;
    @FXML
    private TableColumn<?, ?> colEmail;
    @FXML
    private TableColumn<?, ?> colPhone;
    @FXML
    private TableColumn<?, ?> colAdd;
    @FXML
    private TableColumn<?, ?> colDOB;

    DBHandler connect = new DBHandler();
        public PreparedStatement pstmt = null;
    public Statement st = null;
    public ResultSet rs = null;
    
    Staff staff = new Staff();
    ObservableList<String> role = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> comboSRole;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //List for role comboBox selection
        role.add("Admin");
        role.add("User");
        comboSRole.setItems(role);
        
        
        //Action to save or add new staff
        btnSave.setOnMouseClicked(event->{
            try {
                SaveStaff();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StaffViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }    

    public void SaveStaff() throws ClassNotFoundException  {
        String fname = txtFname.getText();
        String lname =txtLname.getText();
        String phone =txtPhone.getText();
        String dateB =((TextField)dob.getEditor()).getText();
//        Date date =datepicker.getValue();
        String email = txtEmail.getText();
        String pass = txtPass.getText();
        String addr = txtAddress.getText();
        String role = comboSRole.getValue();
        
              if (fname.isEmpty()||lname.isEmpty()||phone.isEmpty()||dateB.isEmpty()||email.isEmpty()||pass.isEmpty()||addr.isEmpty()||role.isEmpty()){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Please Enter all fields!");
        alert.showAndWait();
        return;
   
        }
              try {
              staff = new Staff(fname, lname,phone,dateB,email,pass,addr,role);
             
            
            connect.addStadd(staff);
           
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Staff added Successfully!");
        alert.showAndWait();
   
        } catch (Exception e) {
            System.err.println(e);
        }
         clearFields();
        
    }

    @FXML
    private void DeletStaff(ActionEvent event) {
        
    }

    @FXML
    private void UpdateStafDet(ActionEvent event) {
        
         String Ufname = txtFname.getText();
        String Ulname =txtLname.getText();
        String Uphone =txtPhone.getText();
        String UdateB =((TextField)dob.getEditor()).getText();
//        Date date =datepicker.getValue();
        String Uemail = txtEmail.getText();
        String Upass = txtPass.getText();
        String Uaddr = txtAddress.getText();
        String Urole = comboSRole.getValue();
        
              if (Ufname.isEmpty()||Ulname.isEmpty()||Uphone.isEmpty()||UdateB.isEmpty()||Uemail.isEmpty()||Upass.isEmpty()||Uaddr.isEmpty()||Urole.isEmpty()){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Please Enter all fields!");
        alert.showAndWait();
        return;
   
        }
              try {
              staff = new Staff(Ufname,Ulname,Uphone,UdateB,Uemail,Upass,Uaddr,Urole);
             
            
            connect.UpdateStaff(staff);
           
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Staff UPDATED Successfully!");
        alert.showAndWait();
   
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }
         clearFields();
        
    }

    @FXML
    private void SearchStaffMan(ActionEvent event) {
        String email = txtStafNoToMan.getText();
        
       
        if (email.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Enter An Email Address!");
            alert.showAndWait();
            return;
            
        } 
        else {
            try {
                Staff st = new Staff();
                st.setEmail(email);

                rs = connect.searchUserForMan(st);
                    
                while (rs.next()) {
                  

                    String sfName = rs.getString("s_fname");
                    String slName = rs.getString("s_lname");
                    String sPhone = rs.getString("s_phone");
                    String sDob=rs.getString("s_dob");
                    String sEmail = rs.getString("s_email");
                    //s_fname, s_lname, s_phone, s_dob, s_email, s_pass, s_address
                
                    String sPass = rs.getString("s_pass");
                    String sAdd = rs.getString("s_address");
                    String sRole = rs.getString("s_role");
//                    System.out.println(rs);

                    txtFname.setText(sfName);
                    txtLname.setText(slName);
                    txtPhone.setText(sPhone);
                    txtEmail.setText(sEmail);
                    dob.getEditor().setText(sDob);
                    txtPass.setText(sPass);
                    txtAddress.setText(sAdd);
                    comboSRole.setValue(sRole);

                   
                    rs.close();
            pstmt.close();
                }
            } catch (SQLException e) {
                e.getMessage();
            }  
    clearFields();
    }
  }
    
    public void clearFields() {
        txtFname.setText("");
        txtLname.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        dob.getEditor().setText("");
        txtPass.setText("");
        txtAddress.setText("");
        comboSRole.setValue("");

    }
}
