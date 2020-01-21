/**
 * 
 * @author Burhan ELGUN
 * This class if a Accessory for a suit and it inherit from RocketLauncher abstract class.
 *
 */
public class RocketLauncher extends AccessoryDecorator {
	/**
	 * This suit is a suit of the this RocketLauncher
	 */
	Suit suit;
	
	public RocketLauncher(Suit suit) {
		this.suit=suit;
	}
	/**
	 * it returns the suit description + "RocketLauncher"
	 */
	@Override
	public String getDescription() {
		return suit.getDescription() + ", RocketLauncher";
	}
	/**
	 * This returns suit cost+ RocketLauncher cost
	 */
	@Override
	public double cost() {
		return 150000+suit.cost();
	}
	
	/**
	 * This return the suit weight+RocketLauncher weight
	 */
	@Override
	public double weight() {
		return 7.5+suit.weight();
	}
	
}
