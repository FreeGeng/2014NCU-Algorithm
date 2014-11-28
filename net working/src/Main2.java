import java.util.Scanner;

public class Main2 {

	static Scanner scanner = new Scanner(System.in);
	static int V;
	static int E;
	static int node[];
	static int route[][];
	static int input[][];
	static int d[][];

	public static void main(String args[]) {
		while (scanner.hasNext()) {
			String temp[] = scanner.nextLine().split(" ");
			V = Integer.parseInt(temp[0]);
			E = Integer.parseInt(temp[1]);
			node = new int[V + 1];
			route = new int[V + 1][V + 1];
			d = new int[V + 1][V + 1];
			input = new int[100][2];
			for (int i = 0; i <= V; i++) {

				if (i == 0) {
					node[i] = 0;
				} else {
					String temp2[] = scanner.nextLine().split(" ");
					int nodeWeight = Integer.parseInt(temp2[1]);
					node[i] = nodeWeight;
				}
			}

			for (int i = 0; i < E; i++) {
				String temp3[] = scanner.nextLine().split(" ");
				int x = Integer.parseInt(temp3[0]);
				int y = Integer.parseInt(temp3[1]);
				int routeWeight = Integer.parseInt(temp3[2]);
				route[x][y] = routeWeight;
			}

			for (int i = 0; i < V + 1; i++) {
				for (int j = 0; j < V + 1; j++) {
					if (route[i][j] == 0) {
						route[i][j] = Integer.MAX_VALUE;
					}
				}
			}

			int a = 0;

			while (scanner.hasNextLine()) {
				String temp4[] = scanner.nextLine().split(" ");

				if (Integer.parseInt(temp4[0]) == 0
						&& Integer.parseInt(temp4[1]) == 0) {
					System.exit(0);
				} else if (Integer.parseInt(temp4[0]) > 0
						&& Integer.parseInt(temp4[1]) > 0) {
					input[a][0] = Integer.parseInt(temp4[0]);
					input[a][1] = Integer.parseInt(temp4[1]);
					a++;
				} else {
					for (int i = 0; i < a; i++) {
						judge(input[i][0], input[i][1]);

					}
					break;
				}
			}

		}
	}

	static void judge(int source, int end) {
		int z = Integer.MAX_VALUE;
		for (int i = 0; i < V + 1; i++) {
			for (int j = 0; j < V + 1; j++) {
				if (i != 0 && j != 0) {
					d[i][j] = route[i][j] + node[j] + node[i];
				}
			}
		}

		for (int i = 0; i < V + 1; i++) {
			d[i][i] = 0;
		}

		for (int k = 1; k < V + 1; k++) {
			for (int i = 1; i < V + 1; i++) {
				for (int j = 1; j < V + 1; j++) {
					if (i != k && k != j) {
						if (d[i][k] !=z && d[k][j] !=z && d[i][j] != z) {
							if (d[i][k] + d[k][j] - node[k] < d[i][j]) {
								d[i][j] = d[i][k] + d[k][j] - node[k];
							}
						} else if (d[i][j] == z && d[i][k] !=z && d[k][j] !=z) {
							d[i][j] = d[i][k] + d[k][j] - node[k];
						}
					}
				}
			}
		}
		System.out.println(d[source][end]);

		// for(int i =0;i<V+1;i++){
		// for(int j =0;j<V+1;j++){
		// System.out.print(d[i][j]+" ");
		// }
		// System.out.println();
		// }
		// System.out.println();
	}
}

/*
 * 7 10 1 50 2 30 3 15 4 25 5 15 6 20 7 35 1 2 10 1 3 5 2 4 6 2 5 8 3 4 7 3 6 10
 * 4 5 5 4 7 12 5 7 6 6 7 8 1 2 5 7 1 7 2 6 5 3 -1 -1
 */