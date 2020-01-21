/**
 * 
 * @author Burhan ELGUN
 * This class if a Accessory for a suit and it inherit from AccessoryDecorator abstract class.
 *
 */
public class AutoRifle extends AccessoryDecorator {
	/**
	 * This suit is a suit of the this AutoRifle
	 */
	Suit suit;
	
	public AutoRifle(Suit suit) {
		this.suit=suit;
	}

	/**
	 * it returns the suit description + "AutoRifle"
	 */
	@Override
	public String getDescription() {
		return suit.getDescription() + ", AutoRifle";
	}

	/**
	 * This returns suit cost+ AutoRifle cost
	 */
	@Override
	public double cost() {
		return 30000+suit.cost();
	}

	/**
	 * This return the suit weight+AutoRifle weight
	 */
	@Override
	public double weight() {
		return 1.5+suit.weight();
	}
	
}
