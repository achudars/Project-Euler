import java.util.Arrays;

public class PE178 {

	static boolean trace = true;
	static int tracelevel = 0;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int Limit = 40;
		if (args.length > 0) {
			Limit = Integer.parseInt(args[0]);
			if (Limit < 1) {
				Limit = 1;
			}
			System.out.println("Limit set to " + Limit);
		}

		long[][][][] a = new long[Limit][2][2][10];
		Arrays.fill(a[0][0][0], 1);
		Arrays.fill(a[0][0][1], 0);
		Arrays.fill(a[0][1][0], 0);
		Arrays.fill(a[0][1][1], 0);
		a[0][0][0][0] = 0;
		a[0][0][0][9] = 0;
		a[0][0][1][9] = 1;

		for (int n = 1; n < Limit; n++) {
			for (int digit = 0; digit < 10; digit++) {
				if (digit == 0) {
					a[n][1][0][digit + 1] += a[n - 1][1][0][digit];
					a[n][1][1][digit + 1] += a[n - 1][1][1][digit];
				} else if (digit == 1) {
					a[n][1][0][digit - 1] += a[n - 1][0][0][digit];
					a[n][0][0][digit + 1] += a[n - 1][0][0][digit];
					a[n][1][1][digit - 1] += a[n - 1][0][1][digit];
					a[n][0][1][digit + 1] += a[n - 1][0][1][digit];
					a[n][1][0][digit - 1] += a[n - 1][1][0][digit];
					a[n][1][0][digit + 1] += a[n - 1][1][0][digit];
					a[n][1][1][digit - 1] += a[n - 1][1][1][digit];
					a[n][1][1][digit + 1] += a[n - 1][1][1][digit];
				} else if (digit == 8) {
					a[n][0][0][digit - 1] += a[n - 1][0][0][digit];
					a[n][0][1][digit + 1] += a[n - 1][0][0][digit];
					a[n][1][0][digit - 1] += a[n - 1][1][0][digit];
					a[n][1][1][digit + 1] += a[n - 1][1][0][digit];
					a[n][0][1][digit - 1] += a[n - 1][0][1][digit];
					a[n][0][1][digit + 1] += a[n - 1][0][1][digit];
					a[n][1][1][digit - 1] += a[n - 1][1][1][digit];
					a[n][1][1][digit + 1] += a[n - 1][1][1][digit];
				} else if (digit == 9) {
					a[n][0][1][digit - 1] += a[n - 1][0][1][digit];
					a[n][1][1][digit - 1] += a[n - 1][1][1][digit];
				} else {
					a[n][0][0][digit - 1] += a[n - 1][0][0][digit];
					a[n][0][0][digit + 1] += a[n - 1][0][0][digit];
					a[n][0][1][digit - 1] += a[n - 1][0][1][digit];
					a[n][0][1][digit + 1] += a[n - 1][0][1][digit];
					a[n][1][0][digit - 1] += a[n - 1][1][0][digit];
					a[n][1][0][digit + 1] += a[n - 1][1][0][digit];
					a[n][1][1][digit - 1] += a[n - 1][1][1][digit];
					a[n][1][1][digit + 1] += a[n - 1][1][1][digit];
				}
			}
		}

		long result = 0;
		for (int n = 0; n < Limit; n++) {
			for (int digit = 0; digit < 10; digit++) {
				result = result + a[n][1][1][digit];
			}
		}

		System.out.println("Answer: " + result);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
