/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Index.LogSController;

import StaffOps.StaffAcctOpsController;
//import <default package>.LogSController;
import Utils.Constants;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ferdinand
 */
public class SideMenuViewController implements Initializable {

    @FXML
    private JFXButton btnDashboard;
    @FXML
    private JFXButton btnLogout;
    @FXML
    private JFXButton btnExit;
    @FXML
    private JFXButton btnStaff;
    @FXML
    private JFXButton btnManageAccts;
    @FXML
    private JFXButton btnAcctOps;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
              try {
                StackPane dashboard = FXMLLoader.load(getClass().getResource(Constants.DASHBOARDVIEW));
                MainViewController.temporaryPane.getChildren().setAll(dashboard);
        } catch (Exception e) {
        }
                

    }    

    @FXML
    private void OpenDashboard(ActionEvent event) {
         switchPane(Constants.DASHBOARDVIEW );
    }

//    private void OpenPatients(ActionEvent event) {
//        switchPane(Constants.STAFFVIEW );
//    }

//    private void OpenDoctors(ActionEvent event) {
//        switchPane(Constants.DOCTORSVIEW);
//    }
//
//    private void OpenAppointments(ActionEvent event) {
//        switchPane(Constants.APPOINTMENTS);
//    }

//    private void OpenCarriers(ActionEvent event) {
//         switchPane(Constants.CARRIERSVIEW);
//    }
//
//    private void OpenInvoice(ActionEvent event) {
//        switchPane(Constants.INVOICEVIEW);
//    }

    @FXML
    private void OpenLogout(ActionEvent event) throws IOException {
        try {
            Stage window=(Stage) btnLogout.getScene().getWindow();
//            Main bankFX=new Main();    //the error thrown here is as a result of all view not located in the same package with the Main class
//            bankFX.start(new Stage());


            window.close();
        } catch (Exception ex) {
            Logger.getLogger(SideMenuViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
    }
    
    
    private void switchPane(String pane){
        try {
            
        MainViewController.temporaryPane.getChildren().clear();
        StackPane pane2 = FXMLLoader.load(getClass().getResource(pane));
        ObservableList<Node> elements=pane2.getChildren();
        MainViewController.temporaryPane.getChildren().setAll(elements);
            
        } catch (Exception e) {
        }   
    }

    @FXML
    private void OpenStaff(ActionEvent event) {
        switchPane(Constants.STAFFVIEW );
    }

    @FXML
    private void OpenManageAccts(ActionEvent event) {
        switchPane(Constants.ACCTSVIEW);
    }

    @FXML
    private void OpenAcctOps(ActionEvent event) {
        switchPane(Constants.ACCTOPS);
    }
    
    
     public void switchToLogin() throws IOException
    {
    FXMLLoader loader= new FXMLLoader(getClass().getResource("Index/LogS.fxml"));
    Parent root=loader.load();
    
    
    LogSController logController=loader.getController();
    //dbController.getUserID(Sessionname);

//        Parent root = FXMLLoader.load(getClass().getResource(Constants.MAINVIEW));  //Constants.MAINVIEW
//        
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//        stage.show();

    Stage stage = new Stage();
    stage.setScene(new Scene(root));
    stage.setTitle("index");
    stage.show();
    }
        
  
    
}
