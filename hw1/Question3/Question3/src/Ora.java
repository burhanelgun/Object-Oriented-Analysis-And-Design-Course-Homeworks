/**
 * 
 * @author Burhan ELGUN
 * This class is a suit
 *
 */
public class Ora extends Suit{
	
	Ora(){
		description="Ora";
	}
	
	/**
	 * Return the cost of the Ora
	 */
	@Override
	public double cost() {
		return 1500000;
	}
	
	/**
	 * Return the weight of the Ora
	 */
	@Override
	public double weight() {
		return 30;
	}

}
