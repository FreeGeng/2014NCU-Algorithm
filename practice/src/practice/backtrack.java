package practice;

public class backtrack {
	static int s[] = { 1, 2, 3 }; // 字串，需要先由小到大排序過
	static int solution[] = new int[3]; // 用來存放一組可能的答案

	static void backtrack(int n) {
		if (n == 2) {
			for (int i = 0; i < 2; i++) {
				System.out.print(solution[i] + "");

			}
			System.out.println();
		} else {
			for (int i = 0; i < 3; ++i) {
				solution[n] = s[i];
				backtrack(n + 1);
			}
		}
	}

	public static void main(String args[]) {

		backtrack(0);
	}

}
