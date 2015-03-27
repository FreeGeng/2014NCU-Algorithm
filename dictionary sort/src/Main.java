import java.util.*;

public class Main {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {
		while (scanner.hasNext()) {
			int N = Integer.parseInt(scanner.nextLine());
			String temp[] = new String[N];
			if (N != 0) {
				for (int i = 0; i < N; i++) {
					temp[i] = scanner.nextLine();
				}

				Arrays.sort(temp);
				for (int i = 0; i < N; i++) {
					System.out.println(temp[i]);
				}
				System.out.println("*");
			}
			else{
				System.exit(0);
			}
		}
	}

}
