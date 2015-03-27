import java.util.*;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static String matrix[][];
	static int maze[][];
	static int X, Y, sx, sy, tx, ty, power;
	static int step = 0;

	class Point {
		public int x;
		public int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;

		}
	}

	public Point createPoint(int x, int y) {
		return new Point(x, y);
	}

	public String find(int[][] maze, int startX, int startY, int endX, int endY) {
		return find(maze, new Point(startX, startY), new Point(endX, endY));
	}

	public String find(int[][] maze, Point start, Point end) {
		int[][] copyMaze = arraycopy(maze);
		ArrayList ary = new ArrayList();
		visit(copyMaze, start, end, ary);
		return getMaxePath(ary);
	}

	private boolean visit(int[][] maze, Point pt, Point end, ArrayList ary) {
		if (maze[pt.x][pt.y] == 0) {
			maze[pt.x][pt.y] = 1;
			ary.add(pt);
			if (maze[end.x][end.y] != 1) {
				if (!(visit(maze, new Point(pt.x, pt.y + 1), end, ary)
						|| visit(maze, new Point(pt.x + 1, pt.y), end, ary)
						|| visit(maze, new Point(pt.x, pt.y - 1), end, ary) || visit(
							maze, new Point(pt.x - 1, pt.y), end, ary))) {
					ary.remove(ary.size() - 1);
					maze[pt.x][pt.y] = 0;
				}
			}
		}
		return maze[end.x][end.y] == 1;
	}

	private String[] findMore(int[][] maze, int startX, int startY, int endX,
			int endY) {
		return findMore(maze, new Point(startX, startY), new Point(endX, endY));
	}

	public String[] findMore(int[][] maze, Point start, Point end) {
		ArrayList pathAry = new ArrayList();
		int[][] copyMaze = arraycopy(maze);
		visitMore(copyMaze, start, end, new ArrayList(), pathAry);
		String[] pathStrAry = new String[pathAry.size()];
		System.arraycopy(pathAry.toArray(), 0, pathStrAry, 0, pathAry.size());
		return pathStrAry;
	}

	private void visitMore(int[][] maze, Point pt, Point end, ArrayList ary,
			ArrayList pathAry) {
		maze[pt.x][pt.y] = 1;
		ary.add(pt);

		if (pt.x == end.x && pt.y == end.y) {

			String path = getMaxePath(ary);
			pathAry.add(path);

		}

		if (maze[pt.x][pt.y + 1] == 0)
			visitMore(maze, new Point(pt.x, pt.y + 1), end, ary, pathAry);
		if (maze[pt.x + 1][pt.y] == 0)
			visitMore(maze, new Point(pt.x + 1, pt.y), end, ary, pathAry);
		if (maze[pt.x][pt.y - 1] == 0)
			visitMore(maze, new Point(pt.x, pt.y - 1), end, ary, pathAry);
		if (maze[pt.x - 1][pt.y] == 0)
			visitMore(maze, new Point(pt.x - 1, pt.y), end, ary, pathAry);

		ary.remove(ary.size() - 1);
		maze[pt.x][pt.y] = 0;
	}

	public int[][] arraycopy(int[][] maze) {
		int[][] copyMaze = new int[maze.length][];

		for (int i = 0; i < maze.length; i++) {
			copyMaze[i] = new int[maze[i].length];
			System.arraycopy(maze[i], 0, copyMaze[i], 0, maze[i].length);
		}
		return copyMaze;
	}

	public String getMaxePath(ArrayList ary) {
		StringBuffer path = new StringBuffer();
		for (int i = 0; i < ary.size(); i++) {
			Point p = (Point) ary.get(i);

			if (path.length() > 0) {
				path.append(",");
			}
			path.append(p.x);
			path.append(":");
			path.append(p.y);
		}
		step = ary.size() - 1;

		return path.toString();
	}

	public void print(int[][] srcMaze, String path) {
		int[][] answerMaze = arraycopy(srcMaze);

		String[] pathAry = path.split("[,]");
		for (int i = 0; i < pathAry.length; i++) {
			if (i + 1 < pathAry.length && pathAry.length - 1 <= power) {

				String[] xy = pathAry[i].split("[:]");
				String[] x2y2 = pathAry[i + 1].split("[:]");
				int x = Integer.parseInt(xy[0]);
				int y = Integer.parseInt(xy[1]);
				int x2 = Integer.parseInt(x2y2[0]);
				int y2 = Integer.parseInt(x2y2[1]);
				if (y2 > y && x2 == x) {
					System.out.print("R");
				} else if (x2 > x && y2 == y) {
					System.out.print("D");
				} else if (y > y2 && x2 == x) {
					System.out.print("L");
				} else if (x > x2 && y2 == y) {
					System.out.print("U");
				}
			}
		}
		if (pathAry.length - 1 <= power) {
			System.out.println();
		}

	}

	public static void main(String[] args) {
		while (scanner.hasNext()) {
			String temp[] = scanner.nextLine().split(" ");
			power = Integer.parseInt(temp[0]);
			X = Integer.parseInt(temp[1]);
			Y = Integer.parseInt(temp[2]);
			matrix = new String[X][Y];
			maze = new int[X + 2][Y + 2];

			if (power != 0 && X != 0 && Y != 0) {
				for (int i = 0; i < maze.length; i++) {
					for (int j = 0; j < maze.length; j++) {
						maze[i][j] = 2;
					}
				}

				for (int i = 0; i < X; i++) {
					String[] temp1 = scanner.nextLine().split("");
					for (int j = 0; j < Y; j++) {
						matrix[i][j] = temp1[j];
						if (matrix[i][j].equals("#")) {
							maze[i + 1][j + 1] = 2;
						} else {
							maze[i + 1][j + 1] = 0;

						}
					}
				}

				judge();
				step = 0;
			} else {
				System.exit(0);
			}

		}
	}

	private static void judge() {
		Main MouseVisit = new Main();

		int startX = 1;
		int startY = 1;

		int endX = X;
		int endY = Y;

		String[] pathAry = MouseVisit
				.findMore(maze, startX, startY, endX, endY);

		for (int i = pathAry.length - 1; i >= 0; i--) {
			String path = pathAry[i];

			MouseVisit.print(maze, path);

		}
	}
}