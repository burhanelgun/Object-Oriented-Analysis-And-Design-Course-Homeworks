/**
 * 
 * @author Burhan ELGUN
 * This class if a Accessory for a suit and it inherit from AccessoryDecorator abstract class.
 *
 */
public class FlameThrower extends AccessoryDecorator {
	/**
	 * This suit is a suit of the this FlameThrower
	 */
	Suit suit;
	
	public FlameThrower(Suit suit) {
		this.suit=suit;
	}
	
	/**
	 * it returns the suit description + "Flame Thrower"
	 */
	@Override
	public String getDescription() {
		return suit.getDescription() + ", Flame Thrower";

	}
	/**
	 * This returns suit cost+ FlameThrower cost
	 */
	@Override
	public double cost() {
		return 50000+suit.cost();

	}
	/**
	 * This returns suit weight+ FlameThrower weight
	 */
	@Override
	public double weight() {
		return 2+suit.weight();
	}


}
