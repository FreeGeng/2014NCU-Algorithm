import java.util.*;
import java.math.*;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	static int a;
	static int b;

	public static void main(String args[]) {
		while (scanner.hasNext()) {
			BigInteger bi1, bi2, bi3, bi4;
			bi1 = new BigInteger("2");
			String temp = scanner.nextLine();
			String temp2[] = temp.split(" ");
			a = Integer.parseInt(temp2[0]);
			b = Integer.parseInt(temp2[1]);

			bi2 = bi1.pow(a);
			bi3 = bi1.pow(b);
			bi4 = bi2.add(bi3);
			System.out.print(bi4);
			System.out.println();
		}
	}

}