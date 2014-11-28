import java.util.*;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	static boolean b[];
	static int count = 0;

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
			for (int i = 0; i < machineNum; i++) {
				boolean result = judge(a[i][0], a[i][1]);
				if (result == true) {
					count = count + 1;
				}
			}
			System.out.print(count);
			System.out.println();
			count = 0;
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

	static boolean judge(int x, int y) {
		for (int i = x; i <= y; i++) {
			if (b[i] != false) {
				b[i] = false;

			} else {
				return false;
			}
		}
		return true;

	}
}

/*
 * 8 3 2 5 5 7 0 1
 * 
 * 8 3 3 4 5 6 0 0
 */