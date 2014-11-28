import java.util.*;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {
		while (scanner.hasNextLine()) {
			String temp[] = scanner.nextLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			if (a == 0 && b == 0) {
				break;
			}
			judge(a, b);
			System.out.println();
		}
	}

	static void judge(int a, int b) {

		if (a < b) {
			System.out.print("L");
			b = b - a;
			judge(a, b);
		} else if (a > b) {			
			System.out.print("R");
			a = a - b;
			judge(a, b);
		}
		else if (a == 1 && b == 1) {
			return;
		}
		/*
		 * while(a != b){ if(a > b){ System.out.print("R"); a = a - b; } if(a <
		 * b){ System.out.print("L"); b = b - a; } } System.out.println();
		 */
	}
}
