public class PE136 {

	private static final int MAX = 50000000;
	private static byte[] counter = new byte[MAX + 1];

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		// (p+q)^2 - p^2 - (p-q)^2 = n
		// 4pq - p^2 = n
		// q = ( n + p^2 )/ 4p
		// since p^2 = 0 mod p, n must also have a factor p.
		// n = kp
		// q = ( kp + p^2 ) / 4p
		// q = ( k + p ) / 4
		// the sum p + k must be divisible by 4. define a such that a+p = 0 mod
		// 4
		// k = 4v + a
		// q = ( 4v + a + p )/ 4

		for (int i = 0; i < counter.length; i++) {
			counter[i] = 0;
		}

		for (long n = 1; n < MAX; n++) {

			long f = 0;

			long k = (int) Math.ceil((((n + 1.0) * 1.0) / 4.0));

			for (; k <= n - 1; k++) {
				f = (n * (4 * k - n));
				if (f >= 1 && f < MAX && counter[(int) f] <= 10) {
					counter[(int) f]++;
				} else if (f >= MAX) {
					break;
				}
			}

			if ((n == 1) || (n == MAX - 1) || (n % 20000 == 0)) {
				System.out.println("n = " + n);
			}

		}

		int total = 0;

		for (int s = 0; s <= MAX; s++) {
			if (counter[s] == 1)
				total++;
		}

		System.out.println("Count : " + total);

		System.out.println("Answer: " + total);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}
}
