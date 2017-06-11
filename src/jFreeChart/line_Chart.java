package jFreeChart;
import java.io.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;
public class line_Chart {
public static void main(String args[]) throws Exception
{
	String query="select * from stu_details";
	JDBCCategoryDataset dataset = new JDBCCategoryDataset(
			"jdbc:mysql://localhost:3306/student", "com.mysql.jdbc.Driver",
			"lakra96", "Guruji@1177");
	dataset.executeQuery(query);
	JFreeChart chart = ChartFactory.createLineChart("Student Percentage", "Student-ID", "Percentage", dataset, PlotOrientation.VERTICAL, true, true, false);
	int width=560;
	int height=370;
	File lineChart= new File("Line_Chart.jpeg");
	ChartUtilities.saveChartAsJPEG(lineChart,chart,width,height);
	System.out.println("GoodBye");}

}

