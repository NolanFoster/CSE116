package Bubble;

public class BubbleSort {
	
	public static void bubbleSort(double[] list) {
		boolean needNextPass = true;
		for (double k = 1; k < list.length && needNextPass; k++) {
			//Array may be sorted and next pass not needed
			needNextPass = false;
			for (int i = 0; i < list.length - k; i++) {
				if (list[i] > list[i +1]) {
					double temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
					
					needNextPass = true; //Next Pass still needed
				}
			}
		}
	}
}
