import java.util.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Math.*;
import static java.lang.Integer.*;
import static java.lang.Long.*;
import static java.math.BigInteger.*;

public class PE176 {

	static int c[];// largest prime factor
	static int x[];// next prime
	static double log[];// natural log

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int n = args.length == 0 ? 47547 : parseInt(args[0]);
		int m = 2 * n + 1;// factorize (2n + 1)
		c = new int[m + 1];
		x = new int[m + 1];
		log = new double[m + 1];
		for (int i = 1; i <= m; i++)
			log[i] = log(i);// cache logs
		for (int i = 2; i <= m; i++) {// sieve
			if (c[i] == 0) {
				for (int j = i; j <= m; j += i) {
					c[j] = i;
				}
			}
		}
		c[m] = m + 5;// next prime is out of bounds
		for (int i = m - 1; i >= 2; i--) {// next prime
			if (c[i] == i) {
				x[i] = i;
			} else {
				x[i] = x[i + 1];
			}
		}
		for (int d = 1; d <= m; d += 2) {
			if (m % d == 0) {
				int e = (d - 1) >> 1;
				if (e > 0)
					e++;// times 2
				subok(m / d, 1L << e, e * log[2], 3, "2^" + e, m / d);
			}
		}
		System.out.println("Answer: " + min);
		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	static long min = Long.MAX_VALUE;
	static double mlg = log(min);

	static void subok(int m, long prod, double lg, int f, String ff, int max) {
		if (lg > mlg)
			return;
		if (m == 1) {// m is eradicated
			min = prod;
			mlg = lg;
			// out.println("min = " + min + " = " + ff);
		} else
			for (int d = 3; d <= max; d += 2) {
				if (m % d == 0) {
					long p = 1;
					int e = (d - 1) >> 1;
					for (int i = 0; i < e; i++)
						p *= f;
					subok(m / d, prod * p, lg + e * log[f], x[f + 1], ff + " "
							+ f + "^" + e, d);
				}
			}

	}

}
