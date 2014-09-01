package pl.lucek.hackerrank.test;

import java.util.Scanner;

public class NumberOfPrimes {

	public static void main(final String[] args) {
		final Scanner in = new Scanner(System.in);
		int res;
		int _a;
		_a = in.nextInt();
		res = getNumberOfPrimes(_a);
		System.out.println(res);
		in.close();
	}

	static int getNumberOfPrimes(final int N) {
		int counter = 0;
		for (int i = 1; i <= N; i++) {
			if (isPrime(i)) {
				counter++;
			}
		}
		return counter;
	}

	static boolean isPrime(final int n) {
		// check if n is a multiple of 2
		if (n % 2 == 0)
			return false;
		// if not, then just check the odds
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}
