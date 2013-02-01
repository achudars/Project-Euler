public class PE139 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long counter = 0;
		double triangle[] = new double[12];
		triangle[0] = 0;
		triangle[1] = 3;

		int i = 1;

		while (perimeter(triangle[i]) < 100000000) {
			triangle[i + 1] = 6 * triangle[i] + 2 - triangle[i - 1];
			i += 1;
		}

		for (int z = 1; z < 11; ++z)
			counter += (100000000 / perimeter(triangle[z]));

		System.out.println("Answer: " + counter);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static double perimeter(double a) {
		return (a + (a + 1) + Math.sqrt(((a * a) + ((a + 1) * (a + 1)))));
	}

	public static double completeTriplet(double a) {
		return Math.sqrt(((a * a) + ((a + 1) * (a + 1))));
	}

	private final static boolean isPerfectSquare(long n) {
		if (n < 0)
			return false;

		switch ((int) (n & 0x3F)) {
		case 0x00:
		case 0x01:
		case 0x04:
		case 0x09:
		case 0x10:
		case 0x11:
		case 0x19:
		case 0x21:
		case 0x24:
		case 0x29:
		case 0x31:
		case 0x39:
			long sqrt;
			if (n < 410881L) {
				int i;
				float x2, y;

				x2 = n * 0.5F;
				y = n;
				i = Float.floatToRawIntBits(y);
				i = 0x5f3759df - (i >> 1);
				y = Float.intBitsToFloat(i);
				y = y * (1.5F - (x2 * y * y));

				sqrt = (long) (1.0F / y);
			} else {
				
				sqrt = (long) Math.sqrt(n);
			}
			return sqrt * sqrt == n;

		default:
			return false;
		}
	}

}
