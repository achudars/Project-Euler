public class PE117 {
	static final int max = 50;

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		// recurrence equation
		long old4 = 2, old3 = 4, old2 = 8, old = 15;
		int i = 6;
		while (i <= max) {
			long f = old4 + old3 + old2 + old;
			old4 = old3;
			old3 = old2;
			old2 = old;
			old = f;
			i++;
		}
		System.out.println("Answer: " + old);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}
}
