public class PE197 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		double u1 = -1.0;
		double u2 = 0.0;
		boolean got_it = false;
		while (!got_it) {
			double test1 = Math.floor(Math.pow(2, 30.403243784 - u1 * u1)) * 1e-9;
			double test2 = Math
					.floor(Math.pow(2, 30.403243784 - test1 * test1)) * 1e-9;
			if (test1 == u2 && test2 == u1)
				got_it = true;
			else {
				u1 = test2;
				u2 = test1;
			}
		}
		System.out.println("Answer: " + (u1 + u2) );

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
