package mergeSort;

public class MergeSortTest {

	public static void main(String[] args) {
		
		mergeSort.MergeSort MergeSort = new mergeSort.MergeSort();
			
			double[] ArrayToBeSorted = new double[10000];
			
			long time1 = System.nanoTime();
			
			for (int i = 0; i < 10000; ++i) {
				ArrayToBeSorted[i] = Math.random();
				ArrayToBeSorted[i] = Math.random();
				MergeSort.sort(ArrayToBeSorted);
				
				if ((i%30) == 0) {
					System.out.println(".");
				}
			}
			long elapsed = System.nanoTime() - time1;
			System.out.println(elapsed);
			System.out.println(elapsed/1000000000 + "s");
			System.out.println((elapsed/1000000000)/60 + "min");
			
		}

	}


