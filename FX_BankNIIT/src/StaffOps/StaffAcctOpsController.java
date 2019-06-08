/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StaffOps;

import View.*;
import Bean.Account;
import Bean.DBHandler;
import Bean.Staff;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ferdinand
 */
public class StaffAcctOpsController implements Initializable {

    @FXML
    private TextField txtAcctSearch;
    @FXML
    private Button btnSearchAcct;
    @FXML
    private TextField txtAcctName;
    @FXML
    private TextField txtAcctNo;
    @FXML
    private TextField txtAcctBal;
    @FXML
    private TextField txtDepAmt;
    @FXML
    private TextField txtNewBal;
    @FXML
    private Button btnAddDepAmt;
    @FXML
    private Button btnDepostOps;
    @FXML
    private TextField txtDepName;
    @FXML
    private Button btnClear;
    
    public Connection con=null;
    public PreparedStatement pstmt=null;
    public Statement st=null;
    public ResultSet rs=null;
    
    DBHandler connect = new DBHandler();
    Account acct = new Account();
    @FXML
    private TextField txtWAcctSearch;
    @FXML
    private Button btnWsearch;
    @FXML
    private TextField txtWAcctName;
    @FXML
    private TextField txtWAcctNo;
    @FXML
    private TextField txtWAcctBall;
    @FXML
    private TextField txtWAmt;
    @FXML
    private TextField txtWNewBal;
    @FXML
    private Button btncomputeW;
    @FXML
    private Button btnCompWithd;
    @FXML
    private TextField txtVSearchAcct;
    @FXML
    private Button btnVSearchAcct;
    @FXML
    private TextField txtVAcctName;
    @FXML
    private TextField txtVAcctNo;
    @FXML
    private TextField txtVAcctBal;
    @FXML
    private Button btnVClear;
    @FXML
    private TextField txtTAcctSearch;
    @FXML
    private Button btnTAcctSearch;
    @FXML
    private TextField txtTacctNameSearch;
    @FXML
    private TextField txtTacctNoSearch;
    @FXML
    private TextField txtTAcctBalSearch;
    @FXML
    private TextField txtAmtToTransfer;
    @FXML
    private TextField txtSendrsNewBal;
    @FXML
    private Button btnComputeAmtTrans;
    @FXML
    private Button btnCompleteTrans;
    @FXML
    private TextField txtTdestAcctNo;
    @FXML
    private TextField txtTdesAcctName;
    @FXML
    private Button btnComputeDestTBal;
    @FXML
    private TextField txtseztNewAcctBal;
    @FXML
    private Button btnTvalAcct;
    @FXML
    private TextField txtTdestAcctBal;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO Perform search operation of account number to 
        //deposit into.
        btnSearchAcct.setOnMouseClicked(event->{
            try {
                searchAcct();
            } catch (Exception e) {
                e.getMessage();
            }
            
        });
        
        //Perform Addition to get new Account Balance
        
               btnAddDepAmt.setOnMouseClicked(event->{
            try {
                addDeposit();
            } catch (Exception e) {
                e.getMessage();
            }
            
        });
               // Completing deposit transaction
        btnDepostOps.setOnMouseClicked(event->{
            try {
                Deposit();
            } catch (Exception e) {
                e.getMessage();
            }
            
        });
        
