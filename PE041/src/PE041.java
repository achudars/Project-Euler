import java.util.SortedSet;
import java.util.TreeSet;

public class PE041 {

	// I'm using sorted set because we need unique entries
	static SortedSet<Integer> elements = new TreeSet<Integer>();

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		String str = "";
		Integer largestPan = 0;

		for (Integer i = 1; i < 10; i++) {
			str = str + i.toString();
			permutation(str);

			for (Integer item : elements) {
				if (isPrime(item) && isPandigital(item) && item > largestPan) {
					largestPan = item;
				}
			}

		}

		System.out.println("Answer: " + largestPan);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

	public static void permutation(String str) {
		permutation("", str);
	}

	private static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0) {
			// System.out.println(prefix);;
			elements.add(Integer.parseInt(prefix));

		} else {
			for (int i = 0; i < n; i++)
				permutation(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1, n));
		}
	}

	static boolean isPandigital(int n) {
		int digits = 0;
		int count = 0;
		int tmp;

		for (; n > 0; n /= 10, ++count) {
			if ((tmp = digits) == (digits |= 1 << (n - ((n / 10) * 10) - 1)))
				return false;
		}

		return digits == (1 << count) - 1;
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

}
