/**
 * 
 * @author Burhan Elgun
 *This class is implements the SolutionBehavior interface for solving a linear equation with Gaussian elimination method.
 */
public class GaussianElimination implements SolutionBehavior {

	
	/**
	 * This method takes a matrix representation of a standart linear equations system and integer values of these equations.
	 * This method solves the linear equation system with gaussian elimination method and return the solution as a double array.
	 */
	@Override
	public double[] solve(double matrix[][],double rightOfEquals[]) {
		
		for (int i = 0; i < rightOfEquals.length; i++) {
			double cursor = matrix[i][i];

			for (int j = 0; j < rightOfEquals.length; j++) {
				matrix[i][j]=matrix[i][j]/cursor;
			}
			rightOfEquals[i] = (double)Math.round(( rightOfEquals[i]/cursor) * 1000000d) / 1000000d;
			
			for (int k = 0; k < rightOfEquals.length; k++) {
				if(k!=i) {
					
					double extender = matrix[k][i];
					matrix[k][i] = matrix[k][i] - extender*matrix[i][i];

					for (int m = 0; m < rightOfEquals.length; m++) {
						if(m!=i) {
							matrix[k][m] = matrix[k][m] - extender*matrix[i][m];
						}
					}
					rightOfEquals[k] = (double)Math.round(( rightOfEquals[k]-(extender*rightOfEquals[i])) * 1000000d) / 1000000d;
							
				}
			}
		}
 
		return rightOfEquals;
	}

}
