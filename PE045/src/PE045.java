public class PE045 {

	public static void main(String[] args) {

		// all HEXAGONAL numbers are also TRIANGLE numbers, so ignore TRAINGLE number calculation

		int p = 165;
		long pentagonal = calculatePentagon(p);
		int h = 144;
		long hexagonal = calculateHexagon(h);

		while (pentagonal != hexagonal) {
			h++;
			hexagonal = calculateHexagon(h);
			while (hexagonal > pentagonal) {
				p++;
				pentagonal = calculatePentagon(p);
			}
		}
		System.out.println("Answer: " + hexagonal);

	}

	// pentagonal number calculation
	public static long calculatePentagon(long n) {
		return (n * (3 * n - 1)) / 2;
	}

	// hexagonal number calculation
	public static long calculateHexagon(long n) {
		return (n * (2 * n - 1));
	}
}
