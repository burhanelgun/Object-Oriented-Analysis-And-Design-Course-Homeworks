import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.text.Document;

public class Driver {

	public static void main(String[] args) {


		GUI gui =new GUI();
		gui.start();
		
		
		/*
		
		ComplexNumberSquareMatrix matrixA = new ComplexNumberSquareMatrix(1024);
		matrixA.fillRandomly();	
		System.out.println(matrixA);
		System.out.println("*******************************************************");	

		
		ComplexNumberSquareMatrix matrixB = new ComplexNumberSquareMatrix(1024);
		matrixB.fillRandomly();	
		System.out.println(matrixB+"\n");	
		System.out.println("*******************************************************\n");
		
		
		MainCalculator mainCalculator = new MainCalculator(matrixA, matrixB, 2);
		System.out.println();
		System.out.println("*******************************************************\n");
		mainCalculator.calculate();
		System.out.println();
		System.out.println(mainCalculator.getDftResult()+"\n");
		*/
	}

}
