/* heap space must be increased */

public class PE214 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		PE214 prob = new PE214();
		int limit = 40000000;
		int chain = 25;

		int[] totients = prob.totient(limit);
		int[] chains = new int[limit];
		long sum = 0;

		chains[1] = 1;
		chains[2] = 2;
		for (int i = 3; i < chains.length; i++) {
			chains[i] = chains[totients[i]] + 1;
			if (chains[i] == chain && totients[i] == i - 1) {
				sum += i;
			}
		}

		System.out.println("Answer: " + sum);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public int[] totient(int limit) {
		int[] totient = new int[limit];
		for (int i = 1; i < totient.length; i++) {
			totient[i] = i;
		}
		for (int i = 2; i < limit; i++) {
			if (totient[i] == i) {
				int count = i;
				while (count < limit) {
					totient[count] = (int) (totient[count] * (1 - ((1.0 / (double) i))));
					count += i;
				}
			}
		}
		return totient;
	}
}
