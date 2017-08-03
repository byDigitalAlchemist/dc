package org.dc.common.chart;

import java.awt.BasicStroke;
import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class KnnChart extends ApplicationFrame {

	   public KnnChart( String applicationTitle, String chartTitle ) {
		   super(applicationTitle);
	      JFreeChart xylineChart = ChartFactory.createXYLineChart(
	         chartTitle ,
	         "Category" ,
	         "Score" ,
	         createDataset() ,
	         PlotOrientation.VERTICAL ,
	         true , true , false);
	         
	      ChartPanel chartPanel = new ChartPanel( xylineChart );
	      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	      final XYPlot plot = xylineChart.getXYPlot( );
	      
	      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
	      renderer.setSeriesPaint( 0 , Color.RED );
	      renderer.setSeriesPaint( 1 , Color.GREEN );
	      renderer.setSeriesPaint( 2 , Color.YELLOW );
	      renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
	      renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
	      renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
	      plot.setRenderer( renderer ); 
	      setContentPane( chartPanel ); 
	   }
	   
	   /**
	    *	{ 0.35, 0.91, 0.86, 0.42, 0.71 }, 
			{ 0.21, 0.12, 0.76, 0.22, 0.92 },
			{ 0.41, 0.58, 0.73, 0.21, 0.09 }, 
			
			{ 0.71, 0.34, 0.55, 0.19, 0.80 }, 
			{ 0.79, 0.45, 0.79, 0.21, 0.44 }, 
			{ 0.61, 0.37, 0.34, 0.81, 0.42 }, 
			
			{ 0.78, 0.12, 0.31, 0.83, 0.87 }, 
			{ 0.52, 0.23, 0.73, 0.45, 0.78 },
			{ 0.53, 0.17, 0.63, 0.29, 0.72 }, 
	    * 
	    */
	   private XYDataset createDataset( ) {
	      final XYSeries london = new XYSeries( "LONDON" );          
	      london.add( 0.35 , 0.91 );          
	      london.add( .71 , .34 );          
	      london.add( .78 , .12 );          
	      
	      final XYSeries leeds = new XYSeries( "LEEDS" );          
	      leeds.add( .21 , .12 );          
	      leeds.add( .79 , .45 );          
	      leeds.add( .52 , .23 );          
	      
	      final XYSeries liverpool = new XYSeries( "LIVERPOOL" );          
	      liverpool.add( .41 , .58 );          
	      liverpool.add( .61 , .37 );          
	      liverpool.add( .53 , .17 );
	      
	      
	      final XYSeries unknown = new XYSeries( "UNKNOWN" );          
	      unknown.add( .65 , .78 );          
	      
	      final XYSeriesCollection dataset = new XYSeriesCollection( );          
	      dataset.addSeries( london );          
	      dataset.addSeries( leeds );          
	      dataset.addSeries( liverpool );
	      dataset.addSeries( unknown );
	      return dataset;
	   }

	   public static void main( String[ ] args ) {
	      KnnChart chart = new KnnChart("Browser Usage Statistics","Which Browser are you using?");
	      chart.pack( );          
	      RefineryUtilities.centerFrameOnScreen( chart );          
	      chart.setVisible( true ); 
	   }
	}
