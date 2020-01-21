
/**
 * 
 * @author Burhan ELGUN
 * 
 *This is an abstract class and it has only orderTpx method. 
 */
public abstract class TAI {
	
	/**
	 * This method is using for ordering a TPX
	 * @param type it is the TPX model 
	 * @return it returns the TPX with provided model in parameter.
	 */
	public TPX orderTpx(String type) {
		
		TPX tpx;
		
		tpx = createTpx(type);
		
		tpx.constructSkeleton();
		tpx.placeEngines();
		tpx.placeSeats();
		
		return tpx;
	}
	
	/**
	 * This is an abstract method for creating the new TPX
	 * @param type model of the TPX
	 * @return return the created TPX
	 */
	protected abstract TPX createTpx(String type);

}
