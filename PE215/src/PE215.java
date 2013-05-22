import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;

public class PE215 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int n = 32;
		int m = 10;
		System.out.print("Answer: ");
		System.out.println("W(" + n + "," + m + ") = " + w(n, m));

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static final void generateRows(BitSet r, Collection<BitSet> rows,
			int pos, int n) {

		// Last brick
		if (pos >= n - 4) {
			if (pos == n - 4 || pos == n - 3) {
				rows.add(r);
			}
			return;
		}

		// Adds a 2x1 brick
		BitSet r2 = (BitSet) r.clone();
		r2.set(pos + 2);
		generateRows(r2, rows, pos + 2, n);

		// Adds a 3x1 brick
		BitSet r3 = (BitSet) r.clone();
		r3.set(pos + 3);
		generateRows(r3, rows, pos + 3, n);

		return;
	}

	public static final long w(int n, int m) {

		BitSet cracks = new BitSet(n - 1);
		ArrayList<BitSet> rows = new ArrayList<BitSet>();
		long[] swap;

		generateRows(cracks, rows, -1, n);

		// Checks which rows can be connected
		boolean[][] canConnect = new boolean[rows.size()][rows.size()];
		for (int i = 0; i < rows.size(); i++) {
			for (int j = 0; j <= i; j++) {
				canConnect[i][j] = !rows.get(i).intersects(rows.get(j));
				canConnect[j][i] = canConnect[i][j];
			}
		}

		// First row can be any
		long[] c = new long[rows.size()];
		Arrays.fill(c, 1);
		long[] nc = new long[rows.size()];

		// Adds a second row
		for (int i = 1; i < m; i++) {
			Arrays.fill(nc, 0);
			for (int j = 0; j < nc.length; j++) {
				for (int k = 0; k < nc.length; k++) {
					if (canConnect[j][k])
						nc[k] += c[j];
				}
			}

			// Prepares for next row
			swap = c;
			c = nc;
			nc = swap;
		}

		// Sums up the result
		long sum = 0;
		for (long l : c)
			sum += l;
		return sum;
	}

}
