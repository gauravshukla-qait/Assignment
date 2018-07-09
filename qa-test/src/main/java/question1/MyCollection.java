package question1;

/**
 * Please implement Dynamic Array Interface 
 * @author 
 Gaurav SHukla
 *
 */
public class MyCollection implements DynamicArray{
// Uncomment commented section
	
	/**
	 * You can declare local/global variables as per your requirement
	 */
	int arraySize;
	private int[] tempArray;
	
	@SuppressWarnings("unused")
	private int[] numArray;
	/**
	 * It constructs an empty Collection object with an array capacity specified by the integer
		parameter "arraySize".
	 */
	public MyCollection(int arraySize){
		numArray = new int[arraySize];
		tempArray = new int[arraySize];
		this.arraySize = arraySize;
		
	}

	public int search(int searchingNum) {
		// TODO Auto-generated method stub
		if(arraySize > 0){
			for(int i = 0; i < arraySize; i++) {
				if(searchingNum == numArray[i])
					return i;
			}
		}
		return -1;
	}

	public boolean add(int numberToAdd) {
		// TODO Auto-generated method stub
		int searchResult = this.search(numberToAdd);
		if(searchResult < 0) {
			int count = this.getCount();
			if(count < arraySize) {
				numArray[count] = numberToAdd;
			}
			else {
				this.doubleCapacity();
				numArray[count] = numberToAdd;
			}
			return true;
		}
		return false;
	}

	public void doubleCapacity() {
		// TODO Auto-generated method stub
		for(int i = 0; i < arraySize; i++)
			tempArray[i] = numArray[i];
		arraySize *= 2;
		numArray = new int[arraySize];
		for(int i = 0; i < arraySize/2; i++)
			numArray[i] = tempArray[i];
		tempArray = new int[arraySize];
	}

	public boolean remove(int numberToRemove) {
		// TODO Auto-generated method stub
		int searchResult = this.search(numberToRemove);
		if(searchResult >= 0) {
			for(int i = searchResult; i < arraySize; i++)
				numArray[i] = numArray[i+1];
		numArray[arraySize-1] = 0;
		return true;
		}
		return false;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		int i = 0;
		while(i < arraySize) {
			if(numArray[i] == 0)
				break;
			i++;
		}
		return i;
	}

	public int[] rotate(int n) {
		// TODO Auto-generated method stub
		int count = getCount();
		int j = 0;
		for(int i = n; i < count; i++) {
			tempArray[j++] = numArray[i];
		}
		for(int i = 0; i < n; i++) {
			tempArray[j++] = numArray[i];
		}
		numArray = tempArray;
		return numArray;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "{";
		for(int i = 0; i < getCount()-1; i++) {
			s += numArray[i]+",";
		}
		s += numArray[getCount()-1] + "}";
		return s;
	}
	

}
