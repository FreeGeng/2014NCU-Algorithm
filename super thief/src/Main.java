import java.util.*;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	static int T;
	static int N;
	static int a[];
	static int sum;
	static boolean used[] = new boolean[100];
	static int last = 0;
	static boolean flag = true;

	public static void main(String args[]) {
		while (scanner.hasNext()) {
			String temp[] = scanner.nextLine().split(" ");
			T = Integer.parseInt(temp[0]);
			N = Integer.parseInt(temp[1]);
			a = new int[N];
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(scanner.nextLine());
			}
			sum = 0;
			for (int i = 0; i < used.length; i++) {
				used[i] = false;
			}
			backtrace(0);
			if (flag == true) {
				System.out.println("It is impossible.");
			}
			flag = true;
		}
	}

	static void backtrace(int n) {

		if (sum > T) {
			return;
		}
		if (sum == T) {
			//因為題目要求印出第一個可能性,所以加入一個flag,如果有答案,則flag變成false;這樣就算後面有答案也不會印出
			if (flag == true) {
				for (int j = 0; j < N; ++j) {
					if (used[j]) {
						System.out.print(a[j] + " ");
					}
				}
				System.out.println();
				flag = false;
			}
		}
		if (n == N) {
			return;
		}
		for (int i = n; i < N; ++i) {
			if (used[i] == false) {
				used[i] = true;
				sum += a[i];
				backtrace(i + 1);
				//如果進去backtrace之後都不符合的話,跳出並刪去剛剛加入的可能性
				used[i] = false;
				sum -= a[i];
			}
		}

	}
}