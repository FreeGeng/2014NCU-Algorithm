package practice;

import java.util.*;

public class practice {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {

		int n = scanner.nextInt();
		for (int i = n; i >= 2; i--) {
			boolean b = primeJudge(i);
			if (b == true) {
				System.out.print(i);
			break;
			}
		}
	}

	public static boolean primeJudge(int n) {
		boolean s = false;
		if (n > 1) {
			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					break;
				}
				if (n % i != 0 && i == n - 1) {
					s = true;
				}
			}
		}
		return s;
	}
}
