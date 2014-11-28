import java.math.BigInteger;
import java.util.*;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {
		while (scanner.hasNextLine()) {
			String temp[] = scanner.nextLine().split(" ");
			if (temp[0].equals("0") && temp[1].equals("0")) {
				break;
			}
			int N = Integer.parseInt(temp[0]);
			int M = Integer.parseInt(temp[1]);
			int c  = N-M;
			String k = Integer.toString(c);
			
            BigInteger a =judge(temp[0]);
            BigInteger b =judge(temp[1]);
            BigInteger z =judge(k).multiply(b);
			BigInteger result = a.divide(z);
			System.out.print(result+"\n");
			
		}

	}

	static BigInteger judge(String a) {
		
		BigInteger b = new BigInteger(a);
		BigInteger sum = new BigInteger("1");
		
		int count = Integer.parseInt(a);
		for (int i = 1; i <=count; i++) {
			
			String na = Integer.toString(i);
			BigInteger nana = new BigInteger(na);
			sum  = sum.multiply(nana);
		}
		return sum;
	}
}
