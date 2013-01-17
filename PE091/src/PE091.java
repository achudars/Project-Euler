public class PE091 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		System.out.println("Answer: " + positionTriangles(50));

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static long positionTriangles(long size) {

		long combinations = size * size * 3;
		
		for (int x = 1; x <= size; x++) {
			for (int y = 1; y <= size; y++) {
				int fact = gcd(x, y);
				combinations += Math.min(y * fact / x, (size - x) * fact / y) * 2;
			}
		}

		return combinations;
	}

	public static int gcd(int p, int q) {
		if (q == 0) {
			return p;
		}
		return gcd(q, p % q);
	}

}
