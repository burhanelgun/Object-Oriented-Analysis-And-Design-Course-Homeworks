import java.util.ArrayList;
import java.util.Random;
/**
 * This class implements the TwoPointsCrossOver cross over type
 * @author Burhan ELGUN
 *
 */
public class TwoPointCrossOver implements CrossOverBehavior{

	/**
	 * This method takes an chromosomes Arraylist and makes cross over on it and returns new chromosomes Arraylist
	 */
	@Override
	public ArrayList<Chromosome>  crossOver(ArrayList<Chromosome> chromosomes) {
		for (int i = 0; i < chromosomes.size(); i=i+2) {
			
			Chromosome chromosome1 = chromosomes.get(i);
			Chromosome chromosome2 = chromosomes.get(i+1);

			Random rand = new Random();
			
			int rangeMinPoint1=0;
			int rangeMaxPoint1=chromosome1.getBinaryChromosome().length()/2;
			int randomCrossOverPoint1 = rand.nextInt(rangeMaxPoint1-rangeMinPoint1+1)+rangeMinPoint1;
			
			int rangeMinPoint2=chromosome1.getBinaryChromosome().length()/2+1;
			int rangeMaxPoint2=chromosome1.getBinaryChromosome().length();
			int randomCrossOverPoint2 = rand.nextInt(rangeMaxPoint2-rangeMinPoint2+1)+rangeMinPoint2;
			

			//divide the chromosome1 into three parts
			String chromosome1Part1 = chromosome1.getBinaryChromosome().substring(0,randomCrossOverPoint1);
			String chromosome1Part2 = chromosome1.getBinaryChromosome().substring(randomCrossOverPoint1,randomCrossOverPoint2);
			String chromosome1Part3 = chromosome1.getBinaryChromosome().substring(randomCrossOverPoint2);


			//divide the chromosome2 into three parts
			String chromosome2Part1 = chromosome2.getBinaryChromosome().substring(0,randomCrossOverPoint1);
			String chromosome2Part2 = chromosome2.getBinaryChromosome().substring(randomCrossOverPoint1,randomCrossOverPoint2);
			String chromosome2Part3 = chromosome2.getBinaryChromosome().substring(randomCrossOverPoint2);

			//create new two childs
			Chromosome childChromosome1= new Chromosome("Child"+i,(chromosome1Part1+chromosome2Part2+chromosome1Part3));
			Chromosome childChromosome2= new Chromosome("Child"+(i+1),(chromosome2Part1+chromosome1Part2+chromosome2Part3));
			
			
			if(childChromosome1.isValid()) {
				chromosomes.remove(i);
				chromosomes.add(i,childChromosome1);
			}
			
			if(childChromosome2.isValid()) {
				chromosomes.remove(i+1);
				chromosomes.add(i+1,childChromosome2);
			}

		}
		return chromosomes;
	}

}