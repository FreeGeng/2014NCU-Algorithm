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
			int S = Integer.parseInt(temp[1]);
			int price[];
			price = new int[N];
			String temp1[] = scanner.nextLine().split(" ");
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(temp1[i]);
			}
			Arrays.sort(price);
			change(S, price);
		}
	}

	static void change(int m, int[] price) {
		int c[] = new int[m + 1];
		for (int i = 1; i < c.length; i++) {
			c[i] = Integer.MAX_VALUE-1;
		}
		c[0] = 0;

		for (int i = 0; i < price.length; i++) {
			for (int j = price[i]; j <= m; ++j) {

				c[j] = min(c[j], c[j - price[i]] + 1);

			}
		}
		

		System.out.print(c[m] + "\n");

	}

	static int min(int a, int b) {
		if (a > b) {
			return b;
		} else {
			return a;
		}
	}
}
