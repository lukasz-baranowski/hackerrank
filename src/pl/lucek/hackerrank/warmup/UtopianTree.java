package pl.lucek.hackerrank.warmup;

import java.util.Scanner;

public class UtopianTree {

	public static void main(final String[] args) {
		final int[] cyclesTab = readInput();

		final int cyclesTabSize = cyclesTab.length;
		for (int i = 0; i < cyclesTabSize; i++) {
			final long height = calculateHeight(cyclesTab[i]);
			System.out.println(height);
		}
	}

	private static long calculateHeight(final int cycles) {
		long height = 1;
		for (int i = 1; i <= cycles; i++) {
			if (i%2==0) {
				height++;
			} else {
				height*=2;
			}
		}
		return height;
	}

	private static int [] readInput() {
		final Scanner in = new Scanner(System.in);
		final int testCasesNum = in.nextInt();
		final int [] testCases = new int[testCasesNum];
		for (int i = 0; i < testCasesNum; i++) {
			testCases[i] = in.nextInt();
		}
		in.close();
		return testCases;
	}

}
