import java.util.Scanner;

public class Main {
	public static void main(String[] arg) {
		Scanner input = new Scanner(System.in);
		String temp_data;
		int people = 0, city = 0, no_connect = 10000000;
		int[] people_limit;
		while (input.hasNext()) {
			temp_data = input.nextLine();
			people = Integer.parseInt(temp_data.split(" ")[0]);
			city = Integer.parseInt(temp_data.split(" ")[1]);
			if(people == 0 && city == 0)
				System.exit(0);
			people_limit = String2int(input.nextLine().split(" "));
			int[][] data = new int[city][city];
			for (int i = 0; i < city; i++)
				data[i] = String2int(input.nextLine().split(" "));
			for (int i = 0; i < city; i++)
				for (int j = 0; j < city; j++)
					if (data[i][j] == -1)
						data[i][j] = no_connect;
			for (int i = 0; i < city; i++){
				if (people_limit[i] < people){
					for (int j = 0; j < city; j++)
						data[j][i] = no_connect;
					for (int j = 0; j < city; j++)
						data[i][j] = no_connect;
				}
			}
			for (int i = 0; i < city; i++)
				for (int j = 0; j < city; j++)
					for (int k = 0; k < city; k++)
						if (data[j][i] + data[i][k] < data[j][k])
							data[j][k] = data[j][i] + data[i][k];
			while(input.hasNext()){
				int[] temp = String2int(input.nextLine().split(" "));
				if(temp[0] == -1 && temp[1] == -1)
					break;
				if(temp[0] == temp[1]){
					System.out.println("0");
					continue;
				}
				if (data[temp[0]][temp[1]] == no_connect)
					System.out.println("*");
				else
					System.out.println(data[temp[0]][temp[1]]);
			}
		}
	}

	private static int[] String2int(String[] arr) {
		int[] ret = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
			ret[i] = Integer.parseInt(arr[i]);
		return ret;
	}
}
/*
30 6
100 45 77 31 29 100
-1 100 50 -1 -1 -1
100 -1 -1 200 300 -1
50 -1 -1 -1 800 -1
-1 200 -1 -1 -1 800
-1 300 800 -1 -1 200
-1 -1 -1 800 200 -1
0 5
0 2
1 5
2 4
-1 -1
30 6
100 45 77 31 29 100
-1 100 50 -1 -1 -1
100 -1 -1 200 300 -1
50 -1 -1 -1 800 -1
-1 200 -1 -1 -1 800
-1 300 800 -1 -1 200
-1 -1 -1 800 200 -1
0 5
0 2
1 5
2 4
4 3
1 5
4 1
2 3
-1 -1
0 0

*/