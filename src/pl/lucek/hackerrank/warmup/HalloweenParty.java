package pl.lucek.hackerrank.warmup;

import java.util.Scanner;

public class HalloweenParty {

	private static int T;
	private static int[] cutsTab;
	
	public static void main(final String[] args) {
		readInput();

		for (int i = 0; i < T; i++) {
			final int cuts = cutsTab[i];

			final long pieces = calculatePieces(cuts);
			System.out.println(pieces);
		}
	}

	private static long calculatePieces(final int cuts) {
		final int halfWithoutRemainder = cuts / 2;
		final int vertical = halfWithoutRemainder;
		final int horizontal = halfWithoutRemainder + (cuts % 2);
		final long pieces = (long) vertical * horizontal;
		return pieces;
	}

	private static void readInput() {
		final Scanner in = new Scanner(System.in);
		T = in.nextInt();
		cutsTab = new int[T];
		for (int i = 0; i < T; i++) {
			cutsTab[i] = in.nextInt();
		}
		in.close();
	}

}