        //=====================Withdrawal Operation==============================
            //Action to search for inputed Account number    
            btnWsearch.setOnMouseClicked(event->{
            try {
                searchWAcct();
            } catch (Exception e) {
                e.getMessage();
            }
            
        });
            //Action to subtract withdrawal amount from Available Account Balance
            btncomputeW.setOnMouseClicked(event->{
            try {
                solveWithdraw();
            } catch (Exception e) {
                e.getMessage();
            }
            
        });
            //Completing withdrawl operation
            btnCompWithd.setOnMouseClicked(event->{
            try {
                CompleteWithdraw();
            } catch (Exception e) {
                e.getMessage();
            }
            
        });
            //View customers Account Balace
            btnVSearchAcct.setOnMouseClicked(event->{
            try {
                searchVAcct();
            } catch (Exception e) {
                e.getMessage();
            }
            
        });
    }    
    
    
    private void searchAcct(){
        String searchAcct = txtAcctSearch.getText();
        
        if (searchAcct.isEmpty()){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Please Enter Account full name or Account number!");
        alert.showAndWait();
        return;
   
        }else{
            try {
           
                
            acct.setAcctNo(searchAcct);
            
             rs=connect.fetchAccount(acct);           
                    while (rs.next()){
                        
           String alName=rs.getString("a_lname");
           String afName=rs.getString("a_fname");
           String FullName =  alName + "  " + afName ;          
//            txtAcctName.setText(rs.getString("a_fname"));
           txtAcctName.setText(FullName);
//            String actNo=rs.getString("a_acctNo");
            txtAcctNo.setText(rs.getString("a_acctNo"));
//            String acctBal=rs.getString("a_acctBal");
            txtAcctBal.setText(rs.getString("a_acctBal"));
            
            rs.close();
            pstmt.close();
            
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
    
    private void addDeposit() {                                         
        // TODO: add deposit to Account balannce Method -> handling code here:
        
        try{
            String a1=txtAcctBal.getText();
            String a2=txtDepAmt.getText();
            int sum=Integer.parseInt(a1)+Integer.parseInt(a2);
            String sum1=String.valueOf(sum);
            txtNewBal.setText(sum1);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }        
    
        private void Deposit() {                                         
        // TODO: add deposit to Account balannce Method -> handling code here:
        
       try{
            String actNo=txtAcctNo.getText();
            String NactBal=txtNewBal.getText();
            
//            acct.setAcctNo(actNo);
//            acct.setAcctBal(NactBal);
            
            acct = new Account(actNo,NactBal);
            
                         
             
            connect = new DBHandler();
            connect.PerformDeposit(acct);

            JOptionPane.showMessageDialog(null, "Successfully Deposited");

            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        clear();
    }
    
        
        
        public void clear(){
        
            txtAcctSearch.clear();;
            txtAcctName.clear();;
            txtAcctNo.clear();;
            txtAcctBal.clear();
            txtDepAmt.clear();
            txtNewBal.clear();
            txtDepName.clear();
        
        }
        
        /* =========================================================
            Withdrawal Operation
        ==============================================================================================================
        */
        
        private void searchWAcct(){
      
        String searchWAcct = txtWAcctSearch.getText();
        if (searchWAcct.isEmpty()){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Please Enter Account full name or Account number!");
        alert.showAndWait();
        return;
   
        }else{
            try {
           
                
            acct.setAcctNo(searchWAcct);
            
             rs=connect.fetchAccount(acct);           
                    while (rs.next()){
                        
           String alName=rs.getString("a_lname");
           String afName=rs.getString("a_fname");
           String FullName =  alName + "  " + afName ;          
//            txtAcctName.setText(rs.getString("a_fname"));
           txtWAcctName.setText(FullName);
//            String actNo=rs.getString("a_acctNo");
            txtWAcctNo.setText(rs.getString("a_acctNo"));
//            String acctBal=rs.getString("a_acctBal");
            txtWAcctBall.setText(rs.getString("a_acctBal"));
            
            /*
             txtWAcctName;
    @FXML
    private TextField txtWAcctNo;
    @FXML
    private TextField txtWAcctBall;
            */
            
            rs.close();
            pstmt.close();
            
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
        
            private void solveWithdraw() {                                         
        // TODO: add deposit to Account balannce Method -> handling code here:
        
        try{
            String a1=txtWAcctBall.getText();
            String a2=txtWAmt.getText();
            int sum=Integer.parseInt(a1)-Integer.parseInt(a2);
            String sum1=String.valueOf(sum);
            txtWNewBal.setText(sum1);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
            
            private void CompleteWithdraw() {                                         
        // TODO: add deposit to Account balannce Method -> handling code here:
        
       try{
            String actNo=txtWAcctNo.getText();
            String NactBal=txtWNewBal.getText();
            
//            acct.setAcctNo(actNo);
//            acct.setAcctBal(NactBal);
            
            acct = new Account(actNo,NactBal);
            
                         
             
            connect = new DBHandler();
            connect.PerformDeposit(acct);

            JOptionPane.showMessageDialog(null, "Successful Withdrawal");

            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        Wclear();
    }
        
        public void Wclear() {
        txtWAcctSearch.clear();
        txtWAcctName.clear();
        txtWAcctNo.clear();
//            txtAcctNo.clear();
        txtWAcctBall.clear();
        txtWAmt.clear();
        txtWNewBal.clear();
        //txtWName.clear();
    }
        

        private void searchVAcct(){
      
        String searchWAcct = txtVSearchAcct.getText();
        if (searchWAcct.isEmpty()){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Please Enter Account full name or Account number!");
        alert.showAndWait();
        return;
   
        }else{
            try {
           
                
            acct.setAcctNo(searchWAcct);
            
             rs=connect.fetchAccount(acct);           
                    while (rs.next()){
                        
           String alName=rs.getString("a_lname");
           String afName=rs.getString("a_fname");
           String FullName =  alName + "  " + afName ;          
//            txtAcctName.setText(rs.getString("a_fname"));
           txtVAcctName.setText(FullName);
//            String actNo=rs.getString("a_acctNo");
            txtVAcctNo.setText(rs.getString("a_acctNo"));
//            String acctBal=rs.getString("a_acctBal");
            txtVAcctBal.setText(rs.getString("a_acctBal"));

            rs.close();
            pstmt.close();
            
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
    private void clearFields(ActionEvent event) {
        txtVSearchAcct.clear();
        txtVAcctName.clear();
        txtVAcctNo.clear();
        txtVAcctBal.clear();

    }

    /*
    ######## CODES TO PERFOEM ALL TRANSFER CONTROLSA
    */
    //### CODE TO SEARCH RECEIVING ACCOUNT NUMBER OF TRANSFER TRANSACTION
    @FXML
    private void SearchForTransfer(ActionEvent event) {
        
        String searchTAcct = txtTAcctSearch.getText();
        if (searchTAcct.isEmpty()){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Please Enter Account full name or Account number!");
        alert.showAndWait();
        return;
   
        }else{
            try {
           
                
            acct.setAcctNo(searchTAcct);
            
             rs=connect.fetchAccount(acct);           
                    while (rs.next()){
                        
                        
//                        @FXML
//    private TextField txtTAcctSearch;
//    @FXML
//    private Button btnTAcctSearch;
//    @FXML
//    private TextField txtTacctNameSearch;
//    @FXML
//    private TextField txtTacctNoSearch;
//    @FXML
//    private TextField txtTAcctBalSearch;
                        
           String TalName=rs.getString("a_lname");
           String TafName=rs.getString("a_fname");
           String TFullName =  TalName + "  " + TafName ;          
//            txtAcctName.setText(rs.getString("a_fname"));
           txtTacctNameSearch.setText(TFullName);
//            String actNo=rs.getString("a_acctNo");
            txtTacctNoSearch.setText(rs.getString("a_acctNo"));
//            String acctBal=rs.getString("a_acctBal");
            txtTAcctBalSearch.setText(rs.getString("a_acctBal"));

            rs.close();
            pstmt.close();
            
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

    //###### CODE TO CALCULATE AMOUNT REMAINING AFTER TRANSFER FROM SENDERS ACCOUNT #################
    @FXML
    private void getAmtAftTransfer(ActionEvent event) {
      
                try{
            String a1=txtTAcctBalSearch.getText();
            String a2=txtAmtToTransfer.getText();
            int sum=Integer.parseInt(a1)-Integer.parseInt(a2);
            String sum1=String.valueOf(sum);
            txtSendrsNewBal.setText(sum1);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //######### CODE TO COMPLETE TREANFER TRANSACTION
    @FXML
    private void CompleteTransfer(ActionEvent event) {
        
        TansferA();
        TansferB();
        ClearTansFields();
    }

    
    //############ CODE TO COMPUTE AND DETERMINE THE NEW ACCOUNT BALANCE OF THE RECEIVERS ACCOUNT BALANCE OF TRANSFER
    @FXML
    private void ComputeDestTAcctNewBal(ActionEvent event) {
        

try{
            String a1=txtAmtToTransfer.getText();
            String a2=txtTdestAcctBal.getText();
            int sum=Integer.parseInt(a1)+Integer.parseInt(a2);
            String sum1=String.valueOf(sum);
            txtseztNewAcctBal.setText(sum1);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

    }

    //##### CODE TO VALIDATE ACCOUNT NUMBER OF RECEIVER TO CONFIRM NAME AND BALANCE
    @FXML
    private void valDestAcct(ActionEvent event) {
        
         String searchDTAcct = txtTdestAcctNo.getText();
        if (searchDTAcct.isEmpty()){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Please Enter Account full name or Account number!");
        alert.showAndWait();
        return;
   
        }else{
            try {
           
                
            acct.setAcctNo(searchDTAcct);
            
             rs=connect.fetchAccount(acct);           
                    while (rs.next()){

                        
           String DTalName=rs.getString("a_lname");
           String DTafName=rs.getString("a_fname");
           String DTFullName =  DTalName + "  " + DTafName ;          
//            txtAcctName.setText(rs.getString("a_fname"));
           txtTdesAcctName.setText(DTFullName);
//            String actNo=rs.getString("a_acctNo");
//            txtTacctNoSearch.setText(rs.getString("a_acctNo"));
//            String acctBal=rs.getString("a_acctBal");
            txtTdestAcctBal.setText(rs.getString("a_acctBal"));

            rs.close();
            pstmt.close();
            
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
    
    public void TansferA(){
        
         // TODO: Code to initiate transfer and update senders account Balance:
        
       try{
            String TactNo=txtTacctNoSearch.getText();
            String TNactBal=txtSendrsNewBal.getText();
            
//            acct.setAcctNo(actNo);
//            acct.setAcctBal(NactBal);
            
            acct = new Account(TactNo,TNactBal);
            
                         
             
            connect = new DBHandler();
            connect.PerformDeposit(acct);

            JOptionPane.showMessageDialog(null, "Sender Tranafer Successful ");

            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
//        ClearTansFields();
    
    }
    
    public void TansferB(){
    
        // TODO: Code to complete transfer and update receivers account Balance:
        
       try{
            String DTactNo=txtTdestAcctNo.getText();
            String DTNactBal=txtseztNewAcctBal.getText();
            
//            acct.setAcctNo(actNo);
//            acct.setAcctBal(NactBal);
            
            acct = new Account(DTactNo,DTNactBal);
            
                         
             
            connect = new DBHandler();
            connect.PerformDeposit(acct);

            JOptionPane.showMessageDialog(null, "Receiver Tranafer Successful!");

            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
    }
    
    public void ClearTansFields(){
    
        txtTAcctSearch.clear();
        txtTacctNameSearch.clear();
        txtTacctNoSearch.clear();
        txtTAcctBalSearch.clear();
        txtAmtToTransfer.clear();
        txtSendrsNewBal.clear();
        txtTdestAcctNo.clear();
        txtTdesAcctName.clear();
        txtseztNewAcctBal.clear();
        txtTdestAcctBal.clear();
        
    }
        
        
}
