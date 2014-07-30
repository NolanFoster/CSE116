package Insertion;

public class InsertionSortTest {

	public static void main(String[] args) {
		
		Insertion.InsertionSort Insertion = new Insertion.InsertionSort();
			
			
			double[] ArrayToBeSorted = new double[1000000];
			
			long time1 = System.nanoTime();
			
			for (int i = 0; i < 1000000; ++i) {
				ArrayToBeSorted[i] = Math.random();
				ArrayToBeSorted[i] = Math.random();
				Insertion.insertionSort(ArrayToBeSorted);
				
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


