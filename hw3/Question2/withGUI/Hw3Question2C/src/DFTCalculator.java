
public class DFTCalculator implements Runnable{
	/**
	 * it has operations like sum of two complex numbers
	 */
	
	ComplexNumberSquareMatrix mainMatrix;

	ComplexNumberSquareMatrix dftMatrix;

	
	public DFTCalculator(ComplexNumberSquareMatrix mainMatrix) {		
		this.mainMatrix=mainMatrix;

	}
	
	
	/**
	 * calculates dft of the main matrix
	 */
	public void dft() {
		ComplexNumber[][] matrix = new ComplexNumber[mainMatrix.getXSize()][mainMatrix.getYSize()];
		for (int i = 0; i < mainMatrix.getXSize(); i++) {
			for (int j = 0; j < mainMatrix.getYSize(); j++) {
				ComplexNumber complexNumber = dftOfOneCell(mainMatrix,i, j);
				matrix[i][j]=complexNumber;
			}
		}
		dftMatrix =  new ComplexNumberSquareMatrix(matrix);
	}
	
	
	
	/**
	 * dft of one given cell of given matrix
	 * @param matrix
	 * @param x
	 * @param y
	 * @return
	 */
	public ComplexNumber dftOfOneCell(ComplexNumberSquareMatrix matrix,int x,int y) {
		ComplexNumber result = new ComplexNumber(0,0);
		ComplexNumberCalculator complexNumberCalculator = new ComplexNumberCalculator();
		
		for (int i = 0; i < matrix.getXSize(); i++) {
			for (int j = 0; j < matrix.getYSize(); j++) {
				
				ComplexNumber left = complexNumberCalculator.multiply(matrix.get(i,j),
						(Math.cos(2*Math.PI*((x*i+y*j)/matrix.getXSize()))));
				
				ComplexNumber rightPrepare = complexNumberCalculator.multiply(matrix.get(i,j),
						new ComplexNumber(0,-1));

				ComplexNumber right= complexNumberCalculator.multiply(rightPrepare,(Math.sin(2*Math.PI*((x*i+y*j)/matrix.getXSize()))) );

				ComplexNumber complexVal= complexNumberCalculator.sum(left, right);


				result = complexNumberCalculator.sum(result,complexVal);



			}
		}
		
		
		return result;
	}
	
	public ComplexNumberSquareMatrix getDftMatrix() {
		return dftMatrix;
	}

	@Override
	public void run() {
		dft();
	}
}
