
/**
 * 
 * @author Burhan ELGUN
 * It is an abstract class for representing the general suit operations and attributes
 *
 */
public abstract class Suit {
	/**
	 * Description of the Suit
	 */
	String description="Unknown Suit";
	
	public String getDescription() {
		return description;
	}
	/**
	 * 
	 * @return cost of the suit
	 */
	public abstract double cost();
	
	/**
	 * 
	 * @return cost of the weight
	 */
	public abstract double weight();

}
