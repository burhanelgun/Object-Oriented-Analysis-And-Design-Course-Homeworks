
public class BestDSEverAdapter implements DS{
	
	/**
	 * BestDSever reference
	 */
	public BestDSEver bestDSEver;
	
	public BestDSEverAdapter(BestDSEver bestDSEver) {
		this.bestDSEver = bestDSEver;
	}
	
	/**
	 *(synchronized) insert object to the data structure
	 */
	public synchronized void insert(Object o) {
		System.out.print("Synchronized ");
		bestDSEver.insert(o);
	}
	
	/**
	 *(synchronized) remove object from data structure
	 */
	public synchronized void remove(Object o) {
		System.out.print("Synchronized ");
		bestDSEver.remove(o);
	}
	
	/**
	 *(synchronized) get object from data structure
	 */
	public synchronized Object get(int index) {
		System.out.print("Synchronized ");
		return bestDSEver.get(index);
	}
}
