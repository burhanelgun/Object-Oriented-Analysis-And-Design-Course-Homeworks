

/**
 * This class represents the factory of the features of TPX for the domestic market 
 * @author Burhan ELGUN
 *
 */
public class DomesticTPXFeatureFactory implements TPXFeatureFactory {

	/**
	 * It creates engine injection type for domestic market
	 */
	@Override
	public EngineInjectionType createEngineInjectionType() {
		return new Turbojet();
	}
	
	/**
	 * It creates seating cover type for domestic market
	 */
	@Override
	public SeatingCover createSeatingCover() {
		return new Velvet();
	}

}
