import java.util.ArrayList;
import java.util.Random;
/**
 * This class implements the RouletteWheelSelection selection type
 * @author Burhan ELGUN
 *
 */
public class RouletteWheelSelection implements SelectionBehavior {

	/**
	 * This method takes an chromosomes Arraylist and makes Roulette Wheel Selection on it and returns new chromosomes Arraylist
	 */
	@Override
	public ArrayList<Chromosome> selection(ArrayList<Chromosome> chromosomes) {
		ArrayList<Double> randomFitnessProbabilitiesList = new ArrayList<Double>();
		ArrayList<Double> cumulativeFitnessProbabiliesList = new ArrayList<Double>();
		ArrayList<Chromosome> selectedChromosomes = new ArrayList<Chromosome>();


		Random rand = new Random();
		
		int rangeMin = 0;
		int rangeMax = 1;
		
		//generate POPULATION_SIZE random probability for each chromosome
		for (int i = 0; i < chromosomes.size(); i++) {
			double randomFitnessProbability = rangeMin + (rangeMax - rangeMin) * rand.nextDouble();
			randomFitnessProbabilitiesList.add(randomFitnessProbability);
		}
		
		//create cumulative fitness probabilities 
		double totalCumulativeFitnessProbability=0;
		for (int i = 0; i < chromosomes.size(); i++) {
			cumulativeFitnessProbabiliesList.add(totalCumulativeFitnessProbability); 
			totalCumulativeFitnessProbability = totalCumulativeFitnessProbability + chromosomes.get(i).getFitnessProbability();
		}
		cumulativeFitnessProbabiliesList.add(1.0); 
		
		//select the chromosomes
		for (int i = 0; i < randomFitnessProbabilitiesList.size(); i++) {
			for (int j = 1; j < cumulativeFitnessProbabiliesList.size(); j++) {
				if(randomFitnessProbabilitiesList.get(i)<cumulativeFitnessProbabiliesList.get(j) && randomFitnessProbabilitiesList.get(i)>cumulativeFitnessProbabiliesList.get(j-1)) {
					selectedChromosomes.add(chromosomes.get(j-1));
				}

			}
		}
		
		return selectedChromosomes;
	}

}
