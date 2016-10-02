package problemset_1051;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
	public static int T, n, m;
	public static int[] data = new int[101];
	public static int find(int n, int m, int[] data) {
		if(m > n) {
			return 100;
		}
		else {
			int max = 0, temp;
			data[n] = 100 - data[n - 1];
			for(int i = n - 1; i >= 1; i --) {
				data[i] = data[i] - data[i - 1] - 1;
			}
			data[0] = data[0] - 1;
			for(int i = 0; i < n - m + 1; i ++) {
				temp = -1;
				for(int j = i; j < i + m + 1; j ++) {
					temp += data[j] + 1;
				}
				if(temp > max) {
					max = temp;
				}
			}
			return max;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		T = in.nextInt();
		for(int i = 0; i < T; i ++) {
			n = in.nextInt();
			m = in.nextInt();
			for(int j = 0; j < n; j ++) {
				data[j] = in.nextInt();
			}
			System.out.println(find(n, m, data));
		}
		in.close();
	}
}
