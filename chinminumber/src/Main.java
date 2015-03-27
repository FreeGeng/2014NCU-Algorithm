import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String argv[]) {

		while (scanner.hasNext()) {
			int N = Integer.parseInt(scanner.nextLine());
			if (N != 0) {
				int a, i, b, n;

				for (a = 1; a < N; a++) {
					for (b = 0, i = 1; i <= a / 2; i++) {
						if ((a % i) == 0) {
							b += i;
						}
					}
					
					for (n = 0, i = 1; i <= b / 2; i++) {
						if ((b % i) == 0) {
							n += i;
						}
					}
					if (n == a&&a!=b) {
						System.out.println(a+" "+b);
					}
				}
			}
			else{
				System.exit(0);
			}
		}
	}
}