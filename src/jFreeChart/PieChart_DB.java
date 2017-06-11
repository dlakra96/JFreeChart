package jFreeChart;
import java.io.*;
import java.sql.*;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
public class PieChart_DB {
public static void main(String[] args) throws Exception
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","lakra96","Guruji@1177");
Statement statement = connection.createStatement();
ResultSet resultset=statement.executeQuery("select * from stu_details");
DefaultPieDataset dataset=new DefaultPieDataset();



while(resultset.next())
{
dataset.setValue(resultset.getString("stu_id"), resultset.getFloat("stu_per"));
}
JFreeChart chart = ChartFactory.createPieChart("Student Percentage",dataset,true,true,false);
int width=560;
int height=370;
File pieChart= new File("Pie_Chart.jpeg");
ChartUtilities.saveChartAsJPEG(pieChart,chart,width,height);
System.out.println("GoodBye");
}
}
