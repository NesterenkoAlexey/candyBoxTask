
public class CandyBox implements Box {
	
	SuperCandy arrCandy[] = new SuperCandy[10]; // Примем максимум коробки 10 сладостей
	int priceBox;
	int weightBox;
	
	@Override
	public void add(SuperCandy sp) {
		for (int i = 0; i < arrCandy.length ; i++) {
			if (arrCandy[i] == null) {
				arrCandy[i] = sp;// добавление в коробку
				break; // Так как в самом начале массив будет состоять из null
			}
		}
	}

	@Override
	public void delete() { //Удаление по последнему
		for (int j = 0 ; j < arrCandy.length ; j++) {
			if (j == arrCandy.length - 1 || arrCandy[j+1] == null  ) {
				arrCandy[j] = null;
				break;
			}
		}
	} // и по индексу
	public void delete(int i) {
		while (i < arrCandy.length) {
			if (i == arrCandy.length - 1 || arrCandy[i+1] ==null) {
				arrCandy[i] = null;
				break;
			}
			else {
			arrCandy[i] = arrCandy[i + 1]; //Вместо удаления смещаем массив влево
			i++;
			}
		}
	}
	
	@Override
	public void printCharacteristics() { // Вывод веса и цены товаров
		priceBox = 0;
		weightBox = 0;
		for (int j = 0 ; j < arrCandy.length ; j++) {
			priceBox += arrCandy[j].price;
			weightBox += arrCandy[j].weight;		
			if (  j == arrCandy.length - 1 || arrCandy[j+1] == null) {
				break;
			}
		}

		System.out.println("Цена всех сладостей = " + priceBox);
		System.out.println("Вес всех сладостей = " + weightBox);
	}

	@Override
	public void printAllCandies() { // Вывод всех сладостей
		for (int j = 0 ; j < arrCandy.length ; j++) {
			System.out.println("№" + j + ": Название - " + arrCandy[j].name + ", Вес - " + arrCandy[j].weight + ", Цена - " + arrCandy[j].price + ", Уникальный параметр - " + arrCandy[j].uniqueParameter);
					
			if (  j == arrCandy.length - 1 || arrCandy[j+1] == null) {
				break;
			}
		}

	}
	//ОПТИМИЗАЦИЯ:
	
	@Override
	public void weightOptimization(int maxWeight) {
		weightBox = 0; //Считаем вес коробки
		
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
						indexMinWeight = j; //Нашли минимум
					}
					if (  j == arrCandy.length - 1 || arrCandy[j+1] == null) {
						break;
					}
				}
			}
			weightBox -= arrCandy[indexMinWeight].weight;
			int i = indexMinWeight; //Аналогично удаляем этот элемент
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
	
	
	@Override //Аналогично для цены
	public void priceOptimization(int maxPrice) {
		priceBox = 0; //Считаем стоимость коробки
		
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
					indexMinPrice = j; //Нашли минимум
				}
				if (  j == arrCandy.length - 1 || arrCandy[j+1] == null) {
					break;
				}
			}
			priceBox -= arrCandy[indexMinPrice].price;
			int i = indexMinPrice; //Аналогично удаляем этот элемент
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
