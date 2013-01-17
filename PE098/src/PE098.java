import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PE098 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		long startTime = System.nanoTime();

		Scanner scanner;
		try {
			scanner = new Scanner(new File("src/words.txt"));
		} catch (Exception e) {
			throw new RuntimeException("file not found");
		}
		scanner.useDelimiter(",");
		List<String> wordList = new LinkedList<String>();
		while (scanner.hasNext()) {
			String word = scanner.next();
			word = word.replaceAll("\"", "");
			wordList.add(word);
		}
		String[] words = wordList.toArray(new String[0]);

		Map<Integer, Set<Integer>> squares = new HashMap<Integer, Set<Integer>>();
		for (int i = 0; i < 10; i++) {
			squares.put(i, new HashSet<Integer>());
		}
		int n = 1;
		int square = 1;
		while (square < 1000000000) {
			int digits = ("" + square).length();
			squares.get(digits).add(square);
			n++;
			square = n * n;
		}

		int maxSquare = 0;
		for (int i = 0; i < words.length; i++) {
			String word1 = words[i];
			Set<Integer> possibleSquares = squares.get(word1.length());
			for (int j = i + 1; j < words.length; j++) {
				String word2 = words[j];
				if (isAnagram(word1, word2)) {
					square = getSquare(word1, word2, possibleSquares);
					if (square > maxSquare)
						maxSquare = square;
				}
			}
		}
		System.out.println("Answer: " + maxSquare);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	private static int getSquare(String word1, String word2,
			Set<Integer> possibleSquares) {
		Iterator<Integer> iterator = possibleSquares.iterator();
		int maxSquare = 0;
		while (iterator.hasNext()) {
			int square = iterator.next();
			Map<Character, Character> conversion = getConversion(word1, ""
					+ square);
			if (conversion == null)
				continue;
			int anaSquare = convertWord(word2, conversion);
			if (!possibleSquares.contains(anaSquare))
				continue;
			System.out.println(word1 + ":" + square + "," + word2 + ":"
					+ anaSquare);
			int tempMax = Math.max(square, anaSquare);
			if (tempMax > maxSquare)
				maxSquare = tempMax;
		}
		return maxSquare;
	}

	private static int convertWord(String word,
			Map<Character, Character> conversion) {
		String squareString = "";
		for (int i = 0; i < word.length(); i++) {
			squareString += conversion.get(word.charAt(i));
		}
		if (squareString.charAt(0) == '0')
			return -1;
		int square = Integer.parseInt(squareString);
		return square;
	}

	private static Map<Character, Character> getConversion(String word,
			String square) {
		Map<Character, Character> conversion = new HashMap<Character, Character>();
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			char digit = square.charAt(i);
			if (conversion.containsKey(letter)
					|| conversion.containsValue(digit)) {
				if (conversion.get(letter) == null
						|| conversion.get(letter) != digit)
					return null;
			}
			conversion.put(letter, digit);
		}
		return conversion;
	}

	private static boolean isAnagram(String word1, String word2) {
		char[] chars1 = word1.toCharArray();
		char[] chars2 = word2.toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		return Arrays.equals(chars1, chars2);
	}

}
