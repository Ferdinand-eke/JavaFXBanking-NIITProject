package Index;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Bean.Account;
import Bean.DBHandler;
import Bean.Staff;
import StaffOps.StaffAcctOpsController;
import Utils.Constants;
import View.MainViewController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;



 

/**
 *
 * @author Ferdinand
 */
public class LogSController implements Initializable {
    
    private Label label;
    @FXML
    private JFXTextField txtUsername;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private JFXButton btnLogin;
    
    DBHandler connect = new DBHandler();
    public PreparedStatement pstmt = null;
    public Statement st = null;
    public ResultSet rs = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goToMainPage(ActionEvent event) throws IOException {
        
         String user=txtUsername.getText();
         String pwd=txtPassword.getText();
//          System.out.println("i have been clicked");
            try {
            
                Staff staff = new Staff(user,pwd);
                
                
                connect = new DBHandler();
                 rs=connect.getUser(staff);
                
                int counter=0;
                if(rs.next())
                {
                 counter++;
                 String name =rs.getString("s_fname");
                 String role =rs.getString("s_role");
                 System.out.println(name +"" +  role );
                 JOptionPane.showMessageDialog(null, "Welcome "+name);
                 
                 if(role.equals("Admin") && counter ==1){
                     //Re-direct to Admin operations and Dashboard
                     switchWindowAdmin();
                     btnLogin.getScene().getWindow().hide();
                 }else{
                     //Re-direct to operations by staff
                     switchWindowStaff();
                     btnLogin.getScene().getWindow().hide();
                 }
                 
                }
//                String Sessionname =rs.getString("s_fname" + "" + "s_lname");
//                System.out.println(name);
                 
        } catch (HeadlessException | SQLException e) {
                    e.getMessage();
        }
    }
    
 
 
        public void switchWindowAdmin() throws IOException
    {
    FXMLLoader loader= new FXMLLoader(getClass().getResource(Constants.MAINVIEW));
    Parent root=loader.load();
    
    
    MainViewController dbController=loader.getController();
    //dbController.getUserID(Sessionname);

//        Parent root = FXMLLoader.load(getClass().getResource(Constants.MAINVIEW));  //Constants.MAINVIEW
//        
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//        stage.show();

    Stage stage = new Stage();
    stage.setScene(new Scene(root));
    stage.setTitle("DashBoard");
    stage.show();
    }
        
                public void switchWindowStaff() throws IOException
    {
    FXMLLoader loader= new FXMLLoader(getClass().getResource("StaffOps/StaffAcctOps.fxml"));
    Parent root=loader.load();
    StaffAcctOpsController staffAcctOpsController=loader.getController();
//    dashboardController.getUserID(UserLabel.getText());

    Stage stage = new Stage();
    stage.setScene(new Scene(root));
    stage.setTitle("Staff DashBoard");
    stage.show();
    }
    
}
