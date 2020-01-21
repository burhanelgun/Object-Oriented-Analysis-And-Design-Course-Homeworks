import java.util.ArrayList;
import java.util.Random;
/**
 * This class implements the OnePointCrossOver cross over type
 * @author Burhan ELGUN
 *
 */
public class OnePointCrossOver implements CrossOverBehavior{

	/**
	 * This method takes an chromosomes Arraylist and makes cross over on it and returns new chromosomes Arraylist
	 */
	@Override
	public ArrayList<Chromosome> crossOver(ArrayList<Chromosome> chromosomes) {
		for (int i = 0; i < chromosomes.size(); i=i+2) {
			
			Chromosome chromosome1 = chromosomes.get(i);
			Chromosome chromosome2 = chromosomes.get(i+1);

			Random rand = new Random();
			int rangeMin=0;
			int rangeMax=chromosome1.getBinaryChromosome().length()-1;//it gives 125 for this problem (63+63)-1
			
			//generate random point
			int randomCrossOverPoint = rand.nextInt(rangeMax-rangeMin+1)+rangeMin;

			//divide the chromosome1 into two parts
			String pointBeforeChromosome1 = chromosome1.getBinaryChromosome().substring(0,randomCrossOverPoint);
			String pointAfterChromosome1 = chromosome1.getBinaryChromosome().substring(randomCrossOverPoint);


			//divide the chromosome2 into two parts
			String pointBeforeChromosome2 = chromosome2.getBinaryChromosome().substring(0,randomCrossOverPoint);
			String pointAfterChromosome2 = chromosome2.getBinaryChromosome().substring(randomCrossOverPoint);

			//create new two childs
			Chromosome childChromosome1= new Chromosome("Child"+i,(pointBeforeChromosome1+pointAfterChromosome2));
			Chromosome childChromosome2= new Chromosome("Child"+(i+1),(pointBeforeChromosome2+pointAfterChromosome1));

			
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
