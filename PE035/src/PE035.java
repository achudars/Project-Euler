public class PE035 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int count = 0;
		// loop through the range
		for (Integer i = 2; i < 1000000; i++) {
			if (isPrime(i)) {
				if (hasPrimeRotations(i)) {
					count++;
				}
			}
		}
		System.out.println("Answer: " + count);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

	public static boolean hasPrimeRotations(Integer number) {

		double length = (Math.pow(10, String.valueOf(number).length() - 1));
		int temp = number;
		// makes as many rotations as long as the number is prime
		for (int i = 1; i < String.valueOf(number).length(); i++) {

			int tail = (int) (temp / length);
			int head = (int) (temp % length);
			temp = (head * 10) + tail;
			// if at least 1 of the rotated numbers isn't prime return false
			if (!isPrime(temp)) {
				return false;
			}
		}
		return true;
	}

	// prime number checking function
	public static boolean isPrime(long n) {
		if (n < 2)
			return false;
		if (n == 2 || n == 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		long sqrtN = (long) Math.sqrt(n) + 1;
		for (long i = 6L; i <= sqrtN; i += 6) {
			if (n % (i - 1) == 0 || n % (i + 1) == 0)
				return false;
		}

		return true;
	};

}
