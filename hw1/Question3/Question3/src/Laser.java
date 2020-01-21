/**
 * 
 * @author Burhan ELGUN
 * This class if a Accessory for a suit and it inherit from AccessoryDecorator abstract class.
 *
 */
public class Laser extends AccessoryDecorator {
	/**
	 * This suit is a suit of the this Laser
	 */
	Suit suit;
	
	public Laser(Suit suit) {
		this.suit=suit;
	}

	/**
	 * it returns the suit description + "Laser"
	 */
	@Override
	public String getDescription() {
		return suit.getDescription() + ", Laser";
	}

	/**
	 * This returns suit cost+ Laser cost
	 */
	@Override
	public double cost() {
		return 200000+suit.cost();
	}

	/**
	 * This returns suit weight+ Laser weight
	 */
	@Override
	public double weight() {
		return 5.5+suit.weight();
	}
	

}


