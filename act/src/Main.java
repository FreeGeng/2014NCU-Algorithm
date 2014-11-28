import java.util.*;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {
		while (scanner.hasNext()) {
			
			String temp[] = scanner.nextLine().split(" ");
			if (Integer.parseInt(temp[0]) == 0
					&& Integer.parseInt(temp[1]) == 0) {
				break;
			} else {
				int m =Integer.parseInt(temp[0]);
				int n =Integer.parseInt(temp[1]);
				int a[][] = new int[m][n];
				for(int i =0;i<m;i++){
					String temp1[] = scanner.nextLine().split(" ");
					for(int j =0;j<n;j++){
						a[i][j]=Integer.parseInt(temp1[j]);
					}
				}
				judge(a,m,n);
			}
           
		}
	}
	
	
	static void judge(int a[][],int m,int n){
		int score = 0;
		int max = 0;
		int x1=0,x2=0,y1=0,y2=0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int c = i; c < m; c++) {
					for (int d = j; d < n; d++) {
						for (int x = i; x <= c; x++) {
							for (int y = j; y <= d; y++) {
								if (a[x][y]==0||a[x][y]==1||a[x][y]==2||a[x][y]==3) {
									score = score + a[x][y];
								} else {
									score =score - a[x][y];
								}
							}
						}
						if (max < score) {
							max = score;
							x1=j;
							y1=i;
							x2=d;
							y2=c;
						}
						score = 0;
					}
				}

			}
		}
		System.out.println(max+" "+x1+" "+y1+" "+x2+" "+y2);
	}
}
/*
0 5 7 0 6 7 0
1 0 3 0 0 7 0
5 0 0 2 0 0 7
0 6 0 0 1 1 6
7 7 1 0 3 5 0
7 7 0 6 5 0 0
*/

/*
3 5
0 7 0 7 0
7 1 7 2 7
0 7 3 7 0
*/