
public class ComplexNumberSquareMatrixAdder implements Runnable {

	/**
	 * it has operations like sum of two complex numbers
	 */
	ComplexNumberCalculator complexNumberCalculator = new ComplexNumberCalculator();
	
	/**
	 * represents matrixA
	 */
	ComplexNumberSquareMatrix matrixA;
	
	/**
	 * represents matrixB
	 */
	ComplexNumberSquareMatrix matrixB;
	
	/**
	 * represents sum of A+B
	 */
	ComplexNumberSquareMatrix sumMatrix;

	
	public ComplexNumberSquareMatrixAdder(ComplexNumberSquareMatrix matrixA,ComplexNumberSquareMatrix matrixB) {
		
		this.matrixA=matrixA;
		this.matrixB=matrixB;
	}
	
	
	/**
	 * Returns sum of two ComplexNumberSquareMatrix object
	 */
	public void calculateSum() {
		ComplexNumber[][] matrix = new ComplexNumber[matrixA.getXSize()][matrixA.getYSize()];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j]=complexNumberCalculator.sum(matrixA.get(i, j),matrixB.get(i, j));
			}
		}
		this.sumMatrix=new ComplexNumberSquareMatrix(matrix);
	}
	
	public ComplexNumberSquareMatrix getSumMatrix() {
		return sumMatrix;
	}

	@Override
	public void run() {
		calculateSum();
	}

}
