/**
 * This class is for representing a TPX 300 model and it is inherited from TPX abstract class.
 * @author Burhan ELGUN
 *
 */
public class TPX300 extends TPX{
	TPXFeatureFactory featureFactory;
	
	/**
	 * TPX300 has a feturefactory for representing the features of the TPX300
	 */
	public TPX300(TPXFeatureFactory featureFactory) {
		this.featureFactory=featureFactory;
		model="TPX300";
		purpose="Transatlantic flights.";
		skeletonType="Titanium alloy";
	}

	/**
	 * it creates the engine injection type and set it after that it places the engines
	 */
	@Override
	public void placeEngines() {
		engineInjectionType=featureFactory.createEngineInjectionType();
		engineType="Quadro jet engines";
		System.out.println(engineType+"("+engineInjectionType.getClass().getName()+ ") of " + model+" is placed.");

	}

	/**
	 * it creates the seating cover and set it after that it places the seats
	 */
	@Override
	public void placeSeats() {
		seatingCover=featureFactory.createSeatingCover();
		numberOfSeating=250;
		System.out.println(numberOfSeating+" seats("+seatingCover.getClass().getName()+ ") of " + model+" is placed.");

	}
	

}
