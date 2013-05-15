import java.util.ArrayList;
import java.util.List;

public class PE152 {

	// accuracy
	private static double eps = 1E-16;

	// excluded primes
	// 13 may appear only in 13, 39, 52 configuration. We take care of it later
	private static int[] exPrimes = { 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
			47, 53, 59, 61, 67, 71, 73, 79 };

	private Integer[] denoms = null;
	private double[] tails = null;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		double target = 0.5;
		int uplimit = 80;

		PE152 tt = new PE152();
		tt.buildDenoms(uplimit); // build array of all possible numbers
		tt.buildTails(); // build intermediate sums of the remaining tails

		// results without choosing 13:
		int num_no13 = tt.countPos(target - 0.25, 0, tt.denoms.length - 1);

		// results when choosing 13 (must be 13, 39, 52)
		int num_13 = 0;
		if (uplimit >= 52) {
			num_13 = tt.countPos(target - 0.25
					- (1.0 / (13 * 13) + 1.0 / (39 * 39) + 1.0 / (52 * 52)), 0,
					tt.denoms.length - 1);
		}

		System.out.println("There are " + (num_no13 + num_13)
				+ " sequences to reach " + target + " up to " + uplimit);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public int countPos(double target, int stInd, int endInd) {
		if (Math.abs(target) < eps)
			return 1;
		if (stInd > endInd)
			return 0;
		if (target < -eps) // took too many numbers such that target was passed
			return 0;
		if (this.tails[stInd] < target - eps) // cannot reach target even if
												// taking all next numbers
												// (compare to tail sum)
			return 0;

		return countPos(
				target - 1D
						/ (denoms[stInd].intValue() * denoms[stInd].intValue()),
				stInd + 1, endInd)
				+ countPos(target, stInd + 1, endInd);
	}

	// creates array of all numbers below uplimit that are not divisible by any
	// prime from exPrimes
	private void buildDenoms(int uplimit) {
		List<Integer> tempL = new ArrayList<Integer>();
		for (int i = 3; i <= uplimit; i++) {
			if (isStranger(i))
				tempL.add(new Integer(i));
		}
		this.denoms = (Integer[]) tempL.toArray(new Integer[tempL.size()]);
	}

	private static boolean isStranger(int num) {
		for (int i = 0; i < exPrimes.length; i++) {
			if (num % exPrimes[i] == 0)
				return false;
		}
		return true;
	}

	// vuild array of the tails sum of the the denoms (tails[i]=sum denoms[j]^-2
	// for j>=i).
	private void buildTails() {
		double tail = 0;
		this.tails = new double[denoms.length];
		for (int i = this.denoms.length - 1; i >= 0; i--) {
			tail += 1.0 / (denoms[i].intValue() * denoms[i].intValue());
			this.tails[i] = tail;
		}
	}

}
