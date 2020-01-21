/**
 * This class represents the factory of the features of TPX for the eurasia market 
 * @author Burhan ELGUN
 *
 */
public class EurasiaTPXFeatureFactory implements TPXFeatureFactory{
	/**
	 * It creates engine injection type for eurasia market
	 */
	@Override
	public EngineInjectionType createEngineInjectionType() {
			return new Turbofan();
	}

	
	/**
	 * It creates seating cover type for eurasia market
	 */
	@Override
	public SeatingCover createSeatingCover() {
		return new Linen();
	}

}



