import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class intValue {

	String result;
	private LinkedList<Integer> num2;
	private LinkedList<Integer> num1;
	private LinkedList<Integer> ans;
	private LinkedList<Integer> mul;
	private String temp;

	public void add(String s1, String s2) {

		num1 = new LinkedList<Integer>();
		num2 = new LinkedList<Integer>();
		ans = new LinkedList<Integer>();

		// store digits in list
		int l1 = s1.length(), l2 = s2.length();
		for (int i = l1 - 1; i >= 0; i--)
			num1.add(s1.charAt(i) - '0');
		for (int i = l2 - 1; i >= 0; i--)
			num2.add(s2.charAt(i) - '0');
		// Adding digits and storing in ans list
		int len = l1 > l2 ? l1 : l2;
		int carry = 0;
		for (int i = 0; i < len; i++) {
			int d1 = 0, d2 = 0;
			try {
				d1 = num1.get(i);
			} catch (Exception e) {
			}
			try {
				d2 = num2.get(i);
			} catch (Exception e) {
			}
			int x = d1 + d2 + carry;
			ans.add(x % 10);
			carry = x / 10;
		}
		// Adding carry
		while (carry != 0) {
			ans.add(carry % 10);
			carry /= 10;
		}
		 //Printing ans list
		 System.out.print("\nSum = ");
		 for (int i = ans.size() - 1; i >= 0; i--)
		 System.out.print(ans.get(i));
		 System.out.println();
		
		//
	}

	public String listToString(LinkedList<Integer> array, String delimiter) {
		StringBuilder arTostr = new StringBuilder();
		if (array.size() > 0) {
			arTostr.append(array.get(0));
			for (int i = 1; i < array.size(); i++) {
				arTostr.append(delimiter);
				arTostr.append(array.get(i));
			}
		}
		return arTostr.reverse().toString();
	}

	public  String multiply(String s1, String s2) {

		int product, carry = 0, sum = 0;
		String result = new String("");
		String partial = new String("");
		ArrayList<String> partialList = new ArrayList<String>();

		// computing partial products using this loop.
		for (int j = s2.length() - 1; j >= 0; j--) {
			for (int i = s1.length() - 1; i >= 0; i--) {

				product = Integer.parseInt((new Character(s1.charAt(i)))
						.toString())
						* Integer.parseInt((new Character(s2.charAt(j)))
								.toString()) + carry;
				carry = product / 10;
				partial = Integer.toString(product % 10) + partial;
			}

			if (carry != 0)
				partial = Integer.toString(carry) + partial;

			partialList.add(partial);
			partial = "";
			carry = 0;
		}

		// appending zeroes incrementally
		for (int i = 0; i < partialList.size(); i++)
			partialList.set(
					i,
					partialList.get(i)
							+ (Long.toString((long) java.lang.Math.pow(10.0,
									(double) i))).substring(1));
		// getting the size of the largest partial product(last) 
		int largestPartial = partialList.get(partialList.size() - 1).length();

		// prefixing zeroes
		int zeroes;
		for (int i = 0; i < partialList.size(); i++) {
			zeroes = largestPartial - partialList.get(i).length();

			if (zeroes >= 1)
				partialList.set(
						i,
						(Long.toString((long) java.lang.Math.pow(10.0,
								(double) zeroes))).substring(1)
								+ partialList.get(i));
		}

		// to compute the result 
		carry = 0;
		for (int i = largestPartial - 1; i >= 0; i--) {

			sum = 0;
			for (int j = 0; j < partialList.size(); j++)
				sum = sum
						+ Integer.parseInt(new Character(partialList.get(j)
								.charAt(i)).toString());

			sum = sum + carry;
			carry = sum / 10;
			result = Integer.toString(sum % 10) + result;
		}

		if (carry != 0)
			result = Integer.toString(carry) + result;
System.out.println(result);
		return result;
		
	}
	
	public void pow(String s1, Long n){
		int l1 = s1.length();
		String result;
		result = s1;
		for(int i=0; i<n-1;i++){
			result = multiply(s1, result);
			
		}
		System.out.println(result);
	}

}
