import java.util.*;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int N;
	static int total;
	static int sum;
	static int number[];
	static String symbol[];
	static String solution[];
	static String temp[];
	static boolean flag = true;

	public static void main(String args[]) {
		while (scanner.hasNext()) {
			temp = scanner.nextLine().split(" ");
			if (!temp[0].equals("0")) {
				N = Integer.parseInt(temp[0]);
				sum = Integer.parseInt(temp[1]);
				total = Integer.parseInt(temp[N + 1]);
				number = new int[N];

				for (int i = 0; i < N; i++) {
					number[i] = Integer.parseInt(temp[i + 1]);
				}
				enu();

				if (flag == true) {
					System.out.println("Impossible");
					flag=false;
				}
			
			flag=true;
			}
			else{
				System.exit(0);
			}
		}
	}

	static void backtrack(int n) {
		if (n == N - 1) {

			for (int i = 1; i < N; i++) {
				judge(solution[i - 1], number[i]);
				
			}

			if (flag == true) {
				if (sum == total) {
					int k = 0;
					for (int i = 0; i < N; i++) {
						if (k < N - 1) {
							System.out.print(number[i] + "" + solution[k]);
						} else {
							System.out.print(number[i]);
						}
						k++;
					}
					flag = false;
					System.out.println();
				}
			}
			sum = Integer.parseInt(temp[1]);;

		} else {
			for (int i = 0; i < 2; i++) {
				solution[n] = symbol[i];
				backtrack(n + 1);
			}
		}
	}

	static void enu() {
		solution = new String[N-1];
		symbol = new String[2];
		symbol[0] = "+";
		symbol[1] = "*";
		backtrack(0);

	}

	static void judge(String a, int i) {
		if (a.equals("+")) {
			sum = sum + i;
		} else if (a.equals("*")) {
			sum = sum * i;
		}
	}
}