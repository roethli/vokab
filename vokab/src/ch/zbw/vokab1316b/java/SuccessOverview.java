package ch.zbw.vokab1316b.java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A simple demonstration application showing how to create a 3D bar chart.
 *
 */
public class SuccessOverview extends ApplicationFrame {

	/**
	 * Creates a new demo instance.
	 *
	 * @param title
	 *            the frame title.
	 */
	public SuccessOverview(final String title) {

		super(title);

		final CategoryDataset dataset = createDataset();
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(600, 270));
		setContentPane(chartPanel);
	}

	/**
	 * Returns a sample dataset.
	 * 
	 * @return The dataset.
	 */
	private CategoryDataset createDataset() {
		// Add Cards and set counters for Testing the Chart --- JUST FOR TESTING!!!!!!!!
		
		VokabLogic testkarten = new VokabLogic();
		testkarten.addCard("Hallo", "hello", 1);
		testkarten.addCard("Nein", "no", 1);
		testkarten.showNextCard("Hallo");
		testkarten.setSuccesscounter();
		testkarten.setFaultcounter();

		
		// row keys...
		final String series1 = "Richtig";
		final String series2 = "Falsch";

		// column keys...
		final String category1 = "Anz. Richtig";
		final String category2 = "Anz. Falsch";

		// create the dataset...
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		int testcounter_success = testkarten.getSuccesscounter(); //variables to fill up the bar 1
		int testcounter_faults = testkarten.getFaultcounter(); //variables to fill up the bar 2
		dataset.addValue(testcounter_success, series1, category1); //Add value to chart 1
		dataset.addValue(testcounter_faults, series2, category2); //Add value to chart 2
		return dataset;
	}

	/**
	 * Creates a sample chart.
	 * 
	 * @param dataset
	 *            the dataset.
	 * 
	 * @return The chart.
	 */
	private JFreeChart createChart(final CategoryDataset dataset) {

		final JFreeChart chart = ChartFactory.createBarChart3D("Erfolgsübersicht", "Anzahl", "", dataset,PlotOrientation.HORIZONTAL, true, false, false);
		// create the chart...

		// NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

		// set the background color for the chart...
		chart.setBackgroundPaint(Color.white);

		// get a reference to the plot for further customisation...
		final CategoryPlot plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(Color.white);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
		
		// set the range axis to display integers only...
		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		// disable bar outlines...
		final BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setDrawBarOutline(false);

		// set up gradient paints for series...
		final GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, Color.green,
				0.0f, 0.0f, Color.lightGray);
		final GradientPaint gp1 = new GradientPaint(

		0.0f, 0.0f, Color.red, 0.0f, 0.0f, Color.lightGray);

		renderer.setSeriesPaint(0, gp0);
		renderer.setSeriesPaint(1, gp1);
		
		final CategoryAxis domainAxis = plot.getDomainAxis();
		
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions
				.createUpRotationLabelPositions(Math.PI / 5.0));
		// OPTIONAL CUSTOMISATION COMPLETED.

		return chart;

		
	}

	/**
	 * Starting point for the demonstration application.
	 *
	 * @param args
	 *            ignored.
	 */
	public static void main(final String[] args) {

		final SuccessOverview overview = new SuccessOverview(
				"Vocab - Erfolgsübersicht");
		overview.pack();
		RefineryUtilities.centerFrameOnScreen(overview);
		overview.setVisible(true);

	}

}
