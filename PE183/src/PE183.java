import java.math.BigDecimal;
import java.util.Arrays;

public class PE183 {

	private static final double[] mem = new double[10001];

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int total = 0;

		Arrays.fill(mem, -1);
		long time = -System.currentTimeMillis();
		for (int n = 5; n <= 10000; n++) {
			total += d(n);
		}

		System.out.println("Answer: " + total);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	private static int d(int n) {
		return isTerminatingDecimal(n) ? -n : n;
	}

	private static boolean isTerminatingDecimal(int n) {
		int maxDiv = 1;

		double lna = (mem[n] == -1) ? (mem[n] = Math.log(n)) : mem[n];
		for (int b = 1; b <= n / 2; b++) {
			double lnb = (mem[b] == -1) ? (mem[b] = Math.log(b)) : mem[b], lnbm1 = (mem[b + 1] == -1) ? (mem[b + 1] = Math
					.log(b + 1)) : mem[b + 1];

			if (lna > ((1 + b) * lnbm1 - (b * lnb))) {
				maxDiv = b + 1;
			} else {
				break;
			}
		}

		try {
			BigDecimal num = BigDecimal.valueOf(n), div = BigDecimal
					.valueOf(maxDiv);

			num = num.divide(div);
			return true;
		} catch (ArithmeticException e) {
			return false;
		}
	}

}
