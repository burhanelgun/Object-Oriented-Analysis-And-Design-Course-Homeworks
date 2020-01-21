
public class Driver {
		
	public static void main(String[] args) {
		 
		 BestDSEver bestDSEver = new BestDSEver();
		 
		 DS bestDSEverAdapter = new BestDSEverAdapter(bestDSEver);
		
		 System.out.println("BestDSEver works...");
		 bestDSEver.get(0);
		 bestDSEver.insert(new Object());
		 bestDSEver.remove(new Object());
		 System.out.println();

		 
		 System.out.println("BestDSEverAdapter works...");
		 testThreadSafeBestDSEver(bestDSEverAdapter);
		 

	}
	
	static void testThreadSafeBestDSEver(DS dS) {
		dS.get(0);
		dS.insert(new Object());
		dS.remove(new Object());
	}
}
