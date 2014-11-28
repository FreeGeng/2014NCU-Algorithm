//使用窮舉

import java.util.*;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int a;
	static int b;
	static int count;
	static int prime[];
	static int solution[];

	public static void main(String args[]) {
		while (scanner.hasNext()) {
			String temp = scanner.nextLine();
			String temp2[] = temp.split(" ");
			boolean result;
			a = Integer.parseInt(temp2[0]);
			b = Integer.parseInt(temp2[1]);
			prime = new int[b];

			if (a > b) {
				System.out.println();
			} else {
				count = 0;
				for (int i = 2; i <= b; i++) {
					result = isPrime(i);
					if (result == true) {
						prime[count] = i;
						count++;
					}
				}
				solution = new int[count];
				enu();
				System.out.println("");

			}
		}
	}

	static boolean isPrime(int n) {
		int i;
		boolean result = true;
		for (i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				result = false;
				break;
			}
		}
		return result;
	}

	static void backtrack(int n) {
		if (n == a) {

			int sum = 0;
			for (int j = 0; j < a; j++) {
				sum = sum + solution[j];
			}
			if (sum == b) {
				for (int k = 0; k < a; k++) {
					System.out.print(solution[k] + " ");
				}
				System.out.println();
			}

		} else {
			for (int i = 0; i < count; ++i) {
				solution[n] = prime[i];
				backtrack(n + 1);
			}
		}
	}

	static void enu() {

		backtrack(0);

	}

}
