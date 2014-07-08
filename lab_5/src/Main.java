
public class Main {
static double[] ArrayToBeSorted; 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayToBeSorted = new double[10001];
		for(int i=0; i< 10000; i++){
			
			ArrayToBeSorted[i] = Math.random();
			MergeSort ms = new MergeSort();
			ms.sort(ArrayToBeSorted);
		}
		
		
		//ms.isSorted();
		

	}

}
