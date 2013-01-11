public class PE005 {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		// There's no need to start from a smaller number, because we will be
		// traversing from 20 to 11
		// Numbers from 11 to 1 are excluded as they are multiples of the higher
		// numbers
		for (int i = 10; i <= 1000000000; i++) {
			if (i % 20 == 0 && i % 19 == 0 && i % 18 == 0 && i % 17 == 0
					&& i % 16 == 0 && i % 15 == 0 && i % 14 == 0 && i % 13 == 0
					&& i % 12 == 0 && i % 11 == 0) {
				System.out.println("Answer: " + i);
				break;
			}
		}
		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}
}
