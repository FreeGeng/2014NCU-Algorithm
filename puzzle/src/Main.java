import java.util.Scanner;

public class Main {
	static Scanner input;
	static int times;
	static int[][] map;
	static boolean answer;
	static int zeroX;
	static int zeroY;
	static String opterate[] = { "up", "down", "right", "left" };
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static int reverse_dir[] = { 1, 0, 3, 2 };

	static void run() {
		answer = false;
		long bound = 0;
		while (!answer && bound <= times) {
			bound = IDAstar(zeroX, zeroY, 0, -1, bound);
		}
		if (answer) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	static long IDAstar(int x, int y, int gv, int prev_dir, long bound) {
		int hv = heuristic_function();
		if (hv + gv > bound) {
			return hv + gv;
		}
		if (hv == 0) {
			answer = true;
			return gv;
		}
		long next_bound = (long) 1e16;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (reverse_dir[i] == prev_dir) {
				continue;
			}
			if (!onBoard(nx, ny)) {
				continue;
			}
			swap(x, y, nx, ny);
			long v = IDAstar(nx, ny, gv + 1, i, bound);
			if (answer) {
				return v;
			}
			next_bound = Math.min(next_bound, v);
			swap(nx, ny, x, y);
		}
		return next_bound;
	}

	static void swap(int i, int j, int a, int b) {
		int t = map[i][j];
		map[i][j] = map[a][b];
		map[a][b] = t;
	}

	static boolean onBoard(int a, int b) {
		return 0 <= a && a < 4 && 0 <= b && b < 4;
	}

	static int taxicab_distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x2 - x1) + Math.abs(y2 - y1);
	}

	static int heuristic_function() {
		int right_pos[][] = { { 3, 3 }, { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 },
				{ 1, 0 }, { 1, 1 }, { 1, 2 }, { 1, 3 }, { 2, 0 }, { 2, 1 },
				{ 2, 2 }, { 2, 3 }, { 3, 0 }, { 3, 1 }, { 3, 2 } };
		int cost = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int a = right_pos[map[i][j]][0];
				int b = right_pos[map[i][j]][1];
				cost += taxicab_distance(i, j, a, b);
			}
		}
		return cost;
	}

	static int[][] inputM() {
		int output[][] = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int t = input.nextInt();
				if (t == 0) {
					zeroX = i;
					zeroY = j;
				}
				output[i][j] = t;
			}
		}
		return output;
	}

	public static void main(String[] args) {
		input = new Scanner(System.in);
		times = input.nextInt();
		while (times != 0) {
			map = inputM();
			run();
			times = input.nextInt();
		}
	}
}