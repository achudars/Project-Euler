public class PE187 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int limit = 100000000;
		byte[] semiprimes = new byte[limit];
		for (int p = 2; p < limit; p++) {
			if (semiprimes[p] == 0) {
				for (int j = 1; j * p < limit; j++) {
					semiprimes[j * p]++;
					int t = j;
					while (t % p == 0) {
						semiprimes[j * p]++;
						t = t / p;
					}
				}
			}
		}

		int result = 0;
		for (int i = 0; i < semiprimes.length; i++) {
			if (semiprimes[i] == 2)
				result++;
		}

		System.out.println("Answer: " + result);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
