import java.util.Scanner;

public class Main {
	static int num = 0;
	static int MAXQUEEN;
	static int[] cols;
	static Scanner scanner = new Scanner(System.in);
	static String temp[];
	static int score[][];
	static int total;
	static int max;

	public static void main(String args[]) {
		while (scanner.hasNext()) {
			temp = scanner.nextLine().split(" ");
			if (!temp[0].equals("0")) {
				MAXQUEEN = Integer.parseInt(temp[0]);
				score = new int[MAXQUEEN][MAXQUEEN];
				for (int i = 0; i < MAXQUEEN; i++) {
					String temp1[] = scanner.nextLine().split(" ");
					for (int j = 0; j < MAXQUEEN; j++) {
						score[i][j] = Integer.parseInt(temp1[j]);
					}
				}
				cols = new int[MAXQUEEN];
				run();
				max=0;
				total=0;

			} else {
				System.exit(0);
			}
		}
	}

	public static void run() {
		getArrangement(0);
		System.out.println(max);
	}

	public static void getArrangement(int n) {

		boolean[] rows = new boolean[MAXQUEEN];
		for (int i = 0; i < n; i++) {
			rows[cols[i]] = true;
			int d = n - i;
			if (cols[i] - d >= 0)
				rows[cols[i] - d] = true;
			if (cols[i] + d <= MAXQUEEN - 1)
				rows[cols[i] + d] = true;
		}
		for (int i = 0; i < MAXQUEEN; i++) {
			if (rows[i])
				continue;

			cols[n] = i;
			if (n < MAXQUEEN - 1) {
				getArrangement(n + 1);
			} else {
				num++;
				printChessBoard();
			}
		}
	}

	public static void printChessBoard() {

		for (int i = 0; i < MAXQUEEN; i++) {
			for (int j = 0; j < MAXQUEEN; j++) {
				if (i == cols[j]) {
					total = total + score[i][j];
				}
			}
		}
		if (max < total) {
			max = total;
		}
		total = 0;
	}
}

/*
 8
 1 2 3 4 5 6 7 8
 9 10 11 12 13 14 15 16
 17 18 19 20 21 22 23 24
 25 26 27 28 29 30 31 32
 33 34 35 36 37 38 39 40
 57 58 59 60 61 62 63 64
 41 42 43 44 45 46 47 48
 23 42 32 45 32 11 27 58 
 */