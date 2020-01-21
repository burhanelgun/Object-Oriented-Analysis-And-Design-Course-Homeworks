
public class Driver {
	
	public static void main(String[] args) {
		
		//Create a new Ora
		Suit suit = new Ora();
		System.out.println(suit.getDescription()+" => Total Price="+suit.cost()/1000.0+"k TL , Weight="+suit.weight()+" kg");
		
		//Create a new Tor
		Suit suit2 = new Tor();
		//add some equipment
		suit2= new FlameThrower(suit2);
		suit2= new Laser(suit2);
		suit2= new RocketLauncher(suit2);
		suit2= new AutoRifle(suit2);
		System.out.println(suit2.getDescription()+" => Total Price="+suit2.cost()/1000.0+"k TL , Weight="+suit2.weight()+" kg");
		
		
		//Create a new Dec
		Suit suit3 = new Dec();
		//add FlameThower
		suit3= new FlameThrower(suit3);
		System.out.println(suit3.getDescription()+" => Total Price="+suit3.cost()/1000.0+"k TL , Weight="+suit3.weight()+" kg");
		
	}

}
