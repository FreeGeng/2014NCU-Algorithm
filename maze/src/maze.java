import java.util.*;

 
public class maze {
    static Scanner input;
	static int power;
	static int x;
	static int y;
	static char[][] map;
	static Stack<Character> pathList = new Stack<Character>();
 
	public static void main(String[] args) {
		input = new Scanner(System.in);
		power = input.nextInt();
		x = input.nextInt();
		y = input.nextInt();
		while (power != 0 || x != 0 || y != 0) {
			map = new char[x][y];
			input.nextLine();
			for (int i = 0; i < x; i++) {
				String s = input.nextLine();
				for (int j = 0; j < s.length(); j++) {
					if (s.charAt(j) == '#') {
						map[i][j] = '#';
					}
				}
			}
			execute();
			// next
			power = input.nextInt();
			x = input.nextInt();
			y = input.nextInt();
			pathList.clear();
		}
	}
 
	private static void execute() {
		int counter = 0;
		findWay(counter, 0, 0);
 
	}
 
	private static void findWay(int counter, int x, int y) {
		if (x == map.length - 1 && y == map[0].length - 1) {
			print();
			return;
		} else if (counter == power) {
			return;
		} else {
			map[x][y] = '#';
			if (goTop(x, y)) {
				pathList.push('U');
				findWay(counter+1, x - 1, y);
				pathList.pop();
			}
			if (goLeft(x, y)) {
				pathList.push('L');
				findWay(counter+1, x, y - 1);
				pathList.pop();
			}
			if (goDown(x, y)) {
				pathList.push('D');
				findWay(counter+1, x + 1, y);
				pathList.pop();
 
			}
			if (goRight(x, y)) {
				pathList.push('R');
				findWay(counter+1, x, y + 1);
				pathList.pop();
			}
			map[x][y] = ' ';
		}
	}
 
	private static boolean goTop(int x2, int y2) {
		if (x2 == 0) {
			return false;
		} else if (map[x2 - 1][y2] == '#') {
			return false;
		}else{
			return true;
		}
	}
 
	private static boolean goLeft(int x2, int y2) {
		if (y2 == 0) {
			return false;
		} else if (map[x2][y2 - 1] == '#') {
			return false;
		}else{
			return true;
		}
	}
 
	private static boolean goDown(int x2, int y2) {
		if (x2 == map.length - 1) {
			return false;
		} else if (map[x2 + 1][y2] == '#') {
			return false;
		}else{
			return true;
		}
	}
 
	private static boolean goRight(int x2, int y2) {
		if (y2 == map[0].length - 1) {
			return false;
		} else if (map[x2][y2 + 1] == '#') {
			return false;
		}else{
			return true;
		}
	}
 
	private static void print() {
		for (int i = 0; i < pathList.size(); i++) {
			System.out.print(pathList.get(i));
		}
		System.out.println();
	}
}