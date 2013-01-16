public class PE085 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		outer: for (int n = 2; n <= 100; n++) {
			for (int m = 2; m <= 100; m++) {
				if (positionRectangles(n, m) >= 2000000) {
					System.out.println("Answer: " + (n * m));
					break outer;
				}
			}
		}

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static long positionRectangles(long n, long m) {
		long combinations = 0L;

		combinations = (n * (n + 1) / 2) * (m * (m + 1) / 2);

		return combinations;
	}

}
