package problemset_1082;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
	public static String change(String str) {
		return str.replaceAll("(m|M)(a|A)(r|R)(s|S)(h|H)(t|T)(o|O)(m|M)(p|P)", "fjxmlhx");
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		while(in.hasNext()) {
			System.out.println(change(in.nextLine()));
		}
		in.close();
	}
}