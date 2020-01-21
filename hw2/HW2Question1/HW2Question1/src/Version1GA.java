import java.util.ArrayList;
import java.util.Random;

/**
 * Version 1 will use roulette wheel selection and 1 point crossover.
 * @author Burhan ELGUN
 *
 */
public class Version1GA extends GeneticAlgorithm {
	/**
	 * Initializes the selection and cross over behaviors with roulette wheel selection and 1 point cross over 
	 */
	public Version1GA() {
		super();
		selectionBehavior= new RouletteWheelSelection();
		crossOverBehavior = new OnePointCrossOver();
	}
	
	/**
	 * This method makes roulette wheel selection
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
