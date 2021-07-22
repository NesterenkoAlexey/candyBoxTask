
public class CandyBox implements Box {
	
	SuperCandy arrCandy[] = new SuperCandy[10]; // Max boxes - 10
	int priceBox;
	int weightBox;
	
	@Override
	public void add(SuperCandy sp) {
		for (int i = 0; i < arrCandy.length ; i++) {
			if (arrCandy[i] == null) {
				arrCandy[i] = sp;// Added box
				break; // 
			}
		}
	}

	@Override
	public void delete() { //Last delete
		for (int j = 0 ; j < arrCandy.length ; j++) {
			if (j == arrCandy.length - 1 || arrCandy[j+1] == null  ) {
				arrCandy[j] = null;
				break;
			}
		}
	} // è ïî èíäåêñó
	public void delete(int i) {
		while (i < arrCandy.length) {
			if (i == arrCandy.length - 1 || arrCandy[i+1] ==null) {
				arrCandy[i] = null;
				break;
			}
			else {
			arrCandy[i] = arrCandy[i + 1]; //Instead of deleting, we shift the array to the left
			i++;
			}
		}
	}
	
	@Override
	public void printCharacteristics() { // Print price and weight
		priceBox = 0;
		weightBox = 0;
		for (int j = 0 ; j < arrCandy.length ; j++) {
			priceBox += arrCandy[j].price;
			weightBox += arrCandy[j].weight;		
			if (  j == arrCandy.length - 1 || arrCandy[j+1] == null) {
				break;
			}
		}

		System.out.println("Candies price = " + priceBox);
		System.out.println("Candies weight = " + weightBox);
	}

	@Override
	public void printAllCandies() { // Print all candies
		for (int j = 0 ; j < arrCandy.length ; j++) {
			System.out.println("¹" + j + ": Name - " + arrCandy[j].name + ", Weight - " + arrCandy[j].weight + ", Price - " + arrCandy[j].price + ", UniqueParameter - " + arrCandy[j].uniqueParameter);
					
			if (  j == arrCandy.length - 1 || arrCandy[j+1] == null) {
				break;
			}
		}

	}
	//ÎÏÒÈÌÈÇÀÖÈß:
	
	@Override
	public void weightOptimization(int maxWeight) {
		weightBox = 0; //Calculete box weight
		
		int indexMinWeight = 0;
		
		for (int j = 0 ; j < arrCandy.length ; j++) {
			weightBox += arrCandy[j].weight;
			
			if (  j == arrCandy.length - 1 || arrCandy[j+1] == null) {
				break;
			}
		}
		while (weightBox > maxWeight) {
			indexMinWeight = 0;
			if (arrCandy[1] != null) {
				for (int j = 1 ; j < arrCandy.length ; j++) {
					if (arrCandy[indexMinWeight].weight > arrCandy[j].weight) {
						indexMinWeight = j; //Fiend weight
					}
					if (  j == arrCandy.length - 1 || arrCandy[j+1] == null) {
						break;
					}
				}
			}
			weightBox -= arrCandy[indexMinWeight].weight;
			int i = indexMinWeight; //Delete this element
			while (i < arrCandy.length) {
				if (i == arrCandy.length - 1 || arrCandy[i+1] ==null) {
					arrCandy[i] = null;
					break;
				}
				else {
				arrCandy[i] = arrCandy[i + 1];
				i++;
					
				}
			}
		
		}
	}	
	
	
	@Override //Likewise for the price
	public void priceOptimization(int maxPrice) {
		priceBox = 0; 
		
		int indexMinPrice = 0;
		
		for (int j = 0 ; j < arrCandy.length ; j++) {
			priceBox += arrCandy[j].price;
			
			if (  j == arrCandy.length - 1 || arrCandy[j+1] == null) {
				break;
			}
		}
		while (priceBox > maxPrice) {
			indexMinPrice = 0;
			for (int j = 1 ; j < arrCandy.length ; j++) {
				if (arrCandy[indexMinPrice].price > arrCandy[j].price) {
					indexMinPrice = j; 
				}
				if (  j == arrCandy.length - 1 || arrCandy[j+1] == null) {
					break;
				}
			}
			priceBox -= arrCandy[indexMinPrice].price;
			int i = indexMinPrice; 
			while (i < arrCandy.length) {
				if (i == arrCandy.length - 1 || arrCandy[i+1] ==null) {
					arrCandy[i] = null;
					break;
				}
				else {
				arrCandy[i] = arrCandy[i + 1];
				i++;
					
				}
			}
		
		}
	}
	
}
