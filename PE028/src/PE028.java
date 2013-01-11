public class PE028 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int result = 0;

		// upper left corner is n^2
		// upper right corner is n^2-n+1
		// lower left corner is n^2-2n+2
		// lower right corner is n^2-3n+3

		// sum of all corners is 4n^2-6n+6

		// loop through all corner sums from inner to outer
		for (int n = 3; n <= 1001; n += 2) {
			result += (4 * (n * n) - (6 * n) + 6);
		}
		// don't forget the center '1'
		result++;
		System.out.println("Answer: " + result);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

}
