/**
 * it is an abstract class for representing general attributes and operations of the TPX 
 * @author Burhan ELGUN
 *
 */
public abstract class TPX {
	/**
	 * model of the tpx
	 */
	protected String model;
	/**
	 * purpose of the tpx
	 */
	protected String purpose;
	/**
	 * skeleton type of the tpx
	 */
	protected String skeletonType;
	/**
	 * engine type of the tpx
	 */
	protected String engineType;
	/**
	 * number of seating of the tpx
	 */
	protected int numberOfSeating;

	/**
	 * engine injection type of the tpx
	 */
	EngineInjectionType engineInjectionType;
	
	/**
	 * seating cover of the tpx
	 */
	SeatingCover seatingCover;

	/**
	 * this abstract method should places the engines
	 */
	public abstract void placeEngines();
	
	/**
	 * this abstract method should places the seats
	 */
	public abstract void placeSeats();
	
	
	/**
	 * it constructs the skeleton
	 */
	public void constructSkeleton() {
		System.out.println(skeletonType+" Skeleton of " + model+" is constructed.");
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
