public class PE148 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long n = 1000000000;
		long c = 1;
		long sum = 0;

		while (n > 0) {
			
			long k = 1;
			long i = 0;
			
			// checks divisibility by 7
			while (k * 7 < n) {
				k *= 7;
				i += 1;
			}
			
			long m = n / k;

			sum += c * m * (m + 1) / 2 * Math.pow(28, i);
			n -= k * m;
			c *= m + 1;
		}
		System.out.println("Answer: " + sum);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
