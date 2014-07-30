package Bubble;

public class BubbleSortTest {

	public static void main(String[] args) {
		
		Bubble.BubbleSort BubbleSort = new Bubble.BubbleSort();
			
			
			double[] ArrayToBeSorted = new double[100000];
			System.out.print("Working");
			long time1 = System.nanoTime();
			
			for (int i = 0; i < 100000; ++i) {
				ArrayToBeSorted[i] = Math.random();
				ArrayToBeSorted[i] = Math.random();
				BubbleSort.bubbleSort(ArrayToBeSorted);
				
				if ((i%100) == 0) {
					System.out.println(".");
				}
			}
			long elapsed = System.nanoTime() - time1;
			System.out.println(elapsed + "ns");
			System.out.println(elapsed/1000000000 + "s");
			System.out.println((elapsed/1000000000)/60 + "min");
			
			
			
		}

	}


