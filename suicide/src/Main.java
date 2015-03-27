import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static int execute(int n, int k) {
		int killIdx = 0;
		ArrayList<Integer> prisoners = new ArrayList<Integer>(n);
		for (int i = 1; i <= n; i++) {
			prisoners.add(i);
		}
		while (prisoners.size() > 1) {
			killIdx = (killIdx + k - 1) % prisoners.size();

			prisoners.remove(killIdx);
		}

		return prisoners.get(0);
	}

	public static void main(String[] args) {
		while (scanner.hasNext()) {
			String temp[] = scanner.nextLine().split(" ");
			int N = Integer.parseInt(temp[0]);
			int M = Integer.parseInt(temp[1]);

			if (N != 0 && M != 0) {
				System.out.println(execute(N, M));
			} else {
				System.exit(0);
			}
		}
	}
}