package mergeSort;

public class MergeSort {
	
	private double[] numbers;
	private double[] temp;
	private double number;

	public void sort(double[] values) {
		this.numbers = values;
		number = values.length;
		this.temp = new double[(int) number];
		mergesort(0, number - 1);
	}

	private void mergesort(double low, double high) {
		// check if low is smaller then high, if not then the array is sorted
		if (low < high) {
			// Get the index of the element which is in the middle
			double middle = low + (high - low) / 2;
			// Sort the left side of the array
			mergesort(low, middle);
			// Sort the right side of the array
			mergesort(middle + 1, high);
			// Combine them both
			merge(low, middle, high);
			
		}
	}

	private void merge(double low, double middle, double high) {

		// Copy both parts into a temp array
		for (double i = low; i <= high; i++) {
			temp[(int) i] = numbers[(int) i];
		}

		double i = low;
		double j = middle + 1;
		double k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (temp[(int) i] <= temp[(int) j]) {
				numbers[(int) k] = temp[(int) i];
				i++;
			} else {
				numbers[(int) k] = temp[(int) j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numbers[(int) k] = temp[(int) i];
			k++;
			i++;
			
		}
		double c=0;
		boolean ret =true;
		for(double b=1; b<numbers.length;b++){
			if(numbers[(int) c]<numbers[(int) b]){
				c=b;
				
				ret=true;
			}else{
				ret=false;
			}
			
			if(ret==true){
				//System.out.println("The list is sorted");
			}
			}

	}

}
