import javax.swing.JOptionPane;


public class fact {
private static String input;
	/**
	 * @param args
	 */
private static long num;
	public static void main(String[] args) {
		System.out.println("Started...");
		input = JOptionPane.showInputDialog(null,
				"enter a factorial");
		num = Long.parseLong(input);
	    JOptionPane.showMessageDialog(null, "The Answer is "+ factorial(num));
	}

	public static long factorial (long n){
		long ans=1;
		
		if(n>1){
			return n * factorial (n-1);
		}
		return(1);
			}
	
}
