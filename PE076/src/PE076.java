public class PE076 {

	public static void main(String args[]) {
		long startTime = System.nanoTime();

		// these are partitions (number theory)
		// use dynamic programming

		int number = 100;
		int[] partitions = new int[number + 1];
		partitions[0] = 1;

		for (int i = 1; i <= 99; i++) {
			for (int j = i; j <= number; j++) {
				partitions[j] += partitions[j - i];
			}
		}

		System.out.println("Answer: " + partitions[partitions.length - 1]);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

}
