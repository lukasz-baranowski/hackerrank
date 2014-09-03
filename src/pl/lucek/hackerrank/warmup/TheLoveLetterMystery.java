package pl.lucek.hackerrank.warmup;

import java.util.Scanner;

public class TheLoveLetterMystery {

	private static int T;
	private static String[] words;

	public static void main(final String[] args) {
		readInput();

		final int wordsLength = words.length;
		for (int w = 0; w < wordsLength; w++) {
			final String word = words[w];

			String left = "";
			String right = "";
			final int length = word.length();
			if (length % 2 == 0) {
				left = word.substring(0, length / 2);
				right = word.substring(length / 2);
			} else {
				left = word.substring(0, length / 2);
				right = word.substring((length / 2) + 1);
			}

			int operations = 0;
			final int n = left.length();
			int rIdx = right.length() - 1;
			for (int i = 0; i < n; i++) {
				final char leftChar = left.charAt(i);
				final char rightChar = right.charAt(rIdx);
				rIdx--;
				if (leftChar > rightChar) {
					operations += countReduces(leftChar, rightChar);
				} else if (leftChar < rightChar) {
					operations += countReduces(rightChar, leftChar);
				} else {
					continue;
				}
			}
			System.out.println(operations);
		}
	}

	private static int countReduces(char from, final char to) {
		int counter = 0;
		while (true) {
			if (from > to) {
				from--;
				counter++;
			} else {
				break;
			}
		}
		return counter;
	}

	private static void readInput() {
		final Scanner in = new Scanner(System.in);
		T = in.nextInt();
		words = new String[T];
		for (int i = 0; i < T; i++) {
			words[i] = in.next();
		}
		in.close();
	}

}
