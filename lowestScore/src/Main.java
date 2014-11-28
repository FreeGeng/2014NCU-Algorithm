import java.util.*;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	static String totalClass1;
	static int totalClass2;
	static String classNum1;
	static int classNum2;

	public static void main(String args[]) {
		totalClass1 = scanner.nextLine();
		totalClass2=Integer.parseInt(totalClass1);
		for (int i = 1; i <= totalClass2; i++) {
			classNum1 = scanner.nextLine();
			classNum2 = Integer.parseInt(classNum1);
			int a[] = new int[classNum2];
			String temp[] = scanner.nextLine().split(" ");
			
			for (int j = 0; j < classNum2; j++) {
				a[j] = Integer.parseInt(temp[j]);
			}
			Arrays.sort(a);
			System.out.println(a[0]);
		}

	}
}
