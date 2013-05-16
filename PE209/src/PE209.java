public class PE209 {

	private static int[] len;
	private static int idx;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		idx = 0;
		len = new int[15];
		findCycles();
		long[][][] count = new long[2][2][50];
		count[0][0][1] = 1;
		count[1][1][1] = 1;
		count[0][1][1] = 0;
		count[1][0][1] = 0;
		for (int i = 2; i < 50; i++) {
			for (int j = 0; j <= 1; j++) {
				count[0][j][i] = count[0][j][i - 1] + count[1][j][i - 1];
				count[1][j][i] = count[0][j][i - 1];
			}
		}
		long ans = 1;
		for (int i = 0; i < idx; i++)
			ans *= count[0][1][len[i]] + count[1][0][len[i]]
					+ count[0][0][len[i]];
		System.out.println("Answer: " + ans);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	private static void findCycles() {
		boolean[] vis = new boolean[64];
		for (int i = 0; i < 64; i++) {
			if (vis[i])
				continue;
			int $a = (i & (1 << 5)) >> 5, $b = (i & (1 << 4)) >> 4, $c = (i & (1 << 3)) >> 3, $d = (i & (1 << 2)) >> 2, $e = (i & (1 << 1)) >> 1, $f = (i & (1 << 0)) >> 0;
			int a = $a, b = $b, c = $c, d = $d, e = $e, f = $f;
			int cnt = 0;
			do {
				vis[toInt(a, b, c, d, e, f)] = true;
				int temp = a;
				if (b == 1 && c == 1)
					temp = 1 - temp;
				a = b;
				b = c;
				c = d;
				d = e;
				e = f;
				f = temp;
				cnt++;
			} while (!(a == $a && b == $b && c == $c && d == $d && e == $e && f == $f));
			len[idx++] = cnt;
		}
	}

	private static int toInt(int a, int b, int c, int d, int e, int f) {
		return (f << 0) + (e << 1) + (d << 2) + (c << 3) + (b << 4) + (a << 5);
	}

}
