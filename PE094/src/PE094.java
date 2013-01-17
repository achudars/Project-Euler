public class PE094 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long sumOfP = 0;

		for (long p = 2; (getTrianglePerimeter(p, false) < 1000000000); p++) {
			if ((calculateTriangleArea(p, true) > 0)
					&& (getTrianglePerimeter(p, true) < 1000000000)) {
				sumOfP += getTrianglePerimeter(p, true);
			} else if (calculateTriangleArea(p, false) > 0) {
				sumOfP += getTrianglePerimeter(p, false);
			}
		}

		System.out.println("Answer: " + sumOfP);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static long calculateTriangleArea(long a, boolean bigger) {

		long temp = a * a * 3 - 1 + ((bigger) ? -2 * a : +2 * a);
		long sqRoot = (long) Math.sqrt(temp);

		if ((sqRoot * sqRoot) == temp) {
			sqRoot *= (a + 1);
			return ((sqRoot % 4) == 0) ? (sqRoot / 4) : -1;
		} else {
			return -1;
		}
	}

	public static long getTrianglePerimeter(long a, boolean bigger) {

		long perimeter = 0;

		perimeter = 3 * a + ((bigger) ? 1 : -1);

		return perimeter;
	}

}
