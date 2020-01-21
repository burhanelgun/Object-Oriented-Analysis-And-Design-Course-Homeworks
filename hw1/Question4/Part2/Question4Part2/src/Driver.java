

public class Driver {

	public static void main(String[] args) {
		
		//Create DomecticTPXFactory
		TAI domesticTPXFactory = new DomesticTPXFactory();
		
		//order TPX 100 for Domestic market
		TPX tpx100 = domesticTPXFactory.orderTpx("TPX100");
		System.out.println("Created a "+ tpx100.getModel() +". Its purpose is "+tpx100.getPurpose()+
				" Skeleton:"+tpx100.getSkeletonType()+
				". Engine:"+tpx100.getEngineType()+
				". Number of seats:"+tpx100.getNumberOfSeating()+
				". Market: Domestic\n");
		
		
		
		//Create EurasiaTPXFactory
		TAI eurasiaTPXFactory = new EurasiaTPXFactory();

		//order TPX 200 for Eurasia market
		TPX tpx200 = eurasiaTPXFactory.orderTpx("TPX200");
		System.out.println("Created a "+ tpx200.getModel() +". Its purpose is "+tpx200.getPurpose()+
				" Skeleton:"+tpx200.getSkeletonType()+
				". Engine:"+tpx200.getEngineType()+
				". Number of seats:"+tpx200.getNumberOfSeating()+
				". Market: Eurasia\n");

		
		
		//Create OtherTPXFactory
		TAI otherTPXFactory = new OtherTPXFactory();

		//order TPX 300 for Other market
		TPX tpx300 = otherTPXFactory.orderTpx("TPX300");
		System.out.println("Created a "+ tpx300.getModel() +". Its purpose is "+tpx300.getPurpose()+
				" Skeleton:"+tpx300.getSkeletonType()+
				". Engine:"+tpx300.getEngineType()+
				". Number of seats:"+tpx300.getNumberOfSeating()+
				". Market: Other\n");
		
		
		
	}

}
