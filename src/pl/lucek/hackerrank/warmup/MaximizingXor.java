package pl.lucek.hackerrank.warmup;

import java.util.Scanner;

public class MaximizingXor {

	private static int L;
	private static int R;

	public static void main(final String[] args) {
		readInput();

		final int max = maxXor(L, R);
		System.out.println(max);
	}

	private static int maxXor(final int l, final int r) {
		int max = 0;
		for (int i = l; i <= r; i++) {
			for (int j = l; j <= r; j++) {
				final int xor = i ^ j;
				if (max < xor) {
					max = xor;
				}
			}
		}
		return max;
	}

	private static void readInput() {
		final Scanner in = new Scanner(System.in);
		L = in.nextInt();
		R = in.nextInt();
		in.close();
	}

}
