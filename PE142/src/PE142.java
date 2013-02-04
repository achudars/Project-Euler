public class PE142 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long result = 0;
		
		long a = 0;
		long b = 0;
		long c = 0;
		for (a = 1; a <= 1000; a++) {
			for (b = a + 2; b <= 1000; b = b + 2) {
				long p = b * b;
				long q = a * a;
				long z = (p - q) / 2;
				long y = (p + q) / 2;

				for (c = 1; c <= 1000; c++) {
					long x = y + c * c;
					double r = x + y;
					double s = x + z;
					double t = x - z;
					if (Math.sqrt(r) % 1 == 0 && Math.sqrt(s) % 1 == 0
							&& Math.sqrt(t) % 1 == 0)
						result = x + y + z;
				}

			}
		}

		System.out.println("Answer: " + result);
		
		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}



}
