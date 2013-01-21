public class PE104 {

	static final double g = (Math.sqrt(5) + 1) / 2;

	static int i = 3;
	static long prev = 1;
	static long prevprev = 1;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		while (!isPermutation(fibLast10()) || !isPermutation(fibFirst10())) {
			i++;
		}
		System.out.println("Answer: " + i);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static long fibFirst10() {
		double temp = i * Math.log10(g) + Math.log10(1 / Math.sqrt(5));
		return (long) (Math.pow(10, temp - (int) temp + 8));
	}

	public static long fibLast10() {
		long temp = prev;
		prev = prev + prevprev % 10000000000L;
		prevprev = temp;
		return prev;
	}

	public static boolean isPermutation(long t) {
		boolean[] digits = new boolean[10];
		for (int i = 0; i < 9; i++) {
			if (digits[(int) (t % 10)])
				return false;
			digits[(int) (t % 10)] = true;
			t /= 10;
		}
		return !digits[0];
	}

}
