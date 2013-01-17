public class PE100 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		double max = Math.pow(10, 12);
		double last = 1;
		double base = 5;
		while (true) {
			double sqrt = base * base;
			double t = 0.5 + Math.sqrt(2 * sqrt - 1) / 2;
			double b = Math.sqrt(2 * Math.pow(t, 2) - 2 * t + 1) / 2 + 0.5;
			if (t > max) {
				System.out.println("Answer: " + (long) b);
				break;
			}
			double tmp = base;
			base = (base * 5) + (base - last);
			last = tmp;
		}

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
