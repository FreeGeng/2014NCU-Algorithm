import java.util.*;

public class Main {
	static int groupNum;
	static int index;
	static Scanner scanner = new Scanner(System.in);
	static int le;

	public static void main(String[] args) {
		groupNum = scanner.nextInt();
		for (int i = 1; i <= groupNum; i++) {
			index = scanner.nextInt();
			int a1[] = new int[index];
			String input = scanner.next();
			String[] numString = input.split(",");
			for (int j = 0; j < index; j++) {
				a1[j] = Integer.parseInt(numString[j]);
			}
			int temp[] = new int[a1.length];
			for (int k = 0; k < a1.length; k++) {
				temp[k] = a1[k];
			}
			Arrays.sort(temp);
			le = (int) Math.log10(temp[temp.length - 1]);

			radixSort(a1);
			System.out.println("*");
		}
	}

	static void radixSort(int a[]) {
		int bucket[][] = new int[10][index];
		int order[] = new int[10];
		int n = 1;
		int k = 0;
		for (int q = 0; q <= le; q++) {

			for (int i = 0; i < a.length; i++) {
				int lsd = (a[i] / (int) Math.pow(10, q) % 10);
				bucket[lsd][order[lsd]] = a[i];
				order[lsd]++;
			}

			for (int i = 0; i < 10; i++) {
				if (order[i] != 0) {

					for (int j = 0; j < order[i]; j++) {

						a[k] = bucket[i][j];
						k++;
					}

				}
				order[i] = 0;
			}
			for (int y = 0; y < a.length; y++) {
				if (y < a.length - 1) {
					System.out.print(a[y] + " ");
				} else {
					System.out.print(a[y]);
				}
			}

			System.out.println();
			k = 0;
		}

	}
}
