import java.util.ArrayList;
/**
 * This is an interface for different Selection types
 * @author Burhan ELGUN
 *
 */
public interface SelectionBehavior {
	
	/**
	 * makes selection
	 * @param chromosomes making selection with using this parameter
	 * @return return new selected chromosomes
	 */
	public ArrayList<Chromosome> selection(ArrayList<Chromosome> chromosomes);
}
