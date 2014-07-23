import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Random;

public class Driver {


	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime();
		vMemTest ot = new vMemTest();
		long endTime = System.nanoTime();
		
		System.out.println("Total elapsed time (millisec) is " + (endTime -startTime)/1000000);
		
		System.out.println("Test complete");
		

	}
}
