import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {
		while (scanner.hasNext()) {
			String temp[] = scanner.nextLine().split(" ");
			int edge = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			int c = Integer.parseInt(temp[2]);
			if(b<c){
				int temp1 =b;
				b=c;
				c=temp1;
			}
			judge(edge, b, c);

		}
	}

	static void judge(int edge, int b, int c) {
		long point[][] = new long[edge + 1][edge + 1];
		long temp[][] = new long[edge + 1][edge + 1];
		point[0][0]=1;
		for (int i = 0; i <= edge; i++) {
			for (int j = 0; j <= edge; j++) {
             temp=outRange(edge,i,j,b,c,point);            
			}
		}
		System.out.println(temp[edge][edge]);
	}
	
	static long[][] outRange(int edge,int i,int j,int b,int c,long point[][]){

		if(j<=i+b&&j>=i+c){
			if(i>0&&j>0)
			point[i][j]=point[i-1][j]+point[i][j-1];
			else if(i==0&&j!=0){
				point[i][j]=point[i][j-1];
			}
			else if(j==0&&i!=0){
				point[i][j]=point[i-1][j];
			}
		}
		
		return point;
	}
}

