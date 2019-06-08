/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Ferdinand
 */
public class DonutChart extends PieChart{
    private final Circle innerCircle;
    
    public DonutChart(ObservableList<PieChart.Data>pieData){
        super(pieData);
        
        innerCircle = new Circle();
        
        //Just styled in code for demo purposes, style with css instead.
        innerCircle.setFill(Color.WHITESMOKE);
        innerCircle.setStroke(Color.WHITE);
        innerCircle.setStrokeWidth(3);
    }
    
}