import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;

/**
 * This class represent the user interface screen
 * @author Burhan ELGUN
 *
 */
public class Screen  implements ActionListener{
	
    /**
     * Dynamic plot for version1
     */
    DynamicPlot version1;
    
    /**
     * Dynamic plot for version2
     */
    DynamicPlot version2;
    
    /**
     * Dynamic plot for version3
     */
    DynamicPlot version3;
    
    /**
     * Run button
     */
    JButton runButton;
    
    /**
     * Pause button
     */
    JButton pauseButton;
    
    /**
     * Stop button
     */
    JButton stopButton;
    
    /**
     * Thread1 for version1
     */
    Thread thread1;
    
    /**
     * Thread2 for version2
     */
    Thread thread2;
    
    /**
     * Thread3 for version3
     */
    Thread thread3;
    
    /**
     * JFrame for all three plots and three buttons
     */
	JFrame frame = new JFrame();


    /**
     * Creates objects and makes some adjustment about the screen and plots
     */
    public Screen() {
	 version1 = new DynamicPlot("Generic Algorithm", "Version1", new Version1GA());
	 version2 = new DynamicPlot("Generic Algorithm", "Version2", new Version2GA());
	 version3 = new DynamicPlot("Generic Algorithm", "Version3", new Version3GA());

	thread1=new Thread(version1);
	thread2=new Thread(version2);
	thread3=new Thread(version3);
			
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);  

	frame.setLayout(new GridLayout(2, 3));
	
    	
    	
    	runButton = new JButton("Run");
    	runButton.setActionCommand("Run");
    	runButton.addActionListener(this);

		
    	pauseButton = new JButton("Pause");
    	pauseButton.setActionCommand("Pause");
    	pauseButton.addActionListener(this);

		
    	stopButton = new JButton("Stop");
    	stopButton.setActionCommand("Stop");
    	stopButton.addActionListener(this);

    	
    	
    	frame.getContentPane().add(new ChartPanel(version1.xylineChart));

    	frame.getContentPane().add(new ChartPanel(version2.xylineChart));
    	
    	frame.getContentPane().add(new ChartPanel(version3.xylineChart));
    	
    	frame.add(runButton, BorderLayout.SOUTH);
    	frame.add(pauseButton, BorderLayout.SOUTH);
    	frame.add(stopButton, BorderLayout.SOUTH);

    	frame.pack();

    	frame.setVisible(true);
    }

    /**
     * it is called when button is clicked
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Run")) {
			if(!thread1.isAlive() && ((GeneticAlgorithm)version1.geneticAlgorithm).isStopped==false) {
				thread1.start();
				thread2.start();
				thread3.start();
			}
			else if(!thread1.isAlive() && ((GeneticAlgorithm)version1.geneticAlgorithm).isStopped==true) {
		    	version1.dataset.clear();
		    	version2.dataset.clear();
		    	version3.dataset.clear();

				thread1=new Thread(version1);
		    	thread2=new Thread(version2);
		    	thread3=new Thread(version3);
		    	
				version1.setGeneticAlgorithm(new Version1GA());
				version2.setGeneticAlgorithm(new Version2GA());
				version3.setGeneticAlgorithm(new Version3GA());

		
				thread1.start();
				thread2.start();
				thread3.start();
				
			}
			else {
				version1.start();
				version2.start();
				version3.start();
			}

		}	
		if (e.getActionCommand().equals("Pause")) {
			version1.pause();
			version2.pause();
			version3.pause();

		}	
		
		if (e.getActionCommand().equals("Stop")) {
			version1.stop();
			version2.stop();
			version3.stop();

		}	
	
	}
    
    

}
