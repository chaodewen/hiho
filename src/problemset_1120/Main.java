package problemset_1120;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] data = new int[11][11];
	static int[][] safe = new int[11][11];
	static int n, m;
	public static void set(int x, int y, int value) {
		if(x == 0 && y == 0) {
			safe[x][y+1] = value;
			safe[x+1][y+1] = value;
			safe[x+1][y] = value;
		}
		else if(x == 0 && y == m - 1) {
			safe[x][y-1] = value;
			safe[x+1][y-1] = value;
			safe[x+1][y] = value;
		}
		else if(x == n - 1 && y == 0) {
			safe[x-1][y] = value;
			safe[x-1][y+1] = value;
			safe[x][y+1] = value;
		}
		else if(x == n - 1 && y == m - 1) {
			safe[x][y-1] = value;
			safe[x-1][y-1] = value;
			safe[x-1][y] = value;
		}
		else if(x == 0) {
			safe[x][y-1] = value;
			safe[x+1][y-1] = value;
			safe[x+1][y] = value;
			safe[x+1][y+1] = value; 
			safe[x][y+1] = value;
		}
		else if(x == n - 1) {
			safe[x][y-1] = value;
			safe[x-1][y-1] = value;
			safe[x-1][y] = value;
			safe[x-1][y+1] = value; 
			safe[x][y+1] = value;
		}
		else if(y == 0) {
			safe[x-1][y] = value;
			safe[x-1][y+1] = value;
			safe[x][y+1] = value;
			safe[x+1][y+1] = value; 
			safe[x+1][y] = value;
		}
		else if(y == m - 1) {
			safe[x-1][y] = value;
			safe[x-1][y-1] = value;
			safe[x][y-1] = value;
			safe[x+1][y-1] = value; 
			safe[x+1][y] = value;
		}
		else {
			safe[x-1][y-1] = value;
			safe[x-1][y] = value;
			safe[x-1][y+1] = value;
			safe[x][y-1] = value; 
			safe[x][y+1] = value;
			safe[x+1][y-1] = value;
			safe[x+1][y] = value;
			safe[x+1][y+1] = value;
		}
	}
	public static void search() {
		
	}
	public static void find() {
		Arrays.fill(safe, 0);
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < m; j ++) {
				if(data[i][j] == 0) {
					set(i, j, -3); // no mines
				}
			}
		}
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < m; j ++) {
				if(data[i][j] == 8) {
					set(i, j, 4); // there are mines
				}
			}
		}
		search();
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		int T = in.nextInt();
		for(int i = 0; i < T; i ++) {
			n = in.nextInt();
			m = in.nextInt();
			for(int j = 0; j < n; j ++) {
				for(int k = 0; k < m; k ++) {
					data[i][k] = in.nextInt();
				}
			}
			find();
		}
		in.close();
	}
}
