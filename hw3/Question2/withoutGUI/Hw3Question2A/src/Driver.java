
public class Driver {
	
	public static void main(String[] args) {
		
		ComplexNumberSquareMatrix matrixA = new ComplexNumberSquareMatrix(4);
		matrixA.fillRandomly();	

		
		ComplexNumberSquareMatrix matrixB = new ComplexNumberSquareMatrix(128);
		matrixB.fillRandomly();	
		
		
		MainCalculator mainCalculator = new MainCalculator(matrixA, matrixB, 4);
		System.out.println("Calculation...");

		mainCalculator.calculate();
		System.out.println("RESULT\n"+mainCalculator.getDftResult()+"\n");

		

		
		
		
		
	}

}
