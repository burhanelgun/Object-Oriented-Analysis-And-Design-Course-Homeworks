import java.util.ArrayList;
import java.util.Random;

/**
 * This class implements the TournamentSelection selection type
 * @author Burhan ELGUN
 *
 */
public class TournamentSelection implements SelectionBehavior {
	/**
	 * This method takes an chromosomes Arraylist and makes Tournament Selection on it and returns new chromosomes Arraylist
	 */
	@Override
	public ArrayList<Chromosome> selection(ArrayList<Chromosome> chromosomes) {
		int selectSize =3;
		ArrayList<Chromosome> selectedChromosomes = new ArrayList<Chromosome>();

		for (int i = 0; i < chromosomes.size(); i++) {
			
			Chromosome bestChromosome = null;
			for (int j = 0; j < selectSize; j++) {
				Random random = new Random();
				int randIndex = random.nextInt(chromosomes.size());
				if(j==0) {
					bestChromosome=chromosomes.get(randIndex);
				}
				else {
					if(bestChromosome.compareTo(chromosomes.get(randIndex))==-1) {
						bestChromosome=chromosomes.get(randIndex);
					}
				}	
			}
			selectedChromosomes.add(bestChromosome);
		}
		return selectedChromosomes;
	}

}
