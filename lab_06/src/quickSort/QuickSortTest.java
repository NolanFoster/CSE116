package quickSort;

public class QuickSortTest {

	public static void main(String[] args) {
		
		quickSort.QuickSort quicksort = new quickSort.QuickSort();
			
			
			double[] ArrayToBeSorted = new double[100000];
			
			long time1 = System.nanoTime();
			
			for (int i = 0; i < 1000000; ++i) {
				ArrayToBeSorted[i] = Math.random();
				ArrayToBeSorted[i] = Math.random();
				quicksort.quicksort(ArrayToBeSorted);
				
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


