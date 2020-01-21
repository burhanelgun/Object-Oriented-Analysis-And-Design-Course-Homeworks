import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Version 2 will use rank selection and 2 point crossover.
 * @author Burhan ELGUN
 *
 */
public class Version2GA extends GeneticAlgorithm {
	/**
	 * Initializes the selection and cross over behaviors with rank selection and 2 point cross over 
	 */
	public Version2GA() {
		super();		selectionBehavior= new RankSelection();
		crossOverBehavior = new TwoPointCrossOver();
	}
	/**
	 * This method makes rank selection
	 */	
	@Override
	public ArrayList<Chromosome> selection(ArrayList<Chromosome> chromosomes) {
		return selectionBehavior.selection(chromosomes);
	}
	/**
	 * This method makes 2 point cross over 
	 */	
	@Override
	public ArrayList<Chromosome> crossover(ArrayList<Chromosome> chromosomes) {
		return crossOverBehavior.crossOver(chromosomes);
	}


}
