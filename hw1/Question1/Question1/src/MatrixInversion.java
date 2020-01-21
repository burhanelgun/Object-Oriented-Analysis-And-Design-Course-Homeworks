/**
 * 
 * @author Burhan Elgun
 *This class is implements the SolutionBehavior interface for solving a linear equation with matrix inversion method.
 */
public class MatrixInversion implements SolutionBehavior{

	/**
	 * This method takes a matrix representation of a standart linear equations system and integer values of these equations.
	 * This method solves the linear equation system with matrix inversion method and return the solution as a double array.
	 */
	@Override
	public double[] solve(double matrix[][],double rightOfEquals[]) {
		double[] solution = new double[rightOfEquals.length];
		double[][] identityMatrix = new double[rightOfEquals.length][rightOfEquals.length];

		
		//initialize identity matris 
		for (int i = 0; i < identityMatrix.length; i++) {
			for (int j = 0; j < identityMatrix.length; j++) {
				if(i==j) {
					identityMatrix[i][j]=1;
				}
				else {
					identityMatrix[i][j]=0;
				}
			}
		}
		
		
		//convert the original matrix to identity matrix and apply same operations identityMatrix
		for (int i = 0; i < rightOfEquals.length; i++) {
			double cursor = matrix[i][i];
			for (int j = 0; j < rightOfEquals.length; j++) {
				matrix[i][j]=matrix[i][j]/cursor;
				identityMatrix[i][j]=identityMatrix[i][j]/cursor;
			}

			for (int k = 0; k < rightOfEquals.length; k++) {
				if(k!=i) {
					double extender = matrix[k][i];
					matrix[k][i] = matrix[k][i] - extender*matrix[i][i];
					identityMatrix[k][i] = identityMatrix[k][i] - extender*identityMatrix[i][i];

					for (int m = 0; m < rightOfEquals.length; m++) {
						if(m!=i) {
							matrix[k][m] = matrix[k][m] - extender*matrix[i][m];
							identityMatrix[k][m] = identityMatrix[k][m] - extender*identityMatrix[i][m];
						}
					}		
				}	
			}
		}
		
		for (int i = 0; i < identityMatrix.length; i++) {
			for (int j = 0; j < identityMatrix.length; j++) {
				solution[i]=(double)Math.round((solution[i]+(rightOfEquals[j]*identityMatrix[i][j])) * 1000000d) / 1000000d;
			}
		}
		
		return solution;
	}

}
