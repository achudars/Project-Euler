public class PE026 {

	public static void main(String[] args) {

		// for [1-1000] <-- answer
		countDenominators(1000);
		// for [1-10000]
		// countDenominators(10000);
		// for [1-10000]
		// countDenominators(100000);

	}

	public static int countDenominators(int limit) {
		// Assume that each recurring block is n-1 digits long.
		// Then check the n-1th remainder against subsequent until a match is
		// found.

		int cycleLength = 0;
		int denominator = 0;
		int maxLength = 0;

		for (int n = 2; n <= limit; n++) {
			int rest = 1;
			int remainder;
			for (int i = 0; i < n; i++)
				rest = (rest * 10) % n;
			remainder = rest;
			cycleLength = 0;
			do {
				rest = (rest * 10) % n;
				cycleLength++;
			} while (rest != remainder);
			if (cycleLength > maxLength) {
				denominator = n;
				maxLength = cycleLength;
			}
		}
		System.out.printf("\nAnswer [1-" + limit + "]: %d", denominator);

		return denominator;

	}

}
