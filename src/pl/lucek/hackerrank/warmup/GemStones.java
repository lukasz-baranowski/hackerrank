package pl.lucek.hackerrank.warmup;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class GemStones {

	public static void main(final String[] args) {
		final String[] tab = readInput();

		final Set<Character> chars = new HashSet<>(); 
		final String first = tab[0];
		final int fSize = first.length();
		for (int i = 0; i < fSize; i++) {
			chars.add(first.charAt(i));
		}
		
		final int tabSize = tab.length;
		int counter = 0;
		for (final Iterator<Character> it = chars.iterator(); it.hasNext();) {
			final char current = it.next();
			boolean gem = true;
			for (int j = 1; j < tabSize; j++) {
				boolean candidate = false;
				final String rock = tab[j];
				final int rockSize = rock.length();
				for (int l = 0; l < rockSize; l++) {
					final char rockChar = rock.charAt(l);
					if (rockChar == current) {
						candidate = true;
						break;
					}
				}
				if (!candidate) {
					gem = false;
				}
			}
			if (gem) {
				counter++;
			}
		}
		System.out.println(counter);

	}

	private static String[] readInput() {
		final Scanner scanner = new Scanner(System.in);
		final int size = Integer.parseInt(scanner.nextLine());

		final String[] tab = new String[size];
		for (int i = 0; i < size; i++) {
			tab[i] = scanner.nextLine();
		}
		scanner.close();
		return tab;
	}

}
