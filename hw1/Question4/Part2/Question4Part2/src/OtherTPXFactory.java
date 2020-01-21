

/**
 * 
 * @author Burhan ELGUN
 * For respresenting TPX factory of other market
 *
 */
public class OtherTPXFactory extends TAI{
	/**
	 * it is for creating new other market TPX with a specific model
	 */
	@Override
	protected TPX createTpx(String type) {
		TPX tpx= null;

		switch(type) {
		  case "TPX100":
			  tpx=new TPX100(new OtherTPXFeatureFactory());
			  break;
		  case "TPX200":
			  tpx=new TPX200(new OtherTPXFeatureFactory());
			  break;
		  case "TPX300":
			  tpx=new TPX300(new OtherTPXFeatureFactory());
			  break;
		}
		

		return tpx;
	}
}
