
/**
 * This class is for representing a TPX 100 model and it is inherited from TPX abstract class.
 * @author Burhan ELGUN
 *
 */
public class TPX100 extends TPX {
	
	/**
	 * TPX100 has a feturefactory for representing the features of the TPX100
	 */
	TPXFeatureFactory featureFactory;

	public TPX100(TPXFeatureFactory featureFactory) {
		this.featureFactory=featureFactory;
		model="TPX100";
		purpose="Domestic flights.";
		skeletonType="Aluminum alloy";
	}
	
	/**
	 * it creates the engine injection type and set it after that it places the engines
	 */
	@Override
	public void placeEngines() {
		engineInjectionType=featureFactory.createEngineInjectionType();
		engineType="Single jet engine";
		System.out.println(engineType+"("+engineInjectionType.getClass().getName()+ ") of " + model+" is placed.");


	}

	/**
	 * it creates the seating cover and set it after that it places the seats
	 */
	@Override
	public void placeSeats() {
		seatingCover=featureFactory.createSeatingCover();
		numberOfSeating=50;
		System.out.println(numberOfSeating+" seats("+seatingCover.getClass().getName()+ ") of " + model+" is placed.");

	}



}
