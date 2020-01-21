import java.util.ArrayList;
/**
 * This is an interface for different Cross Over types
 * @author Burhan ELGUN
 *
 */
public interface CrossOverBehavior {
	
	/**
	 * makes cross over
	 * @param chromosomes making crossover with using this parameter
	 * @return return new  chromosomes
	 */
	public ArrayList<Chromosome> crossOver(ArrayList<Chromosome> chromosomes);

}
