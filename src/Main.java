
public class Main {

	public static void main(String[] args) {
		
		CandyBox cb = new CandyBox();
		cb.add(new Snickers()); 
		cb.add(new Toffifee());
		cb.add(new AlpenGold());
		cb.add(new Toffifee());
		cb.add(new Snickers());
		cb.add(new AlpenGold()); 
		
		cb.printAllCandies();
		cb.printCharacteristics();
		
		cb.priceOptimization(500);
		
		cb.printAllCandies();
		cb.printCharacteristics();
		
		System.out.println("111");
	}

}
