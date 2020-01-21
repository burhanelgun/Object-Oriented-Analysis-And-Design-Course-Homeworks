
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
    boolean isStopped; 

	
	public ComplexNumberSquareMatrixAdder(ComplexNumberSquareMatrix matrixA,ComplexNumberSquareMatrix matrixB) {
		//System.out.println(matrixA+"\n+\n"+matrixB+"\n\n");
		isStopped=false;
		this.matrixA=matrixA;
		this.matrixB=matrixB;
	}
	
	
	/**
	 * Returns sum of two ComplexNumberSquareMatrix object
	 */
	public void calculateSum() {
	
			ComplexNumber[][] matrix = new ComplexNumber[matrixA.getXSize()][matrixA.getYSize()];
			for (int i = 0; i < matrix.length; i++) {
				while(!isStopped) {
					for (int j = 0; j < matrix[i].length; j++) {
						matrix[i][j]=complexNumberCalculator.sum(matrixA.get(i, j),matrixB.get(i, j));
					}
					break;
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
	
    public void stop() 
    { 
        isStopped = true; 
    } 

}
