import static java.lang.Math.sqrt;
import static java.lang.Math.floor;
import static java.lang.Math.abs;

public class PE218 {
	static long L;
	static int M;
	static int N;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		L = args.length == 0 ? (long) 1e16 : Long.parseLong(args[0]);
		M = (int) floor(sqrt(L));
		N = (int) floor(sqrt(M));
		BoolArray a = new BoolArray((M >> 2) + 1);
		short as[] = new short[(M >> 2) + 1];
		short bs[] = new short[(M >> 2) + 1];
		for (int j = 0; ((j << 2) + 3) <= N; j++) {
			int p = 0;
			for (int k = j; (p = ((j << 2) + 3) * ((k << 2) + 3)) <= M; k++) {
				a.set(p >> 2, true);
			}
		}
		for (int aa = 1; (aa * aa) << 1 <= M; aa++) {
			for (int bb = aa; aa * aa + bb * bb <= M; bb++) {
				if (gcd(aa, bb) != 1)
					continue;
				int n = aa * aa + bb * bb;
				if ((n & 3) == 1) {
					int k = n >> 2;
					as[k] = (short) aa;
					bs[k] = (short) bb;
				}
			}
		}
		int count = 0;
		int av[] = new int[100];
		int bv[] = new int[100];
		int cv = 0;
		for (int i = 1; (i << 2) + 1 <= M; i++) {
			if (!a.get(i)) {
				cv = 0;
				int n = (i << 2) + 1;
				for (int j = 1, k = 5; k * k <= n; j++, k += 4) {
					if (n % k == 0) {
						int ai = as[j];
						int bi = bs[j];
						while ((n /= k) % k == 0) {
							int aj = abs(ai * as[j] - bi * bs[j]);
							int bj = bi * as[j] + ai * bs[j];
							ai = aj;
							bi = bj;
						}
						if (cv == 0) {
							av[cv] = ai;
							bv[cv] = bi;
							cv++;
						} else
							for (int l = cv - 1; l >= 0; l--) {
								av[cv] = abs(ai * av[l] - bi * bv[l]);
								bv[cv] = bi * av[l] + ai * bv[l];
								int al = abs(ai * bv[l] - bi * av[l]);
								int bl = bi * bv[l] + ai * av[l];
								av[l] = al;
								bv[l] = bl;
								cv++;
							}
					}
				}
				if (n > 1) {
					int j = n >> 2;
					int ai = as[j];
					int bi = bs[j];
					if (cv == 0) {
						av[cv] = ai;
						bv[cv] = bi;
						cv++;
					} else
						for (int l = cv - 1; l >= 0; l--) {
							av[cv] = abs(ai * av[l] - bi * bv[l]);
							bv[cv] = bi * av[l] + ai * bv[l];
							int al = abs(ai * bv[l] - bi * av[l]);
							int bl = bi * bv[l] + ai * av[l];
							av[l] = al;
							bv[l] = bl;
							cv++;
						}
				}
				for (int j = 0; j < cv; j++) {
					long aa = av[j], bb = bv[j];
					long aA = abs(aa * aa - bb * bb), bB = ((aa * bb) << 1);
					long AA = abs(aA * aA - bB * bB), BB = ((aA * bB) << 1);
					long AAA = (AA & 1) == 0 ? AA >> 1 : AA, BBB = (AA & 1) == 0 ? BB
							: BB >> 1;
					long marea = ((AAA % 84) * (BBB % 84)) % 84;
					if (marea != 0) {
						if (gcd(AA, BB) != 1)
							continue;
						n = (i << 2) + 1;
						System.out.println(n + "^1. " + aa + "^2 + " + bb
								+ "^2");
						System.out.println(n + "^2. " + aA + "^2 + " + bB
								+ "^2");
						System.out.println(n + "^4. " + AA + "^2 + " + BB
								+ "^2");
						System.out.println("area = " + marea + " mod 84");
						count++;
					}
				}
			}
		}
		System.out.println("Answer: " + count);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	static class BoolArray {
		long values[];
		int n;

		BoolArray(int n) {
			this.n = n;
			values = new long[(n + ((1 << 6) - 1)) >> 6];
		}

		void set(int i, boolean b) {
			if (get(i) != b)
				values[i >> 6] ^= 1l << (i % 64);
		}

		boolean get(int i) {
			return (values[i >> 6] & (1l << (i % 64))) != 0;
		}
	}

}
