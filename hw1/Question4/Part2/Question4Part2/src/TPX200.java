/**
 * This class is for representing a TPX 200 model and it is inherited from TPX abstract class.
 * @author Burhan ELGUN
 *
 */
public class TPX200 extends TPX {
	TPXFeatureFactory featureFactory;

	/**
	 * TPX200 has a feturefactory for representing the features of the TPX200
	 */
	public TPX200(TPXFeatureFactory featureFactory) {
		this.featureFactory=featureFactory;
		model="TPX200";
		purpose="Domestic and short international flights.";
		skeletonType="Nickel alloy";
	}
	
	/**
	 * it creates the engine injection type and set it after that it places the engines
	 */
	@Override
	public void placeEngines() {
		engineInjectionType=featureFactory.createEngineInjectionType();
		engineType="Twin jet engines";
		System.out.println(engineType+"("+engineInjectionType.getClass().getName()+ ") of " + model+" is placed.");

	}

	/**
	 * it creates the seating cover and set it after that it places the seats
	 */
	@Override
	public void placeSeats() {
		seatingCover=featureFactory.createSeatingCover();
		numberOfSeating=100;
		System.out.println(numberOfSeating+" seats("+seatingCover.getClass().getName()+ ") of " + model+" is placed.");

	}


}
