package ch.zbw.vokab1316b.java;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class SuccessOverviewPie {
private VokabLogic cards;
 /**
   * @param args
   */
  public static void main(String[] args) {
    VokabLogic cards = new VokabLogic();
    cards.setSuccesscounter(12);
    cards.setFaultcounter(4);
	 int testcounter_success = cards.getSuccesscounter(); //variables to fill up the bar 1
	int testcounter_faults = cards.getFaultcounter(); //variables to fill up the bar 2
	  
    //Prepare the data set
    DefaultPieDataset pieDataset = new DefaultPieDataset();
    
    pieDataset.setValue("Falsch="+testcounter_faults, testcounter_faults);
    
    pieDataset.setValue("Richtig="+testcounter_success, testcounter_success);
    
    
    //Create the chart
    JFreeChart chart = ChartFactory.createPieChart3D(
        "Erfolgsübersicht", pieDataset, true, true, true);
    
    //Render the frame
    ChartFrame chartFrame = new ChartFrame("Erfolgsübersicht", chart);
    chartFrame.setTitle("Erfolgsübersicht");
    chartFrame.setVisible(true);
    chartFrame.setSize(600, 400);
  }

} 