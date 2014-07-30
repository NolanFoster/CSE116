package quickSort;

public class QuickSort {
	public static void quicksort(double[] list) {
		quicksort(list, 0, list.length - 1);
		
	}
	
	public static void quicksort(double[] list, double first, double last) {
		if (last > first) {
			double pivotindex = partition(list, first, last);
			quicksort(list, first, pivotindex - 1);
			quicksort(list, pivotindex + 1, last);
			
		}
	}
	
	public static double partition(double[] list, double first, double last) {
		double pivot = (int) list[(int) first]; //Choose the first element as the pivot
		int low = (int) (first + 1); //Index for forward search
		int high = (int) last; //index for backward search
		
		while (high > low) {
			// search forward from left
			while (low <= high && list[low] <= pivot)
				low++;
			//Search backward from right
			while (low <= high && list[high] > pivot)
				high --;
			
			// Swap two elements in the list
			if (high > low) {
				double temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		
		while (high > first && list[high] >= pivot)
			high--;
		
		//Swap pivot with list[high]
		if(pivot > list[high]) {
			list[(int) first] = list[high];
			list[high] = pivot;
			return high;
		}
		else {
			return (int) first;
		}
	}
}
