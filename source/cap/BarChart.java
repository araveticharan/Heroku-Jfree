package cap;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.encoders.EncoderUtil;
import org.jfree.chart.encoders.ImageFormat;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart {

   public static void main(String[] args) throws Exception {
      final String fiat = "FIAT";
      final String audi = "AUDI";
      final String ford = "FORD";
      final String speed = "Speed";
      final String millage = "Millage";
      final String userrating = "User Rating";
      final String safety = "safety";

      final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
      
      dataset.addValue( 1.0 , fiat , speed ); 
      dataset.addValue( 3.0 , fiat , userrating ); 
      dataset.addValue( 5.0 , fiat , millage ); 
      dataset.addValue( 5.0 , fiat , safety );

      dataset.addValue( 5.0 , audi , speed ); 
      dataset.addValue( 6.0 , audi , userrating ); 
      dataset.addValue(10.0 , audi , millage ); 
      dataset.addValue( 4.0 , audi , safety );

      dataset.addValue( 4.0 , ford , speed ); 
      dataset.addValue( 2.0 , ford , userrating ); 
      dataset.addValue( 3.0 , ford , millage ); 
      dataset.addValue( 6.0 , ford , safety );
             
      
      JFreeChart barChart = ChartFactory.createBarChart( "CAR USAGE STATIStICS", 
                                                         "Category", 
                                                         "Score",
                                                         dataset,
                                                         PlotOrientation.VERTICAL, 
                                                         true, true, false);

      
      int width   = 640; /* Width of the image */
      int height  = 480; /* Height of the image */      
      
      byte[] bytes               = EncoderUtil.encode(barChart.createBufferedImage(width, height), ImageFormat.PNG);
      String base64EncodedImage  = Base64.getEncoder().encodeToString(bytes);
      
      System.out.println(base64EncodedImage);
      
   }

   

}