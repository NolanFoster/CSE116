import java.util.*;

public class lab02 {

	public static void main(String[] args) {
		System.out.println("Usage: enter a, b & c from a quadratic equation.");
		System.out.println("       aX^ + bX + c = 0");
		System.out.println("       Result will be 2 values for X");
		Scanner in = new Scanner(System.in);
		boolean continueinput = true;
		
while(continueinput){
		//try {
			
		
		double a = 0, b=0, c=0, x1=0, x2=0, discriminant = 0;
		

		System.out.println("Please enter values for a, b and c ");
		System.out.print("a = ");
			
			try{	
				a = in.nextDouble();
			}catch(InputMismatchException ex){
				System.out.println("The number you entered is a non-numeric value");

				//continueinput = true;
			}
			System.out.print("b = ");
			if(b==0.){
			b = in.nextDouble();
			}
			System.out.print("c = ");
			if(c==0.){
			c = in.nextDouble();
			
			}
			continueinput=false;
			// x1 = (-b + sqrt(b*b - 4ac)/2a
			// x2 = (-b-sqrt(b*b - 4ac)/2a

			discriminant = b * b - 4.0 * a * c;
			x1 = (-b + Math.sqrt(discriminant)) / 2.0 * a;
			x2 = (-b - Math.sqrt(discriminant)) / 2.0 * a;

			System.out.println("The two values for X are " + x1 + " and " + x2);
			
			return;
			
//		} catch (InputMismatchException ex) {
//			System.out.println("The number you entered is a non-numeric value");
//
//			//continueinput = true;
//
//		}
		}
	}

}
