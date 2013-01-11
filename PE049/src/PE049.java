import java.util.HashMap;
import java.util.Map;

public class PE049 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		// Possible digits here are 1,2,3, and 4
		// possiblePermutations("1234", 4, new StringBuffer());
		String answer = null, first, second, third = "";

		for (Integer i = 1000; i < 10000; i++) {
			first = i.toString();
			second = Integer.toString((i + 3330));
			third = Integer.toString((i + 6660));

			if (isPrime(i) && isPrime(i + 3330) && isPrime(i + 6660)) {
				if (isPermutation(first, second) && isPermutation(first, third)) {
					System.out.println("[" + first + "," + second + "," + third
							+ "]");
					answer = first + second + third;
				}
			}
		}
		System.out.println("Answer: " + answer);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

	// prime number checking function
	public static boolean isPrime(long n) {
		if (n < 2)
			return false;
		if (n == 2 || n == 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		long sqrtN = (long) Math.sqrt(n) + 1;
		for (long i = 6L; i <= sqrtN; i += 6) {
			if (n % (i - 1) == 0 || n % (i + 1) == 0)
				return false;
		}

		return true;
	};

	private static void possiblePermutations(String input, int depth,
			StringBuffer output) {
		if (depth == 0) {
			if (isPrime(Long.parseLong(output.toString()))) {
				System.out.println(output);
			}
		} else {
			for (int i = 0; i < input.length(); i++) {
				output.append(input.charAt(i));
				possiblePermutations(input, depth - 1, output);
				output.deleteCharAt(output.length() - 1);
			}
		}
	}

	private static boolean isPermutation(String str1, String str2) {

		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();

		Map<Character, Integer> map1 = new HashMap<Character, Integer>();
		Map<Character, Integer> map2 = new HashMap<Character, Integer>();

		for (char c : chars1) {
			int occ = 1;
			if (map1.containsKey(c)) {
				occ = map1.get(c);
				occ++;
			}
			map1.put(c, occ);
		}

		// now do the same for chars2 and map2
		for (char c : chars2) {
			int occ = 1;
			if (map2.containsKey(c)) {
				occ = map2.get(c);
				occ++;
			}
			map2.put(c, occ);
		}

		if (map1.size() != map2.size()) {
			return false;
		}
		for (char c : map1.keySet()) {

			if (!map2.containsKey(c) || map1.get(c) != map2.get(c)) {
				return false;
			}
		}

		return true;
	}
}
