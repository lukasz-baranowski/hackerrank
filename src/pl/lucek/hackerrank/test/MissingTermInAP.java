package pl.lucek.hackerrank.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MissingTermInAP {

	public static void main(final String[] args) {
		final String input = readInput(); 
		final String [] splittedLines = input.split("\n");
		
		final int linesNum = splittedLines.length;
		if (linesNum == 0 || linesNum == 1) {
			writeOutput(splittedLines[0]);
			return;
		}
		final String [] splitted = splittedLines[1].split(" ");
		final int size = splitted.length;
		final int [] splittedInt = new int[size];
		for(int i = 0; i < size; i++) {
			splittedInt[i] = Integer.parseInt(splitted[i]);
		}
		
		int diff = 0;
		int diffPrev = splittedInt[1] - splittedInt[0];
		int missing = 0;
		for (int i = 0; i < size; i++) {
			if (i < (size - 1)) {
				final int pom = splittedInt[i+1] - splittedInt[i];
				if (pom == diffPrev) {
					diff = pom;
				}
				diffPrev = diff;
				
				if (splittedInt[i] + diff != splittedInt[i+1]) {
					missing = splittedInt[i] + diff;
					break;
				}
				
			}
		}
		
		System.out.println(missing);
		// writeOutput(String.valueOf(missing));
	}

	private static String readInput() {
		final StringBuilder builder = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			String sCurrentLine;
			int counter = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				builder.append(sCurrentLine).append("\n");
				if (++counter == 2) {
					break;
				}
			}
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
		return builder.toString();
	}

	private static void writeOutput(final String content) {
		try {
			final BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
			output.write(content);
			output.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

}
