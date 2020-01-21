
public class MainCalculator{
	
	/**
	 * matrixA
	 */
	ComplexNumberSquareMatrix matrixA;
	
	/**
	 * matrixB
	 */
	ComplexNumberSquareMatrix matrixB;
	
	/**
	 * sum of matrices(A+B)
	 */
	ComplexNumberSquareMatrix sumOfMatrices;
	
	/**
	 * sum of matrices parts
	 */
	ComplexNumberSquareMatrix[][] sumOfMatricesParts;
	
	/**
	 * dftResult of the A+B
	 */
	ComplexNumberSquareMatrix dftResult;
	
	/**
	 * thread count
	 */
	int threadCount;
	
	/**
	 * threads 2d arr
	 */
	Thread[][] threadArr;
	
	ComplexNumberSquareMatrixAdder[][] adderArr;
	
	public MainCalculator(ComplexNumberSquareMatrix matrixA,ComplexNumberSquareMatrix matrixB,int threadCount) {
		this.matrixA=matrixA;
		this.matrixB=matrixB;
		this.threadCount=threadCount;
		if(threadCount==2) {
			threadArr= new Thread[threadCount][threadCount/2]; 
			adderArr= new ComplexNumberSquareMatrixAdder[threadCount][threadCount/2]; 

		}
		else if(threadCount==4) {
			threadArr= new Thread[threadCount/2][threadCount/2]; 
			adderArr= new ComplexNumberSquareMatrixAdder[threadCount/2][threadCount/2]; 

		}
		else if(threadCount==8) {
			threadArr= new Thread[threadCount/2][threadCount/4]; 
			adderArr= new ComplexNumberSquareMatrixAdder[threadCount/2][threadCount/4]; 

		}	

	}
	
	public MainCalculator() {
		if(threadCount==2) {
			threadArr= new Thread[threadCount][threadCount/2]; 
			adderArr= new ComplexNumberSquareMatrixAdder[threadCount][threadCount/2]; 

		}
		else if(threadCount==4) {
			threadArr= new Thread[threadCount/2][threadCount/2]; 
			adderArr= new ComplexNumberSquareMatrixAdder[threadCount/2][threadCount/2]; 

		}
		else if(threadCount==8) {
			threadArr= new Thread[threadCount/2][threadCount/4]; 
			adderArr= new ComplexNumberSquareMatrixAdder[threadCount/2][threadCount/4]; 

		}	
	}

	/**
	 * makes all calculation
	 */
	public void calculate() {
		
		calculateSum();
		calculateDFT();
		//System.out.println("RESULT\n"+dftResult);
	}
	
	/**
	 * calculate sum of all matrix
	 */
	public void calculateSum() {
		ComplexNumberSquareMatrix[][] partialMatrixA = matrixA.getParts(threadCount);
		ComplexNumberSquareMatrix[][] partialMatrixB = matrixB.getParts(threadCount);


		for (int i = 0; i < adderArr.length; i++) {
			for (int j = 0; j < adderArr[i].length; j++) {
				adderArr[i][j]=new ComplexNumberSquareMatrixAdder(partialMatrixA[i][j], partialMatrixB[i][j]);
				threadArr[i][j] = new Thread(adderArr[i][j]);
				threadArr[i][j].start();
				try {
					threadArr[i][j].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
		
		//partially sum is finished, and now the parts will be combined
		ComplexNumberSquareMatrix[][] complexNumberSquareMatrix = new ComplexNumberSquareMatrix[adderArr.length][adderArr[0].length];
		for (int i = 0; i < adderArr.length; i++) {
			for (int j = 0; j < adderArr[i].length; j++) {
				complexNumberSquareMatrix[i][j]=adderArr[i][j].getSumMatrix();
			}
		}
		
		sumOfMatrices = new ComplexNumberSquareMatrix(complexNumberSquareMatrix,threadCount);
		sumOfMatricesParts = sumOfMatrices.getParts(threadCount);

	}
	
	/**
	 * calculate dft of all matrix
	 */
	public void calculateDFT() {
		


		DFTCalculator[][] dftMatrices=null;
		if(threadCount==2) {
			dftMatrices= new DFTCalculator[threadCount][threadCount/2]; 
		}
		else if(threadCount==4) {
			dftMatrices= new DFTCalculator[threadCount/2][threadCount/2]; 
		}
		else if(threadCount==8) {
			dftMatrices= new DFTCalculator[threadCount/2][threadCount/4]; 
		}
		for (int i = 0; i < dftMatrices.length; i++) {
			for (int j = 0; j < dftMatrices[0].length; j++) {
				dftMatrices[i][j]=new DFTCalculator(sumOfMatricesParts[i][j]);
				threadArr[i][j] = new Thread(dftMatrices[i][j]);
				threadArr[i][j].start();
				try {
					threadArr[i][j].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
		
		
		//partially sum is finished, and now the parts will be combined
		ComplexNumberSquareMatrix[][] dftLastMatrix = new ComplexNumberSquareMatrix[dftMatrices.length][dftMatrices[0].length];
		for (int i = 0; i < dftMatrices.length; i++) {
			for (int j = 0; j < dftMatrices[i].length; j++) {
				dftLastMatrix[i][j]=dftMatrices[i][j].getDftMatrix();
			}
		}
		
		dftResult = new ComplexNumberSquareMatrix(dftLastMatrix,threadCount);
		
		
		
	}


	public ComplexNumberSquareMatrix getDftResult() {
		return dftResult;
	}
	
	
	
	public ComplexNumberSquareMatrix getSumOfMatrices() {
		return sumOfMatrices;
	}

	public void setMatrixA(ComplexNumberSquareMatrix matrixA) {
		this.matrixA=matrixA;
		
	}

	public void setMatrixB(ComplexNumberSquareMatrix matrixB) {
		this.matrixB=matrixB;
		
	}

	public void setThreadCount(int i) {
		this.threadCount=i;
		if(threadCount==2) {
			threadArr= new Thread[threadCount][threadCount/2]; 
			adderArr= new ComplexNumberSquareMatrixAdder[threadCount][threadCount/2]; 

		}
		else if(threadCount==4) {
			threadArr= new Thread[threadCount/2][threadCount/2];
			adderArr= new ComplexNumberSquareMatrixAdder[threadCount/2][threadCount/2]; 

		}
		else if(threadCount==8) {
			threadArr= new Thread[threadCount/2][threadCount/4]; 
			adderArr= new ComplexNumberSquareMatrixAdder[threadCount/2][threadCount/4]; 

		}	
		
	}


	public void stop() {
		for (int i = 0; i < adderArr.length; i++) {
			for (int j = 0; j < adderArr[i].length; j++) {
				adderArr[i][j].stop();
				
			}
		}
		System.out.println("Stop called");
	}

	public void restart() {
		System.out.println("Restart called");
	}




}
