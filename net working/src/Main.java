import java.util.Scanner;

public class Main {
	static int node;
	static int edge;
	static int x;
	static Scanner input=new Scanner(System.in);

	public static void main(String[] args) {
	
		x = Integer.MAX_VALUE;

		node = input.nextInt();
		edge = input.nextInt();
		while (node != 0 || edge != 0) {
			int change[] = new int[node + 1];
			for (int i = 1; i <= node; i++) {
				input.nextInt();
				change[i] = input.nextInt();
			}
			int route[][] = new int[node + 1][node + 1];
			for (int i = 0; i < edge; i++) {
				int a = input.nextInt();
				int b = input.nextInt();
				int p = input.nextInt();
				route[a][b] = change[a] + p + change[b];
				route[b][a] = change[b] + p + change[a];
			}

			judge(route);
			run(change, route);

			int i = input.nextInt();
			int j = input.nextInt();
			while (i != -1 || j != -1) {
				int t = route[i][j];
				if (t == x) {
					System.out.println(0);
				} else {
					System.out.println(route[i][j]);
				}

				i = input.nextInt();
				j = input.nextInt();
			}
			node = input.nextInt();
			edge = input.nextInt();
		}
	}

	private static void run(int[] change, int[][] route) {
		for (int k = 1; k < route.length; k++) {
			for (int i = 1; i < route.length; i++) {
				for (int j = 1; j < route.length; j++) {
					if (route[i][j] != x && route[i][k] != x
							&& route[k][j] != x) {
						if (route[i][j] > route[i][k] - change[k]
								+ route[k][j]) {
							route[i][j] = route[i][k] - change[k]
									+ route[k][j];
						}
					} else if (route[i][j] == x && route[i][k] != x
							&& route[k][j] != x) {
						route[i][j] = route[i][k] - change[k]
								+ route[k][j];
					}

				}
			}
		}

	}

	private static void judge(int[][] route) {
		for (int i = 1; i < route.length; i++) {
			for (int j = 1; j < route.length; j++) {
				if (route[i][j] == 0) {
					route[i][j] = x;
				}
			}
		}
	}
}
