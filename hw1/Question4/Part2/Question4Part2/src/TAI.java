/**
 * 
 * @author Burhan ELGUN
 * 
 *This is an abstract class and it has orderTpx and createTpx methods. 
 */
public abstract class TAI {
	
	public TPX orderTpx(String type) {
		TPX tpx;
		
		tpx = createTpx(type);
		
		tpx.constructSkeleton();
		tpx.placeEngines();
		tpx.placeSeats();
		
		return tpx;
	}
	
	protected abstract TPX createTpx(String type);

}
