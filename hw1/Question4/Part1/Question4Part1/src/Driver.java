
public class Driver {

	public static void main(String[] args) {
		
		//Create a new TPXFactory
		TAI tpxFactory = new TPXFactory();
		
		//Order a TPX100
		TPX tpx100 = tpxFactory.orderTpx("TPX100");
		System.out.println("Created a "+ tpx100.getModel() +". Its purpose is "+tpx100.getPurpose()+
				" Skeleton:"+tpx100.getSkeletonType()+
				". Engine:"+tpx100.getEngineType()+
				". Number of seats:"+tpx100.getNumberOfSeating()+"\n");
		
		//Order a TPX200
		TPX tpx200 = tpxFactory.orderTpx("TPX200");
		System.out.println("Created a "+ tpx200.getModel() +". Its purpose is "+tpx200.getPurpose()+
				" Skeleton:"+tpx200.getSkeletonType()+
				". Engine:"+tpx200.getEngineType()+
				". Number of seats:"+tpx200.getNumberOfSeating()+"\n");

		//Order a TPX300
		TPX tpx300 = tpxFactory.orderTpx("TPX300");
		System.out.println("Created a "+ tpx300.getModel() +". Its purpose is "+tpx300.getPurpose()+
				" Skeleton:"+tpx300.getSkeletonType()+
				". Engine:"+tpx300.getEngineType()+
				". Number of seats:"+tpx300.getNumberOfSeating()+"\n");

	}

}
