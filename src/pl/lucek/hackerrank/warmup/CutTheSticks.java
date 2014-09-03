package pl.lucek.hackerrank.warmup;

import java.util.Scanner;

public class CutTheSticks {

	private static int N;
	private static int[] sticks;
	
	public static void main(final String[] args) {
		readInput();
		
		while (true) {
			int min = Integer.MAX_VALUE;
			final int length = sticks.length;
			System.out.println(length);
			for (int i = 0; i < length; i++) {
				final int current = sticks[i];
				if (min > current) {
					min = current;
					if (min == 1) {
						break;
					}
				}
			}
			for (int i = 0; i < sticks.length; i++) {
				final int current = sticks[i];
				boolean isRemoval = false;
				if (current == min) {
					final int newLength = sticks.length - 1;
					final int[] withRemoved = new int[newLength];
					for (int j = 0; j < newLength; j++) {
						withRemoved[j] = sticks[(j < i) ? j : (j + 1)];
					}
					sticks = withRemoved;
					isRemoval = true;
				} else {
					sticks[i] = current - min;
				}
				if (isRemoval) {
					i--;
				}
			}
			if (sticks.length == 0) {
				break;
			}
		}
	}

	private static void readInput() {
		final Scanner in = new Scanner(System.in);
		N = in.nextInt();
		sticks = new int[N];
		for (int i = 0; i < N; i++) {
			sticks[i] = in.nextInt();
		}
		in.close();
	}

}
