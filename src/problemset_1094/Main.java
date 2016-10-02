package problemset_1094;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int x, y;
	Point() {}
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static char[][] maze = new char[201][201];
	public static char[][] now = new char[4][4];
	public static boolean accord1(int x, int y) {
		for(int i = 0; i < 3; i ++) {
			for(int j = 0; j < 3; j ++) {
				if(now[i][j] != maze[x+i-1][y+j-1]) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean accord2(int x, int y) {
		for(int i = 0; i < 3; i ++) {
			if(now[i][2] != maze[x-1][y+i-1]) {
				return false;
			}
		}
		for(int i = 0; i < 3; i ++) {
			if(now[i][1] != maze[x][y+i-1]) {
				return false;
			}
		}
		for(int i = 0; i < 3; i ++) {
			if(now[i][0] != maze[x+1][y+i-1]) {
				return false;
			}
		}
		return true;
	}
	public static boolean accord3(int x, int y) {
		for(int i = 0; i < 3; i ++) {
			for(int j = 0; j < 3; j ++) {
				if(now[2-i][2-j] != maze[x+i-1][y+j-1]) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean accord4(int x, int y) {
		for(int i = 0; i < 3; i ++) {
			if(now[2-i][0] != maze[x-1][y+i-1]) {
				return false;
			}
		}
		for(int i = 0; i < 3; i ++) {
			if(now[2-i][1] != maze[x][y+i-1]) {
				return false;
			}
		}
		for(int i = 0; i < 3; i ++) {
			if(now[2-i][2] != maze[x+1][y+i-1]) {
				return false;
			}
		}
		return true;
	}
	public static void find(int m, int n) {
		Queue<Point> que = new LinkedList<Point>();
		for(int i = 1; i < n - 1; i ++) {
			for(int j = 1; j < m - 1; j ++) {
				if(accord1(i, j) || accord2(i, j) || accord3(i, j) || accord4(i, j)) {
					que.add(new Point(i+1, j+1));
				}
			}
		}
		Point p = new Point();
		while(!que.isEmpty()) {
			p = que.poll();
			System.out.println(p.x + " " + p.y);
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		int n = in.nextInt(), m = in.nextInt();
		for(int i = 0; i < n; i ++) {
			String temp = in.next();
			for(int j = 0; j < m; j ++) {
				maze[i][j] = temp.charAt(j);
			}
		}
		for(int i = 0; i < 3; i ++) {
			String temp = in.next();
			for(int j = 0; j < 3; j ++) {
				now[i][j] = temp.charAt(j);
			}
		}
		find(m, n);
		in.close();
	}
}
