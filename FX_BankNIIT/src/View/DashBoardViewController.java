 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Bean.DBHandler;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Ferdinand
 */
public class DashBoardViewController implements Initializable {

    @FXML
    private AnchorPane donutChartHolder;
    @FXML
    private PieChart pieChart;
    @FXML
    private BarChart<String, Integer> barChart;
    
        DBHandler connect = new DBHandler();
    public PreparedStatement pstmt = null;
    public Statement st = null;
    public ResultSet rs = null;

    private Connection con;

    ObservableList<PieChart.Data> pieChartdata;
    ArrayList<Integer> cell = new ArrayList<Integer>();
    ArrayList<String> country = new ArrayList<String>();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        initPieChart();
        loadChart();
        loadPieChart();
        pieChart.setData(pieChartdata);
    }    
    
    private void initPieChart(){
        
//        ObservableList<PieChart.Data> data = FXCollections.observableArrayList(
//                new PieChart.Data("Prosthesis", 20d),
//                new PieChart.Data("Extraction", 40d),
//                new PieChart.Data("Refilling", 25d),
//                new PieChart.Data("Carriers", 15d)
//        );
//                pieChart.setData(data);
    }
    
    
    public void loadChart(){
        String sql ="select a_dob, a_acctBal from accounts ORDER BY a_dob asc";
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        
        try {
            //get Connection
            con=connect.DBconnection();
            
            rs=con.createStatement().executeQuery(sql);
            while(rs.next()){
                series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
            }
            barChart.getData().add(series);
            
            
            
        } catch (Exception e) {
        }
        
    
    }
    
        public void loadPieChart(){
        String sql ="select * from accounts";
//        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        
            pieChartdata=FXCollections.observableArrayList();
        try {
            //get Connection
            con=connect.DBconnection();
            
            rs=con.createStatement().executeQuery(sql);
            while(rs.next()){
                pieChartdata.add(new PieChart.Data(rs.getString("a_national"), rs.getInt("Acct_id")));
                country.add(rs.getString("a_national"));
                cell.add(rs.getInt("Acct_id"));
            }
//            barChart.getData().add(series);
            
            
            
        } catch (Exception e) {
        }
        
    
    }
    
    
}
