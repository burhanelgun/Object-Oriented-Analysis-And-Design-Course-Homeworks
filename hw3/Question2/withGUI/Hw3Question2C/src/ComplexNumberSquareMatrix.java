
public class ComplexNumberSquareMatrix{
	
	private int xSize;
	private int ySize;
	private ComplexNumber[][] matrix;
	
	/**
	 * Creates a complex number square matrix with given size and fill it with random complex numbers
	 * @param size size of the matrix
	 */
	public ComplexNumberSquareMatrix(int size) {
		this.xSize=size;
		this.ySize=size;
		matrix = new ComplexNumber[size][size];
	}
	
	/**
	 * Create a ComplexNumberMatrix with a ComplexNumberMatrix 2d array 
	 * @param matrices
	 * @param dividerCount
	 */
	public ComplexNumberSquareMatrix(ComplexNumberSquareMatrix[][] matrices,int dividerCount) {

		if(dividerCount==2) {
			this.xSize=matrices[0][0].xSize*2;
			this.ySize=matrices[0][0].ySize*1;
			matrix = new ComplexNumber[matrices[0][0].xSize*2][matrices[0][0].ySize*1];
		}
		else if(dividerCount==4) {
			this.xSize=matrices[0][0].xSize*2;
			this.ySize=matrices[0][0].ySize*2;
			matrix = new ComplexNumber[matrices[0][0].xSize*2][matrices[0][0].ySize*2];
		}
		else if(dividerCount==8) {
			this.xSize=matrices[0][0].xSize*4;
			this.ySize=matrices[0][0].ySize*2;
			matrix = new ComplexNumber[matrices[0][0].xSize*4][matrices[0][0].ySize*2];
		}


		for (int i = 0; i < matrices.length; i++) {
			for (int j = 0; j < matrices[i].length; j++) {
				for (int k = 0; k < matrices[i][j].xSize; k++) {
					for (int m = 0; m < matrices[i][j].ySize; m++) {
						matrix[(i*matrices[i][j].xSize)+k][(j*matrices[i][j].ySize)+m]=matrices[i][j].get(k, m);
					}
				}
			}
		}
		
	
	}
	
	/**
	 * create parts of the matrix
	 * @param dividerCount
	 * @return parts
	 */
	public ComplexNumberSquareMatrix[][] getParts(int dividerCount) {
		ComplexNumberSquareMatrix[][] partialMatrix = null;
		if(dividerCount==2) {
			partialMatrix= new ComplexNumberSquareMatrix[2][1];	
		}
		else if(dividerCount==4){
			partialMatrix= new ComplexNumberSquareMatrix[2][2];
		}
		else if(dividerCount==8){
			partialMatrix= new ComplexNumberSquareMatrix[4][2];
		}
		
		
		
		for (int i = 0; i < partialMatrix.length; i++) {
			for (int j = 0; j < partialMatrix[i].length; j++) {
				
				ComplexNumber[][] complexNumbers = new ComplexNumber[xSize/partialMatrix.length][ySize/partialMatrix[i].length];
				for (int k = i*(xSize/partialMatrix.length),m=0; k <xSize/partialMatrix.length*(i+1); k++,m++) {
					for (int l = j*(ySize/partialMatrix[i].length),n=0; l <ySize/partialMatrix[i].length*(j+1); l++,n++) {
						complexNumbers[m][n]=matrix[k][l];
					}
				}
				partialMatrix[i][j]=new ComplexNumberSquareMatrix(complexNumbers);

			}
			
		}

		return partialMatrix;


	}
	
	
	
	/**
	 * Creates a complex number square matrix with given ComplexNumber 2d array(matrix)
	 * @param matrix
	 */
	public ComplexNumberSquareMatrix(ComplexNumber[][] matrix) {
		this.matrix=matrix;
		this.xSize=matrix.length;
		this.ySize=matrix[0].length;

	}
	
	
	/**
	 * Fills the matrix with random complex numbers
	 */
	public void fillRandomly() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = new ComplexNumber();
			}
		}
	}
	
	/**
	 * Return the Complex Number for given x,y positions
	 * @param x x position
	 * @param y y position
	 * @return the Complex Number in the given x,y positions
	 */
	public ComplexNumber get(int x,int y) {
		return matrix[x][y];
	}
	
	
	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer(); 
		
		for (int i = 0; i < matrix.length; i++) {
			stringBuffer.append("| ");
			for (int j = 0; j < matrix[i].length; j++) {
				stringBuffer.append(matrix[i][j]);
				stringBuffer.append(" ");
			}
			stringBuffer.append(" |");
			if(i!=matrix.length-1)
				stringBuffer.append("\n");
		}
		
		return stringBuffer.toString();
	}

	public int getXSize() {
		return xSize;
	}
	

	public int getYSize() {
		return ySize;
	}
	
	public ComplexNumber[][] getMatrix() {
		return matrix;
	}
	
	

	
	
	
	

}
