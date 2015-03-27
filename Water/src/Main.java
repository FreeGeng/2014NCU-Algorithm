import java.util.*;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int cup[];
	static boolean visit[][][];
	static int demand;
	static int limitation;
	static Queue<cup> buttle;
	static Queue<Integer> brokenbuttle;

	public static void main(String[] args) {
		
		buttle = new LinkedList<cup>();
		brokenbuttle = new LinkedList<Integer>();
		cup = new int[3];
		scannerData();
		while (hasNoZero()) {
			execute();
			buttle.clear();
			brokenbuttle.clear();
			scannerData();
		}

	}

	private static void execute() {
		int counter = 0;
		cup initial = new cup(0, 0, cup[2]);
		buttle.offer(initial);
		brokenbuttle.offer(counter);

		while (!buttle.isEmpty()) {
			cup s = buttle.poll();
			int curCounter = brokenbuttle.poll();
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					cup t = s.clone();
					int c = curCounter;
					int w = pour(t, i, j);
					c += w;

					if (visit[t.water[0]][t.water[1]][t.water[2]]
							|| c > limitation) {
						continue;
					}
					visit[t.water[0]][t.water[1]][t.water[2]] = true;
					if (target(t) && c <= limitation) {
						System.out.println("YES");
						return;
					}
					buttle.offer(t);
					brokenbuttle.offer(c);
				}
			}
		}
		System.out.println("NO");
	}

	static int pour(cup s, int i, int j) {
		int w = Math.min(s.water[i], cup[j] - s.water[j]);
		s.water[i] -= w;
		s.water[j] += w;
		return w;
	}

	static boolean target(cup s) {
		return s.water[0] == demand || s.water[1] == demand
				|| s.water[2] == demand;
	}

	static boolean hasNoZero() {
		for (int i = 0; i < cup.length; i++) {
			if (cup[i] != 0) {
				return true;
			}
		}
		if (demand != 0) {
			return true;
		}
		if (limitation != 0) {
			return true;
		}
		return false;
	}

	static void scannerData() {
		for (int i = 0; i < cup.length; i++) {
			cup[i] = scanner.nextInt();
		}
		visit = new boolean[cup[0] + 1][cup[1] + 1][cup[2] + 1];
		demand = scanner.nextInt();
		limitation = scanner.nextInt();
	}

}

class cup {
	public int water[];

	public cup(int a, int b, int c) {
		int w[] = { a, b, c };
		water = w;
	}

	public cup clone() {
		cup output = new cup(water[0], water[1], water[2]);
		return output;
	}
}