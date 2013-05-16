public class PE182 {

	static long p = 1009;
	static long q = 3643;

	static long phi = (p - 1) * (q - 1);

	static long gcd(long x, long y) {
		long r;
		while (y != 0) {
			r = x % y;
			x = y;
			y = r;
		}
		return x;
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long min = Long.MAX_VALUE;
		long number_of_unconcealed_messages;

		long ans = 0;

		for (long e = 2; e < phi; e++)
			if (gcd(e, phi) == 1) {
				number_of_unconcealed_messages = (gcd(e - 1, p - 1) + 1)
						* (gcd(e - 1, q - 1) + 1);

				if (number_of_unconcealed_messages < min) {
					ans = 0;
					min = number_of_unconcealed_messages;
				}

				if (number_of_unconcealed_messages == min)
					ans += e;
			}

		System.out.println("Answer: " + ans);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
