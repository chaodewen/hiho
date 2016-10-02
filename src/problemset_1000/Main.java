package problemset_1000;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int x, y;
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		while(in.hasNext()) {
			x = in.nextInt();
			y = in.nextInt();
			System.out.println(x + y);
		}
		in.close();
	}
}