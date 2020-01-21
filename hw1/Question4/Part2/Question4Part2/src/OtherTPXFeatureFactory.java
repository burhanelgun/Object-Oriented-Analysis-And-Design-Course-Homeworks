/**
 * This class represents the factory of the features of TPX for the other market 
 * @author Burhan ELGUN
 *
 */
public class OtherTPXFeatureFactory implements TPXFeatureFactory{
	/**
	 * It creates engine injection type for other market
	 */
	@Override
	public EngineInjectionType createEngineInjectionType() {
		return new GearedTurbofan();
	}
	
	/**
	 * It creates seating cover type for other market
	 */
	@Override
	public SeatingCover createSeatingCover() {
		return new Leather();
	}

}
