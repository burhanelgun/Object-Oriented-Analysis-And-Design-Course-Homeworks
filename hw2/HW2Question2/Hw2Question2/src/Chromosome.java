import java.math.BigInteger;

public class Chromosome implements Comparable<Chromosome>{
	
	/**
	 * Name of the chromosome
	 */
	private String name;
	
	/**
	 * value x1 of the chromosome
	 */
	private double x1;
	
	/**
	 * value x2 of the chromosome
	 */
	private double x2;
	
	/**
	 * fitness value of the chromosome
	 */
	private double fitnessValue=-9999;
	
	/**
	 * fitness probability of the chromosome
	 */
	private double fitnessProbability=-9999;
	
	/**
	 * binary format of the chromosome
	 */
	private String binaryChromosome;
	
	/**
	 * binary format of the x1 value
	 */
	private String binaryX1;
	
	/**
	 * binary format of the x2 value
	 */
	private String binaryX2;

	/**
	 * sets the x1 and x2 values
	 * @param x1 x1 value of the chromosome
	 * @param x2 x2 value of the chromosome
	 */
	public Chromosome(double x1, double x2) {
		setX1andX2(x1, x2);
	}
	
	/**
	 * sets the x1 and x2 values
	 * @param x1 x1 value of the chromosome
	 * @param x2 x2 value of the chromosome
	 * @param name name of the chromosome

	 */
	public Chromosome(String name,double x1, double x2) {
		this.name = name;
		this.setX1andX2(x1, x2);
	}
	
	/**
	 * 
	 * @param name name of the chromosome
	 * @param binaryChromosome binary format of the chromosome
	 */
	public Chromosome(String name, String binaryChromosome) {
		this.name=name;
		this.setX1andX2(binaryChromosome);
	}
	
	/**
	 * it sets the the binary format of the chromosome
	 * @param binaryChromosome sets the binary format and x1 x2 values of the chromosome
	 */
	private void setX1andX2(String binaryChromosome) {
		this.binaryChromosome=binaryChromosome;
		this.binaryX1 = binaryChromosome.substring(0,63);
		this.binaryX2 = binaryChromosome.substring(63);
		this.x1=binaryStringToDouble(binaryX1);
		this.x2=binaryStringToDouble(binaryX2);

		initializeFitnessValue();

		
	}
	
	/**
	 * Implementation of the toString method
	 */
	@Override
	public String toString() {
		return name+"   "+(double)Math.round( x1 * 100d) / 100d+"   "+(double)Math.round(x2 * 100d) / 100d + "   " + (double)Math.round(fitnessValue * 100d) / 100d + "   " + (double)Math.round(fitnessProbability * 100d) / 100d;
	}
	
	/**
	 * It initializes the binary chromosome according to x1 and x2 values
	 */
	public void initializeBinaryChromosome() {
			
			binaryX1 = decimalToBinaryString(x1); 
			binaryX1=extendBinary(binaryX1);
			
			binaryX2= decimalToBinaryString(x2);
			binaryX2=extendBinary(binaryX2);
			
			this.binaryChromosome = binaryX1+binaryX2;

	}
	
	/**
	 * it converts a double into binary form
	 * @param decimal decimal that will converted to binary form
	 * @return binary form of the decimal
	 */
	public String decimalToBinaryString(double decimal) {
		return  Long.toBinaryString((Double.doubleToRawLongBits(decimal)));
	}	   
	
	/**
	 * It extends a binary string that has 62 characters to 63 characters
	 * @param s binary format
	 * @return double format
	 */
	public String extendBinary(String s) {
		if(s.length()==62) {
			return "0"+s;
		}
		else {
			return s;
		}
	}
	
	/**
	 * fitness function of the problem
	 * @param x1 x1 value
	 * @param x2 x2 value
	 * @return output of the function
	 */
	public double fitnessFunction(double x1,double x2) {
		return 20*(x1)*(x2)+16*(x2)-2*(Math.pow(x1, 2))-(Math.pow(x2, 2))-
				(Math.pow(x1+x2,2));
	}
 
	/**
	 * initializes the fitness probability
	 * @param totalFitnessVal it is used for calculating the fitness probability.
	 */
	public void initializeFitnessProbability(double totalFitnessVal) {
		fitnessProbability = fitnessValue/totalFitnessVal;
	}
	
	/**
	 * initializes the fitness value
	 */
	public void initializeFitnessValue() {
		fitnessValue = fitnessFunction(x1, x2);
	}

	public void setFitnessProbability(double fitnessProbability) {
		this.fitnessProbability = fitnessProbability;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setX1andX2(double x1,double x2) {
		this.x1=x1;
		this.x2=x2;
		initializeBinaryChromosome();
		initializeFitnessValue();
	}
	public double getFitnessValue() {
		return fitnessValue;
	}
	public String getBinaryChromosome() {
		return binaryChromosome;
	}
	public double getFitnessProbability() {
		return fitnessProbability;
	}
	public String getName() {
		return name;
	}
	public double getX1() {
		return x1;
	}
	public double getX2() {
		return x2;
	}
	
	public String getBinaryX1() {
		return binaryX1;
	}
	
	public String getBinaryX2() {
		return binaryX2;
	}
	
	/**
	 * convert binary sting to double
	 * @param binary format
	 * @return double format
	 */
	public double binaryStringToDouble(String binary) {
		return Double.longBitsToDouble(new BigInteger(binary, 2).longValue());
	}	
	
	/**
	 * 
	 * @return true if x1 and x2 values has correct values according the rule
	 */
	public boolean isValid() {
		if(x1<=5 && x2<=5 && (x1+x2)<=5 && fitnessValue>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * It compares two Chromosome according the fitness values
	 */
	@Override
	public int compareTo(Chromosome o) {
	    if(this.fitnessValue<o.fitnessValue)
	          return -1;
	    else if(o.fitnessValue<this.fitnessValue)
	          return 1;
	    return 0;
	}

}
