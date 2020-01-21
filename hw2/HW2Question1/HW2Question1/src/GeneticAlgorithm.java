import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * This class has a template method named run
 * @author b
 *
 */
public abstract class GeneticAlgorithm {
	
	/**
	 * Stored chromosomes in ArrayList
	 */
	ArrayList<Chromosome> chromosomes;
	
	/**
	 * It defines the selection type
	 */
	SelectionBehavior selectionBehavior;
	
	/**
	 * It defines the crossover type
	 */
	CrossOverBehavior crossOverBehavior;
	
	/**
	 * Number of iterations
	 */
	int iterationCount;

	/**
	 * Total fitness value
	 */
	double totalFitnessVal;
	
	/**
	 * Population size
	 */
	static final int POPULATION_SIZE = 50;
	
	/**
	 * Mutation parameter
	 */
	static final double MUTATION_PARAMETER = 0.1;
	
	/**
	 * Storing the chromosome that has biggest fitness value in all iterations
	 */
	Chromosome maximumChromosome;
	
	/**
	 * 
	 * @param chromosomes takes and make selection on it
	 * @return a new chromosomes ArrayList
	 */
	public abstract ArrayList<Chromosome> selection(ArrayList<Chromosome> chromosomes);
	
	/**
	 * 
	 * @param chromosomes takes and make crossover on it
	 * @return a new chromosomes ArrayList
	 */
	public abstract ArrayList<Chromosome> crossover(ArrayList<Chromosome> chromosomes);
	
	/**
	 * initializes variable and creates object
	 */
	public GeneticAlgorithm() {
		chromosomes = new ArrayList<Chromosome>();
		iterationCount = 0;
	}
	
	
	/**
	 * Template method
	 */
	public void run() {

		generateInitialPopulation();
		computeFitness();
		printBest();
		while(true) {
			iterationCount++;
			chromosomes=selection(this.chromosomes);
			chromosomes=crossover(this.chromosomes);
			if(iterationCount%10==0) {
				mutation();
			}
			computeFitness();
			printBest();
			try {
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
	
	/**
	 * printing the best chromosome that has biggest fitness value in all iterations
	 */
	public void printBest() {
		double max = chromosomes.get(0).getFitnessValue();
		int index=0;
		for (int i = 1; i < chromosomes.size(); i++) {
			double fitnessVal=chromosomes.get(i).getFitnessValue();
			if(fitnessVal>max) {
				max=fitnessVal;
				index=i;
			}
		}
		
		if(maximumChromosome.getFitnessValue()<chromosomes.get(index).getFitnessValue()) {
			maximumChromosome=chromosomes.get(index);
		}
		
		System.out.println("Generation:"+iterationCount+ " => f("+chromosomes.get(index).getX1()+" , "+chromosomes.get(index).getX2()+ ") = "+chromosomes.get(index).getFitnessValue()+ "  (MAX Value=> f("+maximumChromosome.getX1()+" , "+maximumChromosome.getX2()+ ") = "+maximumChromosome.getFitnessValue());

	}
	
	/**
	 * Generation of initial population
	 */
	public void generateInitialPopulation() {
		
		Random rand = new Random();
		
		double rangeMinX1=0;
		double rangeMaxX1=5;

		for (int i = 0; i < POPULATION_SIZE; i++) {
			
			double randomX1 = rangeMinX1 + (rangeMaxX1 - rangeMinX1) * rand.nextDouble();
			
			double rangeMinX2=0;
			double rangeMaxX2=rangeMaxX1-randomX1;
			
			double randomX2 = rangeMinX2 + (rangeMaxX2 - rangeMinX2) * rand.nextDouble();
			
			Chromosome chromosome = new Chromosome("Chromosome"+i,randomX1, randomX2);
			if(chromosome.getFitnessValue()<0 || !chromosome.isValid()) {
				i--;
			}
			else {
				chromosomes.add(chromosome);
			}

		}
		
		computeFitness();
		maximumChromosome=chromosomes.get(0);

	}
	
	 /**
	  * Computing the total fitness
	  */
	public void computeFitness() {
		totalFitnessVal=0;
		for (int i = 0; i < chromosomes.size(); i++) {
			totalFitnessVal = totalFitnessVal + chromosomes.get(i).getFitnessValue();
		}
		calculateFitnessProbability();
	}
	
	/**
	 * Calculates all fitness probabilities of chromosomes
	 */
	public void calculateFitnessProbability() {
		for (int i = 0; i < chromosomes.size(); i++) {
			chromosomes.get(i).initializeFitnessProbability(totalFitnessVal);
		}
	}
	

	/**
	 * Printing all the chromosomes
	 */
	public void printChromosomes() {
		System.out.println("  Name   -   x1 - x2  - Fitness Value - Fitness Probability");
		System.out.println("-----------------------------------------------------------");

		for (int i = 0; i < chromosomes.size(); i++) {
			System.out.println(chromosomes.get(i));
		}
		System.out.println("-------------------------------------");
		System.out.println("Total Fitness Value= "+ (double)Math.round( totalFitnessVal * 100d) / 100d);
	}
	
	/**
	 * Makes mutation on the chromosomes ArrayList
	 */
	public void mutation() {
		System.out.println("MUTATION");
		 int mutationCount= (int) (POPULATION_SIZE*chromosomes.get(0).getBinaryChromosome().length()*0.1);
		 Random random = new Random();
		 while (mutationCount>0) {
			 int row = random.nextInt(chromosomes.size()-1);
			 int column = random.nextInt(chromosomes.get(0).getBinaryChromosome().length()-1);
			 
			 Chromosome chromosome = chromosomes.get(row);
			 char positionChar= chromosome.getBinaryChromosome().charAt(column);
			 
			 if(positionChar=='0') {
				 positionChar='1';
			 }
			 else {
				 positionChar='0';
			 }
			 		 
			 String newBinaryChromosome =chromosome.getBinaryChromosome().substring(0,column)+positionChar+chromosome.getBinaryChromosome().substring(column+1);
	
			 Chromosome mutationChromosome= new Chromosome("Mutation"+row,newBinaryChromosome);
			
			if(mutationChromosome.isValid()) {
				chromosomes.remove(row);
				chromosomes.add(row,mutationChromosome);
				mutationCount--;
			}

		 }
		 computeFitness();
		
	}
}
