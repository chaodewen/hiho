package problemset_1039;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
	public static int times(StringBuilder sb_temp) {
		boolean sign = true;
		int len = sb_temp.length(), i = 0, j;
		while(sign) {
			sign = false;
			i = 0;
			while(i < sb_temp.length()) {
				j = i;
				while(j+1 < sb_temp.length() && sb_temp.charAt(i) == sb_temp.charAt(j+1)) {
					j++;
				}
				if(j+1 >= sb_temp.length()) {
					if(sb_temp.length() != 1 && j - i > 0) {
						sb_temp.delete(i, sb_temp.length());
						sign = true;
					}
					else {
						i++;
					}
				}
				else {
					if(j - i > 0) {
						sb_temp.delete(i, j+1);
						sign = true;
					}
					else {
						i++;
					}
				}
			}
		}
		return len - sb_temp.length();
	}
	public static int find(StringBuilder sb) {
		int max = 0, temp;
		for(int i = 0; i <= sb.length(); i ++) {
			StringBuilder sb_temp = new StringBuilder(sb);
			sb_temp.insert(i, 'A');
			temp = times(sb_temp);
			if(temp > max) {
				max = temp;
			}
		}
		for(int i = 0; i <= sb.length(); i ++) {
			StringBuilder sb_temp = new StringBuilder(sb);
			sb_temp.insert(i, 'B');
			temp = times(sb_temp);
			if(temp > max) {
				max = temp;
			}
		}
		for(int i = 0; i <= sb.length(); i ++) {
			StringBuilder sb_temp = new StringBuilder(sb);
			sb_temp.insert(i, 'C');
			temp = times(sb_temp);
			if(temp > max) {
				max = temp;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		int T;
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		T = in.nextInt();
		for(int i = 0; i < T; i++) {
			StringBuilder sb = new StringBuilder(in.next());
			System.out.println(find(sb));
		}
		in.close();
	}
}
