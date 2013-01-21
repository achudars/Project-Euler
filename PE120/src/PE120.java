public class PE120 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int sum = 0;
		int i, p;

		for (i = 3, p = 2; i <= 1000; i += 2, p += 2) {
			sum += (i * p);
			sum += ((i + 1) * p);
		}
		System.out.println("Answer: " + sum);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

}
