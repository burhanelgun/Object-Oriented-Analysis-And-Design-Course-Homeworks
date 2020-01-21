
/**
 * 
 * @author Burhan ELGUN
 * This class is a suit
 *
 */
public class Dec extends Suit{
	
	Dec(){
		description="Dec";
	}

	/**
	 * Return the cost of the Dec
	 */
	@Override
	public double cost() {
		return 500000;
	}

	/**
	 * Return the weight of the Dec
	 */
	@Override
	public double weight() {
		return 25;
	}

}
