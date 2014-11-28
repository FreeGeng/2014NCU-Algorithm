import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	static boolean b[];
	static int count = 1;

	public static void main(String args[]) {

		while (scanner.hasNext()) {
			int timeslot;
			int machineNum;

			String temp[] = scanner.nextLine().split(" ");
			timeslot = Integer.parseInt(temp[0]);
			machineNum = Integer.parseInt(temp[1]);
			b = new boolean[timeslot];
			for (int i = 0; i < timeslot; i++) {
				b[i] = true;
			}
			int a[][] = new int[machineNum][2];
			for (int i = 0; i < machineNum; i++) {
				String temp1[] = scanner.nextLine().split(" ");
				a[i][0] = Integer.parseInt(temp1[0]);
				a[i][1] = Integer.parseInt(temp1[1]);
			}

			int t1[] = new int[machineNum];
			for (int i = 0; i < machineNum; i++) {
				t1[i] = a[i][1];
			}

			a = Sort(a, t1);
			int s[] = new int[machineNum];
			int f[] = new int[machineNum];
			for (int i = 0; i < machineNum; i++) {
				s[i] = a[i][0];
				f[i] = a[i][1];
			}
			judge(s, f, 0, machineNum);
			System.out.print(count);
			System.out.println();
			count = 1;
			scanner.nextLine();
		}
	}

	static int[][] Sort(int[][] data, int[] t2) {
		int[] t = new int[2];
		int nana = 0;

		for (int i = 0; i < data.length; i++) {
			int index = i;
			for (int j = i + 1; j < data.length; j++) {
				if (t2[j] < t2[i]) {
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

	static void judge(int[] s, int[] f, int k, int n) {
		
		int m = k + 1;
		if (m < n) {
			while (m < n && s[m] <= f[k]) {
				m = m + 1;
			}
			if (m < n) {
				count = count + 1;
				judge(s,f,m,n);
			}
		}
	}
}

/*
8 3
2 5
5 7
0 1
  
8 3
3 4
5 6
0 0
 */