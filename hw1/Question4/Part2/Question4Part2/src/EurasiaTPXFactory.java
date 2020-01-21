
/**
 * 
 * @author Burhan ELGUN
 * For respresenting TPX factory of eurasia market
 *
 */
public class EurasiaTPXFactory extends TAI{
	/**
	 * it is for creating new eurasia market TPX with a specific model
	 */
	@Override
	protected TPX createTpx(String type) {
		TPX tpx= null;

		switch(type) {
		  case "TPX100":
			  tpx=new TPX100(new EurasiaTPXFeatureFactory());
			  break;
		  case "TPX200":
			  tpx=new TPX200(new EurasiaTPXFeatureFactory());
			  break;
		  case "TPX300":
			  tpx=new TPX300(new EurasiaTPXFeatureFactory());
			  break;
		}
		

		return tpx;
	}

}
