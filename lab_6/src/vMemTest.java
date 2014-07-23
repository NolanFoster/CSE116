import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Random;

public class vMemTest {

	private final static int ARRAYSIZE = 1000;
	private final static int VIRTRATIO = 100;

	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime();
		orderedTest ot = new orderedTest();
		// make an array of ARRAYSIZE elements
		vMem array = new vMem(ARRAYSIZE, ARRAYSIZE/VIRTRATIO);
		
		Random random = new Random();
		
		int index;
		long value;
		long gotten = 0;
		
		for(int i = 0; i<ARRAYSIZE; ++i){
			//System.out.println((i/100000)+" %");
			//index = 100;
			index = random.nextInt(ARRAYSIZE);
			value = random.nextLong();
			
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
		System.out.println("Total elapsed time (millisec) is " + (endTime -startTime)/1000000);
		
		System.out.println("Test complete");
		

	}
}
