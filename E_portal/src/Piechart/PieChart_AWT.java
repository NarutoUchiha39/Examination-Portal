package Piechart;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
public class PieChart_AWT extends JFrame
{
   public static Double score1;
   public static Double Score2;
   
   public PieChart_AWT(String title) {
      super( title ); 
      setContentPane(createDemoPanel( ));
   }
   
   private static PieDataset createDataset() 
   {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "OOPS" ,score1) ;  
      dataset.setValue( "Data Structures",Score2);   
      return dataset;         
   }
   
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Performance Review",   
         dataset,              
         true,                
         true, 
         false);

      return chart;
   }
   
   public static JPanel createDemoPanel( ) {
      JFreeChart chart = createChart(createDataset() );  
      return new ChartPanel( chart ); 
   }

   public static void start()
   {
      PieChart_AWT frame = new PieChart_AWT( "Performance Review" );  
      frame. setExtendedState(JFrame. MAXIMIZED_BOTH);    
      RefineryUtilities.centerFrameOnScreen(frame);    
      frame.setVisible( true ); 
   }
}