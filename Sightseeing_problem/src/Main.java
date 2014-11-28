import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		while (scanner.hasNext()) {

			int cityTotal = scanner.nextInt();
			int roadTotal = scanner.nextInt();
			if (cityTotal == 0 && roadTotal == 0) {
				break;
			}

			int[] weights = new int[cityTotal + 1];
			int[][] distance = new int[101][101];
			int startCity = scanner.nextInt();
			int endCity = scanner.nextInt();
			int peopleNum = scanner.nextInt();

			for (int i = 0; i < cityTotal; i++) {
				int cityNumber = scanner.nextInt();
				int weight = scanner.nextInt();
				weights[cityNumber] = weight;
			}

			for (int i = 0; i < roadTotal; i++) {
				int edgeStartCity = scanner.nextInt();
				int edgeEndCity = scanner.nextInt();
				distance[edgeStartCity][edgeEndCity] = weights[edgeEndCity];
				distance[edgeEndCity][edgeStartCity] = weights[edgeStartCity];
			}

			for (int k = 1; k <= cityTotal; k++) {
				for (int i = 1; i <= cityTotal; i++) {
					for (int j = 1; j <= cityTotal; j++) {
						distance[i][j] = Math.max(distance[i][j],
								Math.min(distance[i][k], distance[k][j]));
					}
				}
			}

			int min = (int) Math.ceil((double) peopleNum
					/ (distance[startCity][endCity] - 1));

			System.out.printf("%d is the minimum number of trips.\n", min);
		}
	}

}
/*
 * 7 10 1 7 99 1 50 2 30 3 15 4 25 5 15 6 20 7 35 12 13 24 25 34 36 45 47 57 67
 */