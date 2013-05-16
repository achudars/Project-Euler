public class PE184 {

	static int R = 105;
	static point[] Lattice = new point[4 * R * R];
	static long[] straight = new long[4 * R * R];
	static int Ln = 0;

	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	static point Origin = new point(0, 0);

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		for (int x = 0; x < R; x++)
			for (int y = 0; y < R; y++)
				if (x * x + y * y < R * R && !(x == 0 && y == 0)) {
					Lattice[Ln++] = new point(x, y);
					if (x > 0)
						Lattice[Ln++] = new point(-x, y);
					if (y > 0)
						Lattice[Ln++] = new point(x, -y);
					if (x > 0 && y > 0)
						Lattice[Ln++] = new point(-x, -y);
				}
		for (int i = 0; i < Ln; i++) {
			point curr = Lattice[i];
			if (curr.x == 0)
				straight[i] = 2 * (R - 1) - 1;
			else {
				int count = 0;
				int x = curr.x, y = curr.y, c = gcd(x, y);
				x /= c;
				y /= c;
				for (int jx = x;; jx += x) {
					int jy = jx / x * y;
					if (jx * jx + jy * jy >= R * R)
						break;
					count++;
				}
				straight[i] = 2 * count - 1;
			}
		}
		long ans = 0;
		for (int i = 0; i < Ln; i++) {
			long s = straight[i], a, b;
			a = b = (Ln - s) / 2;
			ans += 2 * a * b - a * (a - 1) / 2 - b * (b - 1) / 2 - s * (a + b)
					+ 3 * (s - 1) * (a + b) / 4;
		}
		System.out.println("Answer: " + (ans / 6) );

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

}

class point {
	int x, y;

	public point() {
	}

	public point(int xx, int yy) {
		x = xx;
		y = yy;
	}
}
