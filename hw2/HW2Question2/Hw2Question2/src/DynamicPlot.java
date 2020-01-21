

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * It represent a plot
 * @author Burhan ELGUN
 *
 */
public class DynamicPlot extends JPanel implements Runnable,Observer {
	
	/**
	 * It represent the plot dataset
	 */
	DefaultCategoryDataset  dataset = new DefaultCategoryDataset ( );       
	
	/**
	 * It represent the plot
	 */
	 JFreeChart  xylineChart;
	 
	 /**
	  * it represent the subject
	  */
	 Subject geneticAlgorithm;

/**
 * 
 * @param screenTitle title of the screen
 * @param chartTitle title of the plot
 * @param geneticAlgorithm algorithm type to make plotting
 */
	  public DynamicPlot( String screenTitle, String chartTitle,Subject geneticAlgorithm ) {
		  
		  
	     this.geneticAlgorithm=geneticAlgorithm;
	     geneticAlgorithm.registerObserver(this);
		 xylineChart = ChartFactory.createLineChart(
	         chartTitle ,
	         "Iteration" ,
	         "Fitness" ,
	         dataset ,
	         PlotOrientation.VERTICAL ,
	         true , true , false);
	         
	      ChartPanel chartPanel = new ChartPanel( xylineChart );
	      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );

	      CategoryPlot plot = (CategoryPlot) xylineChart.getPlot();
	      plot.getDomainAxis().setCategoryLabelPositions(
	    		    CategoryLabelPositions.UP_45);
	    		plot.setDomainGridlinesVisible(true);
	    		plot.setRangeGridlinesVisible(false);
	      
	               
	      setVisible( true );
	   }


	  /**
	   * updates the chart
	   */
	@Override
	public void update(double fitnessValue, String versionType, String iteration) {
		dataset.addValue(fitnessValue,versionType,iteration);	
		xylineChart.setTitle("Fitness Value:"+fitnessValue+" Iteration:"+iteration);
	}
	   
	
	/**
	*runs the runnable DynamicPlot
	 */
    @Override
    public void run() {

    	try {
	    	((GeneticAlgorithm)geneticAlgorithm).isStopped=false;		

			((GeneticAlgorithm)geneticAlgorithm).start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

    /**
     * stops the algorithm and plotting
     */
    public void stop() {
    	((GeneticAlgorithm)geneticAlgorithm).isStopped = true;
    	((GeneticAlgorithm)geneticAlgorithm).isPaused =false;
	     geneticAlgorithm.removeObserver(this);

    }
    
    /**
     * pauses the algorithm and plotting
     */
    public void pause() {
    	((GeneticAlgorithm)geneticAlgorithm).isPaused = true;
    }
	
    /**
     * starts the algorithm and plotting
     */
    public void start() {
    	if(((GeneticAlgorithm)geneticAlgorithm).isStopped==true) {
        	((GeneticAlgorithm)geneticAlgorithm).isStopped = false;
        	try {
				((GeneticAlgorithm)geneticAlgorithm).start();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	
    	}
    	else if(((GeneticAlgorithm)geneticAlgorithm).isPaused) {
        	//resume
    		((GeneticAlgorithm)geneticAlgorithm).isPaused=false;
    	}
    }
	
    /**
     * sets the GeneticAlgorithm type
     * @param geneticAlgorithm generic algorithm to set
     */
    public void setGeneticAlgorithm(Subject geneticAlgorithm) {
		this.geneticAlgorithm = geneticAlgorithm;
	     geneticAlgorithm.registerObserver(this);

	}
	   

}  