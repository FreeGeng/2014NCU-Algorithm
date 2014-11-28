import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {
		while (scanner.hasNext()) {
			String temp[] = scanner.nextLine().split(" ");
			int totalPeople = Integer.parseInt(temp[0]);
			int totalCity = Integer.parseInt(temp[1]);
			
			String temp2[] = scanner.nextLine().split(" ");
			int hotel[] = new int [totalCity];
			for(int i =0;i<totalCity;i++){
			 hotel[i] = Integer.parseInt(temp2[i]);
			}
			int map[][] = new int[totalCity][totalCity];

			for (int i = 0; i < totalCity; i++) {
				String row[] = scanner.nextLine().split(" ");
				for (int j = 0; j < totalCity; j++) {
					map[i][j] = Integer.parseInt(row[j]);
				}
			}
			
			judge(totalPeople,hotel,map);
		}
	}
	
	static void judge(int totalPeople,int[] hotel,int[][]map){
		int d[][] = new int[map.length][map.length];
		int x = Integer.MAX_VALUE;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(totalPeople>hotel[i]){
				d[i][j] =  x;
				}
				else {
					if(map[i][j]==-1)
					d[i][j]=x;
					else{
						d[i][j]=map[i][j];
					}
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
		if(d[0][map.length-1]!=Integer.MAX_VALUE)
		System.out.println(d[0][map.length-1]);
		else
			System.out.println("*");
		
	}
}
