
/**
 * Subject interface that has register remove and notify observer methods
 * @author Burhan ELGUN
 *
 */
public interface Subject {

	/**
	 * registers observer
	 * @param o observer to be registered
	 */
	public void registerObserver(Observer o);
	
	/**
	 * removes observer
	 * @param o observer to be removed
	 */
	public void removeObserver(Observer o);
	
	/**
	 * notifies observers
	 */
	public void notifyObservers();


}
