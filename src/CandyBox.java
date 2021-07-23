import java.util.List;
import java.util.ArrayList;

public class CandyBox implements Box {
	
	List<SuperCandy> listCandy = new ArrayList(); // Use List
	int priceBox;
	int weightBox;
	
	@Override
	public void add(SuperCandy sp) {
		listCandy.add(sp);
	}

	@Override
	public void delete() { //Last delete
		listCandy.remove(listCandy.size() - 1);
	} 
	public void delete(int i) {
		listCandy.remove(i);
	}
	
	@Override
	public void printCharacteristics() { // Print weight and price
		priceBox = 0;
		weightBox = 0;
		for (SuperCandy sp : listCandy) {
			priceBox += sp.price;
			weightBox += sp.weight;		
		}

		System.out.println("Цена всех сладостей = " + priceBox);
		System.out.println("Вес всех сладостей = " + weightBox);
	}

	@Override
	public void printAllCandies() { // Print all Candies
		int j = 0;
		for (SuperCandy sp : listCandy) {
			System.out.println("№" + j + ": Name - " + sp.name + ", Weight - " + sp.weight + ", Price - " + sp.price + ", Uniqparam - " + sp.uniqueParameter);
			j++;		
		}

	}
	//Optimization:
	
	@Override
	public void weightOptimization(int maxWeight) {
		weightBox = 0; //Calculate weight
		
		int indexMinWeight = 0;
		int minWeight = 0;
		int flag = 0;
		
		for (SuperCandy sp : listCandy) {
			weightBox += sp.weight;		
		}
		
		while (weightBox > maxWeight) {
			indexMinWeight = 0;
			minWeight = 99999999;
			flag = 0;
			for(SuperCandy sp : listCandy) {
				if (minWeight > sp.weight) {
					indexMinWeight = flag; //Find min
					minWeight = sp.weight;
				}
				flag++;
			}
			listCandy.remove(indexMinWeight); //delete this element
			weightBox -= minWeight;
		
		}
	}	
	
	
	@Override //For price
	public void priceOptimization(int maxPrice) {
		priceBox = 0; //Calculate price
		
		int indexMinPrice = 0;
		int minPrice = 0;
		int flag = 0;
		
		for (SuperCandy sp : listCandy) {
			priceBox += sp.price;		
		}
		
		while (priceBox > maxPrice) {
			indexMinPrice = 0;
			minPrice = 99999999;
			flag = 0;
			for(SuperCandy sp : listCandy) {
				if (minPrice > sp.price) {
					indexMinPrice = flag; //Find min
					minPrice = sp.price;
				}
				flag++;
			}
			listCandy.remove(indexMinPrice); //delete this element
			priceBox -= minPrice; 
		
		}
	}
	
}
