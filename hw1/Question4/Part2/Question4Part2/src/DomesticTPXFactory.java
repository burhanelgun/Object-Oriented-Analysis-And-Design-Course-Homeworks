
/**
 * 
 * @author Burhan ELGUN
 * For respresenting TPX factory of domestic market
 *
 */
public class DomesticTPXFactory extends TAI {
	
	/**
	 * it is for creating new domestic market TPX with a specific model
	 */
	@Override
	protected TPX createTpx(String type) {
		TPX tpx= null;

		
		switch(type) {
		  case "TPX100":
			  tpx=new TPX100(new DomesticTPXFeatureFactory());
			  break;
		  case "TPX200":
			  tpx=new TPX200(new DomesticTPXFeatureFactory());
			  break;
		  case "TPX300":
			  tpx=new TPX300(new DomesticTPXFeatureFactory());
			  break;
		}
		

		return tpx;
		
	}
}
