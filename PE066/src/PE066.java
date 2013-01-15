import java.math.BigInteger;

public class PE066 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		final int THOUSAND = 1000;
		int sqrt = 1;
		int[][] pellEq = new int[2][];
		BigInteger[] xy;
		int DiophantineAtLargestX = 0;
		BigInteger largestX = BigInteger.ZERO;
		
		for (int Diophantine = 2; Diophantine <= THOUSAND; Diophantine++) {
			
			if ((sqrt + 1) * (sqrt + 1) == Diophantine) {
				sqrt++;
				continue;
			}
			
			pellEq[0] = new int[] { 0, 1, sqrt };
			pellEq[1] = new int[3];
			
			xy = new BigInteger[] { new BigInteger("" + sqrt), BigInteger.ONE };
			
			for (int i = 1; pellEq[0][2] != 2 * sqrt; i++) {
				
				pellEq[i % 2][0] = pellEq[(i - 1) % 2][2] * pellEq[(i - 1) % 2][1] - pellEq[(i - 1) % 2][0];
				pellEq[i % 2][1] = (Diophantine - pellEq[i % 2][0] * pellEq[i % 2][0]) / pellEq[(i - 1) % 2][1];
				pellEq[i % 2][2] = (sqrt + pellEq[i % 2][0]) / pellEq[i % 2][1];
				
				xy[i % 2] = xy[(i - 1) % 2].multiply( new BigInteger("" + pellEq[i % 2][2])).add(xy[i % 2]);
			
			}
			
			if (xy[1].compareTo(largestX) > 0) {
				largestX = xy[1];
				DiophantineAtLargestX = Diophantine;
			}
			
		}
		System.out.println("Answer: D = " + DiophantineAtLargestX + "; x = "
				+ largestX);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
