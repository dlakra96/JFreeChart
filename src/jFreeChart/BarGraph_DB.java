package jFreeChart;
import java.io.*;
import java.sql.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarGraph_DB {
public static void main(String[] args) throws Exception
{
Class.forName("com.mysql.jdbc.Driver");
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","lakra96","Guruji@1177");
Statement statement = connection.createStatement();
ResultSet resultset=statement.executeQuery("select * from stu_details");
DefaultCategoryDataset dataset = new DefaultCategoryDataset();
while(resultset.next())
{
String student_id=resultset.getString("stu_id");
Float student_per=resultset.getFloat("stu_per");
dataset.setValue(student_per,student_id,student_id);
}
JFreeChart chart = ChartFactory.createBarChart("Student Percentage", "Student-ID", "Percentage", dataset, PlotOrientation.VERTICAL, false, true, false);
int width=560;
int height=370;
File barGraph= new File("Bar_Graph.jpeg");
ChartUtilities.saveChartAsJPEG(barGraph,chart,width,height);
System.out.println("GoodBye");}
}
