public class PE204 {

	static int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
			47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 };

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		System.out.println("Answer: " + hamming(1000000000, primes.length - 1));

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	private static int hamming(int i, int j) {
		if (j == 0)
			return (int) (Math.log(i) / Math.log(2)) + 1;
		else {
			int result = 0;
			while (i > 0) {
				result += hamming(i, j - 1);
				i /= primes[j];
			}
			return result;
		}
	}

}
