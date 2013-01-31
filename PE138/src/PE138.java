
public class PE138 {


	public static void main(String[] args) {
		long startTime = System.nanoTime();

		
		int counter = 0;
		long sum = 0;
		// Pell's equations and Diophantine's Equation
		double D = Math.sqrt(5.0);
		double C1 = 2 + 1 * Math.sqrt(5.0);
		double C2 = 2 - 1 * Math.sqrt(5.0);

		double P1 = C1;
		double P2 = C2;

		for (int t = 3; t <= 26; t += 2) {
			P1 *= C1;
			P1 *= C1;
			P2 *= C2;
			P2 *= C1;

			double x = (P1 + P2) * 0.5;
			double y = ((P1 - P2) * 0.5 / D);
			counter++;

			System.out.println("x = " + (Math.round(x)) + " y = " + (Math.round(y)));

			sum += ((long) Math.round(y));
		}

		System.out.println("\nAnswer: " + sum);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
