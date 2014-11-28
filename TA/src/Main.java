import java.util.*;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String args[]) {
		while (scanner.hasNextLine()) {
		    double a[][];
			int QNum;
			int count = 0;
			int i = 0;
			double sumA = 0;
			double sumT = 0;
			
			QNum = Integer.parseInt(scanner.nextLine());
			a = new double[QNum][2];

			while (count < QNum) {
				String temp[] = scanner.nextLine().split(" ");

				double num1 = Double.parseDouble(temp[0]);
				double num2 = Double.parseDouble(temp[1]);
				
					a[i][0] = num1;
					a[i][1] = num2;
					i += 1;
				count++;
			}

			a=mySort(a);

			for (int z = 0; z < a.length; z++) {
				sumA = sumA + a[z][0];
				if (sumA > sumT) {
					sumT = sumA;
				}
				sumT = sumT + a[z][1];
			}
			
			System.out.printf("%d\n",(int)sumT);
		
		}
	}
	
	private static double[][] mySort(double[][] data){
		double[] t = new double[2];
		double nana = 0;
		double[] t2 = new double[data.length];
		for(int j=0;j<data.length;j++){
			t2[j]=data[j][0]/data[j][1];
		}
		
		for(int i = 0 ; i < data.length ; i++){
			int index = i;
			for(int j = i+1 ; j < data.length ; j++){
				if(t2[j] < t2[i]){
					nana = t2[j];
					t2[j] = t2[i];
					t2[i] = nana;
					
					t = data[j];
					data[j] = data[i];
					data[i] = t;
					index = j;
				}
			}
		}
		return data;
	}

}
/*
5
6 2
4 6
2 5
6 2
3 1
3
2 1
3 1
1 2
*/