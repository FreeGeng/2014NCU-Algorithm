import java.util.*;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int[] D;
	static int[] K;
	static int m;
	static int count;

	public static void main(String args[]) {
		while (scanner.hasNextLine()) {
			String temp[] = scanner.nextLine().split(" ");
			if(temp[0].equals("0")&&temp[1].equals("0")&&temp[2].equals("0")){
				break;
			}
			
			D = new int[Integer.parseInt(temp[0])];
			K = new int[Integer.parseInt(temp[1])];
			m = Integer.parseInt(temp[2]);
			String temp1[] = scanner.nextLine().split(" ");
			for (int i = 0; i < D.length; i++) {
				D[i] = Integer.parseInt(temp1[i]);
			}

			String temp2[] = scanner.nextLine().split(" ");
			for (int i = 0; i < K.length; i++) {
				K[i] = Integer.parseInt(temp2[i]);
			}

			for (int j = 0; j < K.length; j++) {
				for (int t = 0; t < D.length; t++) {
					if (D[t] + K[j] == m) {
						count++;
						break;
					}
				}
			}

			System.out.println(count);
			count = 0;
			
		}
	}
}
