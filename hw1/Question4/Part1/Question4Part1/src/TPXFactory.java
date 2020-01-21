/**
 * 
 * @author Burhan ELGUN
 *
 *Factory of the TPX 
 */
public class TPXFactory extends TAI {
	/**
	 * it creates the TPX with given model
	 */
	@Override
	protected TPX createTpx(String type) {
		TPX tpx= null;

		
		switch(type) {
		  case "TPX100":
			  tpx=new TPX100();
			  break;
		  case "TPX200":
			  tpx=new TPX200();
			  break;
		  case "TPX300":
			  tpx=new TPX300();
			  break;
		}
		

		return tpx;
		
	}

}
