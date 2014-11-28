import java.util.*;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {
		while (scanner.hasNext()) {
			String temp[] = scanner.nextLine().split(" ");
			int totalCity = Integer.parseInt(temp[0]);
			int start = Integer.parseInt(temp[1]);
			int end = Integer.parseInt(temp[2]);

			int map[][] = new int[totalCity][totalCity];

			for (int i = 0; i < totalCity; i++) {
				String row[] = scanner.nextLine().split(" ");
				for (int j = 0; j < totalCity; j++) {
					map[i][j] = Integer.parseInt(row[j]);
				}
			}
			
			run(map, start, end);

		}
	}

	static void run(int map[][], int start, int end) {
		int d[][] = new int[map.length][map.length];
		int x = Integer.MAX_VALUE;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j]==0){
				d[i][j] =  x;
				}
				else{
					d[i][j]=1;
				}
			}
		}
		for (int k = 0; k <= map.length - 1; k++) { 
			for (int i = 0; i <= map.length - 1; i++) {
				for (int j = 0; j <= map.length - 1; j++) {
					if (d[i][k] != x && d[k][j] != x && d[i][j] != x) {
						if (d[i][j] > d[i][k] + d[k][j]) {
							d[i][j] = d[i][k] + d[k][j];
						}
					}else if(d[i][j] == x&&d[i][k] != x && d[k][j] != x){
						d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
		}
		
		
		 if (d[start][end] == x) {
		 System.out.println("N");
		 }
		 else{
		 System.out.println("Y");
		 }

	}
}
/*
 * 6 2 5 0 0 1 0 0 0 0 0 0 0 1 0 1 0 0 1 0 0 0 0 1 0 0 1 0 1 0 0 0 0 0 0 0 1 0 0
 */