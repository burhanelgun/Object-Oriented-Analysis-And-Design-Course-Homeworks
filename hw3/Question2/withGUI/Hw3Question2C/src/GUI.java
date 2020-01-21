import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.text.Document;

public class GUI {

	public void start() {
		JFrame f=new JFrame();
		final MainCalculator mainCalculator = new MainCalculator();
		final JLabel sizeLabel = new JLabel();          
		sizeLabel.setSize(400,100);
		sizeLabel.setBounds(30,15,250, 50);
		sizeLabel.setText("Select Size Of The Matrix");
	    
	    
		final JLabel threadCountLabel = new JLabel();          
		threadCountLabel.setSize(400,100);
		threadCountLabel.setBounds(240,15,250, 50);
		threadCountLabel.setText("Select Thread Count");
	    
		
	    Integer[] sizes = { 2,4,8,16,32,64,128,256,512,1024,2048,4096,8192};
	    final JComboBox<Integer> sizesCb = new JComboBox<Integer>(sizes);
	    sizesCb.setBounds(50, 50,90,20);
	    sizesCb.setVisible(true);
		f.add(sizesCb);
		
	    Integer[] threadCounts = { 2,4,8};
	    final JComboBox<Integer> threadCountsSizesCb = new JComboBox<Integer>(threadCounts);
	    threadCountsSizesCb.setBounds(250, 50,90,20);
	    threadCountsSizesCb.setVisible(true);
		f.add(threadCountsSizesCb);

		final JTextArea jt = new JTextArea(10,10); 
		jt.setBounds(400,15,1050, 700);
		f.add(jt);

		JButton calculate=new JButton("Calculate");
		calculate.setBounds(130,100,100, 40); 
		calculate.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {

		  
				  
				   SwingWorker<Document, Void> worker = new SwingWorker<Document, Void>() {
					     @Override
					     public Document doInBackground() {
					    	 int size = sizesCb.getItemAt(sizesCb.getSelectedIndex()); 
			            	int threadCount = threadCountsSizesCb.getItemAt(threadCountsSizesCb.getSelectedIndex());
			        		ComplexNumberSquareMatrix matrixA = new ComplexNumberSquareMatrix(size);
			        		matrixA.fillRandomly();	
			        		ComplexNumberSquareMatrix matrixB = new ComplexNumberSquareMatrix(size);
			        		matrixB.fillRandomly();	
			        		mainCalculator.setMatrixA(matrixA);
			        		mainCalculator.setMatrixB(matrixB);
			        		mainCalculator.setThreadCount(threadCount);
			        		mainCalculator.calculate();
			        		jt.setText(mainCalculator.getDftResult().toString());
					       return null;
					     }
					     @Override
					     public void done() {
					      
					     }
					   };

					   worker.execute();
				  
				  
				  }
				});
		          
		f.add(calculate);
		
		
		
		
		JButton stop=new JButton("Stop");
		stop.setBounds(130,700,100, 40); 
		stop.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {

				  
				   SwingWorker<Document, Void> worker = new SwingWorker<Document, Void>() {
					     @Override
					     public Document doInBackground() {
					    	 mainCalculator.stop();
					       return null;
					     }
					     @Override
					     public void done() {
					      
					     }
					   };

					   worker.execute();
			  }
			});
		          
		f.add(stop);
		
		
		
		JButton restart=new JButton("Restart");
		restart.setBounds(130,650,100, 40); 
		restart.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {

				   SwingWorker<Document, Void> worker = new SwingWorker<Document, Void>() {
					     @Override
					     public Document doInBackground() {
					    	 mainCalculator.restart();
					       return null;
					     }
					     @Override
					     public void done() {
					      
					     }
					   };

					   worker.execute();
			  }
			});
		          
		f.add(restart);
		
		
		
		
		f.add(sizeLabel);
		f.add(threadCountLabel);
    
		f.setSize(1500,800);
		f.setLayout(null); 
		f.setVisible(true); 		
	}
	
}
