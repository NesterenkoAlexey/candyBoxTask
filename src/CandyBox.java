
public class CandyBox implements Box {
	
	SuperCandy arrCandy[] = new SuperCandy[10]; // ������ �������� ������� 10 ���������
	int priceBox;
	int weightBox;
	
	@Override
	public void add(SuperCandy sp) {
		for (int i = 0; i < arrCandy.length ; i++) {
			if (arrCandy[i] == null) {
				arrCandy[i] = sp;// ���������� � �������
				break; // ��� ��� � ����� ������ ������ ����� �������� �� null
			}
		}
	}

	@Override
	public void delete() { //�������� �� ����������
		for (int j = 0 ; j < arrCandy.length ; j++) {
			if (j == arrCandy.length - 1 || arrCandy[j+1] == null  ) {
				arrCandy[j] = null;
				break;
			}
		}
	} // � �� �������
	public void delete(int i) {
		while (i < arrCandy.length) {
			if (i == arrCandy.length - 1 || arrCandy[i+1] ==null) {
				arrCandy[i] = null;
				break;
			}
			else {
			arrCandy[i] = arrCandy[i + 1]; //������ �������� ������� ������ �����
			i++;
			}
		}
	}
	
	@Override
	public void printCharacteristics() { // ����� ���� � ���� �������
		priceBox = 0;
		weightBox = 0;
		for (int j = 0 ; j < arrCandy.length ; j++) {
			priceBox += arrCandy[j].price;
			weightBox += arrCandy[j].weight;		
			if (  j == arrCandy.length - 1 || arrCandy[j+1] == null) {
				break;
			}
		}

		System.out.println("���� ���� ��������� = " + priceBox);
		System.out.println("��� ���� ��������� = " + weightBox);
	}

	@Override
	public void printAllCandies() { // ����� ���� ���������
		for (int j = 0 ; j < arrCandy.length ; j++) {
			System.out.println("�" + j + ": �������� - " + arrCandy[j].name + ", ��� - " + arrCandy[j].weight + ", ���� - " + arrCandy[j].price + ", ���������� �������� - " + arrCandy[j].uniqueParameter);
					
			if (  j == arrCandy.length - 1 || arrCandy[j+1] == null) {
				break;
			}
		}

	}
	//�����������:
	
	@Override
	public void weightOptimization(int maxWeight) {
		weightBox = 0; //������� ��� �������
		
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
						indexMinWeight = j; //����� �������
					}
					if (  j == arrCandy.length - 1 || arrCandy[j+1] == null) {
						break;
					}
				}
			}
			weightBox -= arrCandy[indexMinWeight].weight;
			int i = indexMinWeight; //���������� ������� ���� �������
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
	
	
	@Override //���������� ��� ����
	public void priceOptimization(int maxPrice) {
		priceBox = 0; //������� ��������� �������
		
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
					indexMinPrice = j; //����� �������
				}
				if (  j == arrCandy.length - 1 || arrCandy[j+1] == null) {
					break;
				}
			}
			priceBox -= arrCandy[indexMinPrice].price;
			int i = indexMinPrice; //���������� ������� ���� �������
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
