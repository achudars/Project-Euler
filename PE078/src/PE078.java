import java.util.ArrayList;
import java.util.List;

public class PE078 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		// these are partitions (number theory)
		// Steve of Somerville, MA. 2000-11-16 Partition  Algorithm
		final long MILLION = 1000000L;
		final int max = 100001;

		List<Long> partitions = new ArrayList<Long>(max);
		partitions.add(1L);

		for (int numCoins = 1; numCoins < max; numCoins++) {
			long numPartition = 0L;
			int i = 1, m = 1;

			while (i > 0) {
				i = numCoins - (3 * m * m + m) / 2;

				if (i >= 0) {
					numPartition = (m % 2 == 0) ? numPartition - partitions.get(i) : numPartition + partitions.get(i);
				}

				i = numCoins - (3 * m * m - m) / 2;

				if (i >= 0) {
					numPartition = (m % 2 == 0) ? numPartition - partitions.get(i) : numPartition + partitions.get(i);
				}

				m += 1;
			}

			numPartition %= MILLION;

			if (numPartition == 0L) {
				System.out.println("Answer: " + numCoins);
				
			}

			partitions.add(numPartition);
		}

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

}
