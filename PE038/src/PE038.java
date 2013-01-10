import java.util.SortedSet;
import java.util.TreeSet;

public class PE038 {

	// I'm using sorted set because we need unique entries
	static SortedSet<Integer> elements = new TreeSet<Integer>();

	public static void main(String[] args) {

		permutation("12345678");
		Integer largestPan = 0;
		String concatenation = "";

		for (Integer m = 9; m < 10000; m++) {
			// n(1,2,3,4,5)
			concatenation = Integer.toString(m * 1) + Integer.toString(m * 2)
					+ Integer.toString(m * 3) + Integer.toString(m * 4)
					+ Integer.toString(m * 5);
			if (concatenation.length() == 9) {
				if (isPandigital(Integer.parseInt(concatenation))) {
					if (Integer.parseInt(concatenation) > largestPan) {
						largestPan = Integer.parseInt(concatenation);
					}
					System.out.println("n(1,2,3,4,5): " + concatenation + " | m = " + m);
				}

			}
			// n(1,2,3,4)
			concatenation = Integer.toString(m * 1) + Integer.toString(m * 2)
					+ Integer.toString(m * 3) + Integer.toString(m * 4);
			if (concatenation.length() == 9) {
				if (isPandigital(Integer.parseInt(concatenation))) {
					if (Integer.parseInt(concatenation) > largestPan) {
						largestPan = Integer.parseInt(concatenation);
					}
					System.out.println("n(1,2,3,4): " + concatenation + " | m = " + m);
				}
			}
			// n(1,2,3)
			concatenation = Integer.toString(m * 1) + Integer.toString(m * 2)
					+ Integer.toString(m * 3);
			if (concatenation.length() == 9) {
				if (isPandigital(Integer.parseInt(concatenation))) {
					if (Integer.parseInt(concatenation) > largestPan) {
						largestPan = Integer.parseInt(concatenation);
					}
					System.out.println("n(1,2,3): " + concatenation + " | m = " + m);
				}
			}
			// n(1,2)
			concatenation = Integer.toString(m * 1) + Integer.toString(m * 2);
			if (concatenation.length() == 9) {
				if (isPandigital(Integer.parseInt(concatenation))) {
					if (Integer.parseInt(concatenation) > largestPan) {
						largestPan = Integer.parseInt(concatenation);
					}
					System.out.println("n(1,2): " + concatenation + " | m = " + m);
				}
			}

		}

		System.out.println("Answer: " + largestPan);

	}

	public static void permutation(String str) {
		permutation("", str);
	}

	private static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0) {
			// System.out.println(prefix);;
			elements.add(Integer.parseInt(9 + prefix));

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

}
