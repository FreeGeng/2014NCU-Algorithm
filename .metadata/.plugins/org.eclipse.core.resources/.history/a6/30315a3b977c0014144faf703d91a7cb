import java.util.*;
 
public class Main {
    static Scanner scanner = new Scanner(System.in);
	static int N;
	static int M;
 
	public static void main(String[] args) {  
		N = scanner.nextInt();
		M = scanner.nextInt();
 
		while (N != 0 && M != 0) {
			scanner.nextLine();
			M[] people = new M[M];
			for (int i = 0; i < M; i++) {
				people[i] = new M();
				String line = scanner.nextLine();
				for (int j = 0; j < line.length() - 1; j += 2) {
					char[] c = new char[2];
					c[0] = line.charAt(j);
					c[1] = line.charAt(j + 1);
					String N = String.valueOf(c);
					people[i].addN(N);
				}
			}
			execute(people, N);
 
			N = scanner.nextInt();
			M = scanner.nextInt();
		}
	}
 
	static void execute(M[] people, int N) {
		for (int i = 0; i < Math.pow(2, N); i++) {
			if (matchAll(i, N, people)) {
				display(i, N);
				return;
			}
		}
		System.out.println("NO");
	}
 
	static void display(int number, int N) {
		char selectedN[] = getBinaryChar(number, N);
		for (int i = 0; i < selectedN.length; i++) {
			if (selectedN[i] == '1') {
				System.out.print(getLetter(i));
			}
		}
		System.out.println();
	}
 
	static char getLetter(int letter) {
		char output[] = Character.toChars(65 + letter);
		return output[0];
	}
 
	static boolean matchAll(int number, int N, M[] people) {
		char selectedN[] = getBinaryChar(number, N);
 
		for (int i = 0; i < people.length; i++) {
			if (!match(selectedN, people[i])) {
				return false;
			}
		}
		return true;
	}
 
	static boolean match(char[] selectedN, M M) {
		for (int i = 0; i < M.N.size(); i++) {
			if (matchN(M.N.get(i), selectedN)) {
				return true;
			}
		}
		return false;
	}
 
	static boolean matchN(String NString, char[] selectedN) {
		boolean positive;
		int letterNo;
		if (NString.charAt(0) == '+') {
			positive = true;
		} else {
			positive = false;
		}
		letterNo = getNo(NString.charAt(1));
 
		if (positive) {
			if (selectedN[letterNo] == '1') {
				return true;
			} else {
				return false;
			}
		} else {
			if (selectedN[letterNo] == '0') {
				return true;
			} else {
				return false;
			}
		}
	}
 
	static int getNo(char charAt) {
		return Character.getNumericValue(charAt) - 10;
	}
 
	static char[] getBinaryChar(int number, int N) {
		char output[] = new char[N];
		for (int i = 0; i < output.length; i++) {
			output[i] = '0';
		}
		char numberChar[] = Integer.toBinaryString(number).toCharArray();
		int a = numberChar.length - 1;
		int b = output.length - 1;
		while (a >= 0) {
			if (numberChar[a] == '1') {
				output[b] = '1';
			}
			a--;
			b--;
		}
		return output;
	}
 
}
 
class M {
	public LinkedList<String> N;
 
	public M() {
		N = new LinkedList<String>();
	}
 
	public void addN(String f) {
		N.add(f);
	}
 
	public void showN() {
		for (int i = 0; i < N.size(); i++) {
			System.out.print(N.get(i) + " ");
		}
		System.out.println();
	}
}


/*
16 8
+A+B+C+D
+E+F+F+H
+A+B-G
+O+J-F
+H+I+C
+P
+O+M+L
+M-L+P
*/