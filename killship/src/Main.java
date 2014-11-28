import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String data = input.nextLine();
			int Submarine_Count = Integer.parseInt(data.split(" ")[0]);
			int y_coordinate = Integer.parseInt(data.split(" ")[1]);
			if (Submarine_Count == 0 && y_coordinate == 0) {
				break;
			}
			int submarine_x_coor[] = new int[Submarine_Count];
			int submarine_y_coor[] = new int[Submarine_Count];
			for (int i = 0; i < Submarine_Count; i++) {
				String marine_coor = input.nextLine();
				submarine_x_coor[i] = Integer
						.parseInt(marine_coor.split(" ")[0]);
				submarine_y_coor[i] = Integer
						.parseInt(marine_coor.split(" ")[1]);
			}
			int x_coor_temp[] = submarine_x_coor.clone();
			
			Arrays.sort(x_coor_temp);
			Submarine DP_table[][] = new Submarine[y_coordinate + 1][x_coor_temp[x_coor_temp.length - 1] + 1];
			
			for (int i = 0; i < Submarine_Count; i++) {
				Submarine submarine = new Submarine();
				submarine.hits = 1;
				DP_table[y_coordinate - submarine_y_coor[i]][submarine_x_coor[i]] = submarine;
			}
			
			for (int i = 0; i < DP_table.length; i++) {
				for (int j = 0; j < DP_table[0].length; j++) {
					
					if (i == 0 && j == 0) {
						Submarine submarine = new Submarine();
						DP_table[i][j] = submarine;
					}
					
					else if (i != 0 && j == 0) {
						if (DP_table[i][j] == null) {
							Submarine submarine = new Submarine();
							submarine.hits += DP_table[i - 1][j].hits;
							submarine.tracelist = (ArrayList<int[]>) DP_table[i - 1][j].tracelist
									.clone();
							DP_table[i][j] = submarine;
						} else {
							DP_table[i][j].hits += DP_table[i - 1][j].hits;
							int[] xy = { j, i };
							DP_table[i][j].tracelist = (ArrayList<int[]>) DP_table[i - 1][j].tracelist
									.clone();
							DP_table[i][j].tracelist.add(xy);
						}

					}
					
					else if (i == 0 && j != 0) {
						if (DP_table[i][j] == null) {
							Submarine submarine = new Submarine();
							submarine.hits += DP_table[i][j - 1].hits;
							submarine.tracelist = (ArrayList<int[]>) DP_table[i][j - 1].tracelist
									.clone();
							DP_table[i][j] = submarine;
						} else {
							DP_table[i][j].hits += DP_table[i][j - 1].hits;
							int[] xy = { j, i };
							DP_table[i][j].tracelist = (ArrayList<int[]>) DP_table[i][j - 1].tracelist
									.clone();
							DP_table[i][j].tracelist.add(xy);
						}
					}
					
					else {
						if (DP_table[i][j] == null) {
							if (DP_table[i - 1][j].hits >= DP_table[i][j - 1].hits) {
								Submarine submarine = new Submarine();
								submarine.hits += DP_table[i - 1][j].hits;
								submarine.tracelist = (ArrayList<int[]>) DP_table[i - 1][j].tracelist
										.clone();
								DP_table[i][j] = submarine;
							} else {
								Submarine submarine = new Submarine();
								submarine.hits += DP_table[i][j - 1].hits;
								submarine.tracelist = (ArrayList<int[]>) DP_table[i][j - 1].tracelist
										.clone();
								DP_table[i][j] = submarine;
							}

						} else {
							if (DP_table[i - 1][j].hits >= DP_table[i][j - 1].hits) {
								DP_table[i][j].hits += DP_table[i - 1][j].hits;
								int[] xy = { j, i };
								DP_table[i][j].tracelist = (ArrayList<int[]>) DP_table[i - 1][j].tracelist
										.clone();
								DP_table[i][j].tracelist.add(xy);
							} else {
								DP_table[i][j].hits += DP_table[i][j - 1].hits;
								int[] xy = { j, i };
								DP_table[i][j].tracelist = (ArrayList<int[]>) DP_table[i][j - 1].tracelist
										.clone();
								DP_table[i][j].tracelist.add(xy);
							}
						}
					}
				}
			}
			int hit = DP_table[y_coordinate][x_coor_temp[x_coor_temp.length - 1]].hits;
			System.out.printf("%d\n", hit);
			for (int i = 0; i < hit; i++) {
				System.out.printf("%d %d\n",DP_table[y_coordinate][x_coor_temp[x_coor_temp.length - 1]].tracelist
				.get(i)[0],y_coordinate- DP_table[y_coordinate][x_coor_temp[x_coor_temp.length - 1]].tracelist
				.get(i)[1]);
			}
		}
	}

	static class Submarine {
		int hits = 0;
		ArrayList<int[]> tracelist = new ArrayList<int[]>();
	}
}