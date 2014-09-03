package pl.lucek.hackerrank.warmup;

import java.util.Scanner;

public class ServiceLane {

	private static int N;
	private static int T;
	private static int[] width;
	private static TestCase[] testCases;
	
	public static void main(final String[] args) {
		readInput();

		for (int k = 0; k < T; k++) {
			final TestCase testCase = testCases[k];
			int minWidth = 3;
			for (int l = testCase.i; l <= testCase.j; l++) {
				final int currWidth = width[l];
				if (currWidth < minWidth) {
					minWidth = currWidth;
				}
			}
			System.out.println(minWidth);
		}
	}

	private static class TestCase {
		int i;
		int j;
		TestCase(final int i, final int j) {
			this.i = i;
			this.j = j;
		}
	}

	private static void readInput() {
		final Scanner in = new Scanner(System.in);
		N = in.nextInt();
		T = in.nextInt();
		width = new int[N];
		for (int i = 0; i < N; i++) {
			width[i] = in.nextInt();
		}

		testCases = new TestCase[T];
		for (int i = 0; i < T; i++) {
			testCases[i] = new TestCase(in.nextInt(), in.nextInt());
		}
		in.close();
	}

}
