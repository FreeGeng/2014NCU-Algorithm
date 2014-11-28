import java.util.*;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	static int n;
	static int k;
	static int board[][];
	static int player[];

	public static void main(String args[]) {
		while (scanner.hasNext()) {
			String temp = scanner.nextLine();
			while(temp.equals("")){
				temp = scanner.nextLine();
			}
			String temp2[] = temp.split(" ");
			n = Integer.parseInt(temp2[0]);
			k = Integer.parseInt(temp2[1]);
			if (8 <= n && n <= 16 && 2 <= k && k <= 5) {
				board = new int[n][n];
				player = new int[k];
				for (int i = 1; i <= k; i++) {
					player[i - 1] = i;
				}
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						board[i][j] = scanner.nextInt();
					}
				}
				for (int i = 0; i < k; i++) {
					judge(board, player[i]);
				}
				System.out.println();
			}
		}
	}

	static void judge(int a[][], int player) {
		int score = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int c = i; c < n; c++) {
					for (int d = j; d < n; d++) {
						for (int x = i; x <= c; x++) {
							for (int y = j; y <= d; y++) {
								if (player == a[x][y]) {
									score = score + 1;
								} else {
									score = score - 1;
								}
							}
						}
						if (max < score) {
							max = score;
						}
						score = 0;
					}
				}

			}
		}
		System.out.println(player + "->" + max);
	}
}
