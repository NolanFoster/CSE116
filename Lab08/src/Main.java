import java.util.*;
 
public class Main
{
    public static void main(String[] args)
    {    
    	 Scanner scan = new Scanner(System.in);
    	 intValue eq = new intValue();
    	 System.out.println("Add(1), Multiply(2), pow(3)");
    	 	String s0 =scan.next();
    	 	
    	 	if(Integer.parseInt(s0)==1){
    	// System.out.println("Large Numbers Using Linked Lists Test\n");
	        System.out.println("Enter number 1");
	        String s1 = scan.next();
	        System.out.println("Enter number 2");
	        String s2 = scan.next(); 
	        eq.add(s1,s2);
    	 	}
    		if(Integer.parseInt(s0)==2){
    	    	// System.out.println("Large Numbers Using Linked Lists Test\n");
    		        System.out.println("Enter number 1");
    		        String s1 = scan.next();
    		        System.out.println("Enter number 2");
    		        String s2 = scan.next(); 
    		        eq.multiply(s1,s2);
    	    	 	}
    	 	
    		if(Integer.parseInt(s0)==3){
    	    	// System.out.println("Large Numbers Using Linked Lists Test\n");
    		        System.out.println("Enter number 1");
    		        String s1 = scan.next();
    		        System.out.println("Enter number 2");
    		        String s2 = scan.next(); 
    		        Long num = Long.parseLong(s2);
    		        eq.pow(s1,num);
    	    	 	} 	 	

	        
	        
	     
	        
    }
}
