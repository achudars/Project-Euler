public class PE145 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int count = 0;

		for (int x = 1; x <= 100000000; x += 2) {
			if (isReversible(x))
				count += 2;
		}
		System.out.println("Answer: " + count);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static boolean isReversible(int n) {
		int c = n;
		int r = 0;

		while (c > 0) {
			r = (r * 10) + (c % 10);
			c /= 10;
		}

		r += n;

		while (((r % 10) & 1) > 0) {
			r /= 10;
		}
		if (r == 0)
			return true;
		else
			return false;
	}

}
