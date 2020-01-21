/**
 * 
 * @author Burhan ELGUN
 * This class is a suit
 *
 */
public class Tor extends Suit{
	
	Tor(){
		description="Tor";
	}
	
	/**
	 * Return the cost of the Tor
	 */
	@Override
	public double cost() {
		return 5000000;
	}
	
	/**
	 * Return the weight of the Tor
	 */
	@Override
	public double weight() {
		return 50;
	}

}
