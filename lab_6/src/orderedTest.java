import java.io.IOException;
import java.util.Random;


public class orderedTest {
	private final static int ARRAYSIZE = 1000;
	private final static int VIRTRATIO = 100;
	public orderedTest() throws IOException{
		vMem array = new vMem(ARRAYSIZE, ARRAYSIZE/VIRTRATIO);
		
		Random random = new Random();
		
		int index;
		long value;
		long gotten = 0;
		long startTime = System.nanoTime();
	
		for(int i = 0; i<ARRAYSIZE; ++i){
			//if((i/100)!=(i-1System.out.println((i/100)+" %");
			index = i;
			value = 1000-i;
			
			try{
				array.put(index, value);
				gotten = array.get(index);
			}catch(IndexOutOfBoundsException e){
				long upper = ARRAYSIZE - 1;
				System.out.println("The value " + index + " is outside 0.." + upper);
			}
			
			//check for error
			if(gotten != value){
				System.out.println("error at "+ i);
				return;
			}
		}
		long endTime = System.nanoTime();
		System.out.println("Adding Ordered Numbers: Elapsed time (millisec) is " + (endTime -startTime)/1000000);
		//System.out.println("Test 2 Decending order");
		boolean  ret = true;
		System.out.print("Testing order...");
		for (int b = 0; b < ARRAYSIZE-1; b++) {
			if((b/100)!= (b-1)/100){
				
			System.out.print(".");
			
			}
			
			if (array.get(b) > array.get(b+1)) {
				ret = true;
			} else {
				ret = false;
				System.out.println("The List is not sorted");
				return;
				
			}
			}
		if (ret == true) {
			System.out.println("The List is sorted");
			
		}
	

	}
	

}
