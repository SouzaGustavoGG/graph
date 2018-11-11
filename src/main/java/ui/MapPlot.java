/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author geevb
 */
public class MapPlot extends JFrame {
    
    private static final long serialVersionUID = 6294689542092367723L;

  public MapPlot(String title, XYDataset dataset) {
    super(title);

    // Create chart
    JFreeChart chart = ChartFactory.createScatterPlot(
        "Boys VS Girls weight comparison chart", 
        "X-Axis", "Y-Axis", dataset);

    
    //Changes background color
    XYPlot plot = (XYPlot)chart.getPlot();
    plot.setBackgroundPaint(new Color(255,228,196));
    
   
    // Create Panel
    ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);
    this.setSize(800, 400);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

//  public static void main(String[] args) {
//    SwingUtilities.invokeLater(() -> {
//      MapPlot example = new MapPlot("Scatter Chart Example | BORAJI.COM");
//      example.setSize(800, 400);
//      example.setLocationRelativeTo(null);
//      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//      example.setVisible(true);
//    });
//  }
}
