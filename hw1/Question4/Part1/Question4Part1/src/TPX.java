/**
 *This class is for representing a TPX
 * @author Burhan ELGUN
 *
 */
public abstract class TPX {
	/**
	 * model of the TPX
	 */
	protected String model;
	/**
	 * purpose of the TPX
	 */
	protected String purpose;
	/**
	 * skeleton type of the tpx
	 */
	protected String skeletonType;
	/**
	 * engine type of the TPX
	 */
	protected String engineType;
	
	/**
	 * number of seating of the TPX
	 */
	protected int numberOfSeating;

	/**
	 * it construct the skeleton
	 */
	public void constructSkeleton() {
		System.out.println(skeletonType+" Skeleton of " + model+" is constructed.");
	}
	/**
	 * it places the engines
	 */
	public void placeEngines() {
		System.out.println(engineType+" of " + model+" are placed.");
	}
	/**
	 * it places the seats
	 */
	public void placeSeats() {
		System.out.println(numberOfSeating+" seats of " + model+" are placed.");
	}

	public String getEngineType() {
		return engineType;
	}
	public String getModel() {
		return model;
	}
	public int getNumberOfSeating() {
		return numberOfSeating;
	}
	public String getPurpose() {
		return purpose;
	}
	public String getSkeletonType() {
		return skeletonType;
	}
}
