public class PE009 {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		for (int a = 1; a < 998; a++) {
			for (int b = 2; b < 999; b++) {
				for (int c = 3; c < 1000; c++) {
					if ((a * a) + (b * b) == (c * c) && (a < b) && (b < c)
							&& (a + b + c) == 1000) {
						System.out.println("A: " + a);
						System.out.println("B: " + b);
						System.out.println("C: " + c);
						System.out.println("A + B + C: " + (a + b + c));
						System.out.println("Answer (Product of ABC) : " + (a * b * c));
					}
				}
			}
		}
		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}