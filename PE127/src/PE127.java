public class PE127 {

	private static boolean[] notprime;
	private static int[] eadj, eprev, elast, radList, rad;
	private static int eidx, ridx, lim = 120000;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		init();
		int sum = 0;
		for (int c = 1; c < lim; c++)
			for (int i = 0; i < ridx
					&& ((c % 2 == 0) ? 3 : 2) * radList[i] * rad[c] < c; i++) {
				int n = radList[i] * rad[c];
				if (rad[n] != n)
					continue;
				for (int e = elast[radList[i]]; e != -1; e = eprev[e]) {
					int j = eadj[e];
					if (2 * j > c)
						break;
					if ((long) rad[c - j] * n < c) {
						sum += c;
					}
				}
			}
		System.out.println("Answer: " + sum);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	private static void init() {
		// compute primes & radicals
		rad = new int[lim + 1];
		notprime = new boolean[lim + 1];
		for (int i = 1; i <= lim; i++)
			rad[i] = 1;
		for (int i = 2; i <= lim; i++) {
			if (notprime[i])
				continue;
			for (int j = i; j < rad.length; j += i) {
				notprime[j] = true;
				rad[j] *= i;
			}
		}
		// sorted radical list -> graph
		int lim_2 = lim >> 1;
		eadj = new int[lim_2 + 1];
		eprev = new int[lim_2 + 1];
		elast = new int[lim_2 + 1];
		eidx = 0;
		for (int i = lim_2; i >= 1; i--)
			addEdge(rad[i], i);
		radList = new int[lim_2 + 1];
		ridx = 0;
		for (int i = 1; i < lim_2; i++)
			if (elast[i] != 0)
				radList[ridx++] = rad[i];
	}

	private static void addEdge(int a, int b) {
		eadj[eidx] = b;
		eprev[eidx] = elast[a];
		elast[a] = eidx++;
	}
}
