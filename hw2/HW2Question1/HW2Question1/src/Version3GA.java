import java.util.ArrayList;
import java.util.Random;

/**
 * Version 3 will use tournament selection and 1 point crossover.
 * @author Burhan ELGUN
 *
 */
public class Version3GA extends GeneticAlgorithm{

	/**
	 * Initializes the selection and cross over behaviors with tournament selection and 1 point cross over 
	 */
	public Version3GA() {
		super();
		selectionBehavior= new TournamentSelection();
		crossOverBehavior = new OnePointCrossOver();
	}
	
	/**
	 * This method makes tournament selection
	 */
	@Override
	public ArrayList<Chromosome> selection(ArrayList<Chromosome> chromosomes) {
		return selectionBehavior.selection(chromosomes);
	}

	/**
	 * This method makes 1 point cross over
	 */
	@Override
	public ArrayList<Chromosome> crossover(ArrayList<Chromosome> chromosomes) {
		return crossOverBehavior.crossOver(chromosomes);
	}


}
