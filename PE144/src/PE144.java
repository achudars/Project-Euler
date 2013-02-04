public class PE144 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		double x = 1.4, y = -9.6, Vx = 1.4, Vy = -19.7;
		int reflections = 1;
		
		while (true) {
			double m = -4 * x / y;
			double tx = Vx;
			double ty = Vy;
			double YY = (2 * m);
			double XX = (1 - m * m);

			Vx = XX * tx + YY * ty;
			Vy = YY * tx - XX * ty;
			double t = -(8 * x * Vx + 2 * y * Vy) / (4 * Vx * Vx + Vy * Vy);

			x += t * Vx;
			y += t * Vy;
			if (x >= -0.01 && x <= 0.01 && y > 0)
				break;
			else
				++reflections;
		}
		
		System.out.println("Answer: " + reflections);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
