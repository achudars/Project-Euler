public class PE193 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		byte[] mu = new byte[1 << 25];
		mu[1] = 1;
		for (int i = 2; i < mu.length; i++)
			mu[i] = -1;
		for (int d = 2; 2 * d < mu.length; d++)
			for (int i = 2 * d; i < mu.length; i += d)
				mu[i] -= mu[d];
		long n = 1L << 50;
		long s = 0;
		for (long d = 1; d < mu.length; d++)
			s += mu[(int) d] * (n / (d * d));
		System.out.println("Answer: " + s);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
