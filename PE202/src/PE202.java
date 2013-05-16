import java.util.ArrayList;

public class PE202 {

	static long b = 12017639147l;
	static long d;
	static long m;
	static long[][] p;
	static ArrayList<Long>[] pTemp;
	static long[] primeFac;
	static int n;
	static long m2;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		init();
		primeFactor();
		computeComb();
		momentDeGloire();
		long end = System.currentTimeMillis();

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static void init() {
		d = (b + 3) / 2;
		if (d % 3 == 0 || d < 5)
			throw new ArithmeticException("There is no posible solution");
		if (d % 2 == 0) {
			if (d % 4 == 0) {
				m = -(long) Math.floor((-d + 6l) / 12.0);
				m2 = 2 * m - 1;
			} else {
				m = -(long) Math.floor((-d + 12l) / 12.0);
				m2 = m;
			}
		} else {
			m = -(long) Math.floor((-d + 3) / 6.0);
			m2 = 2 * m - 1;
		}
	}

	public static void primeFactor() {
		long prime = 5;
		long r = d;
		boolean isPresent = false;
		ArrayList<Long> a = new ArrayList<Long>();
		ArrayList<Long> pl = new ArrayList<Long>();
		pl.add(3l);
		pl.add(prime);
		while (r % 2 == 0) {
			r /= 2;
		}
		do {
			if (r % prime == 0) {
				if (!isPresent) {
					a.add(prime);
					isPresent = true;
				}
				r /= prime;
			} else {
				isPresent = false;
				boolean isPrime = false;
				while (!isPrime) {
					prime += 2;
					isPrime = true;
					long sqrt = (long) Math.sqrt(prime) + 1;
					for (int i = 0; i < pl.size() && pl.get(i) <= sqrt; i++) {
						isPrime &= (prime % pl.get(i) != 0);
					}
				}
				pl.add(prime);
			}
		} while (r != 1);
		n = a.size();
		primeFac = new long[n];
		int i = 0;
		for (Long l : a) {
			primeFac[i++] = l;
		}
	}

	public static void computeComb() {
		if (d % 4 != 2) {
			long[] temp = new long[n + 1];
			temp[0] = 2;
			System.arraycopy(primeFac, 0, temp, 1, n++);
			primeFac = temp;
		}
		p = new long[n][];
		pTemp = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			pTemp[i] = new ArrayList<Long>();
		}
		recurse(1, 0, 0);
		int j = 0;
		int g = 0;
		for (ArrayList<Long> al : pTemp) {
			p[j] = new long[al.size()];
			int k = 0;
			for (long l : al) {
				p[j][k++] = l;
				g++;
			}
			j++;

		}
	}

	public static void recurse(long result, int index, int level) {
		if (index >= n)
			return;
		for (int i = index; i < n; i++) {
			long temp = result * primeFac[i];
			pTemp[level].add(temp);
			recurse(temp, i + 1, level + 1);
		}

	}

	public static void momentDeGloire() {
		long temp = m2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < p[i].length; j++) {
				temp += (-1 + 2 * (i % 2))
						* (long) Math.floor(m2 * 1.0 / p[i][j]);
			}
		}
		System.out.println("Answer: " + (temp * 2));
	}

}
