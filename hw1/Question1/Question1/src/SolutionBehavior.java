/**
 * 
 * @author Burhan Elgun
 *This interface has only solve method for make an interface for solving method of linear equations system.
 */
public interface SolutionBehavior {
	/**
	 * 
	 * @param matrix represents the linear equation system 
	 * @param rightOfEquals represents the values of the equations
	 * @return solution of the linear equation system.
	 */
	public double[] solve(double matrix[][],double rightOfEquals[]);

}
