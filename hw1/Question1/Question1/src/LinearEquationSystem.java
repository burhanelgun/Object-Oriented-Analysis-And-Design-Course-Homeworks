
/**
 * 
 * @author Burhan Elgun
 * This class represent a linear equation system. It has the linear equation system as a matrix. Also it has a SolutionBehavior reference for
 * solution method.
 */
public class LinearEquationSystem {
	/**
	 * It represents the solution behavior of the linear equation system.
	 */
	SolutionBehavior solutionBehavior;
	/**
	 * It represents the linear equation system as a matrix
	 */
	private double matrix[][];
	/**
	 * It represents all values of linear equations in the system.
	 */
	private double rightOfEquals[];
	/**
	 * It represents the variables in the linear equation system.
	 */
	private String[] variables;
	/**
	 * It represents the number of linear equations in the system.
	 */
	private int numberOfEquations;
	/**
	 * It represents the solution of the linear equation system.
	 */
	private double[] solution;
	
	public LinearEquationSystem(double matrix[][],double rightOfEquals[],String[] variables,int numberOfEquations) {
		this.matrix=matrix;
		this.rightOfEquals=rightOfEquals;
		this.variables=variables;
		this.numberOfEquations=numberOfEquations;
	}
	
	/**
	 * For setting the solution behavior
	 * @param solutionBehavior represensts the solution method(strategy)  
	 */
	public void setSolutionBehavior(SolutionBehavior solutionBehavior) {
		this.solutionBehavior=solutionBehavior;
	}
	
	/**
	 * Used for performing the solution by using the SolutionBehavior
	 */
	public void performSolution() {
		solution = solutionBehavior.solve(matrix,rightOfEquals);
	}
	
	/**
	 * Printing the solution of the linear equation system.
	 */
	public void printSolution() {
		
		for(int i=0;i<numberOfEquations;i++) {
			System.out.println(variables[i]+"="+solution[i]);
		}
	}
	
	/**
	 * Prints the matrix
	 */
	public void printMatrix() {
		for(int i=0;i<matrix.length;i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+ " ");
			}
			System.out.println();
		}
		
	}
}
