import java.util.BitSet;
import static java.lang.Math.min;
import static java.lang.Math.max;
import static java.lang.Math.sqrt;

public class PE196 {

	static int primeLimit = 5097382 + 1;
	static BitSet primeBits;
	static BitSet primeBits2;
	static BitSet primbitstrue;
	static BitSet primbitsall;
	static int[] primlist;
	static int primlistlength = 0;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		primeBits = new BitSet(primeLimit); // default: false
		primeBits.set(0); // true
		primeBits.set(1); // true
		for (int i = 2; i < primeLimit; i = primeBits.nextClearBit(i + 1)) {
			for (long j = ((long) i) * i; j < primeLimit; j = j + i) {
				primeBits.set((int) j); // true
			}
		}

		int n;
		long result;

		for (n = 3; n <= 9; n++) {
			result = solve(n);
			System.out.printf("S(%d) = %d%n", n, result);
		}

		n = 10000;
		result = solve(n);
		System.out.printf("S(%d) = %d%n", n, result);

		n = 5678027;
		result = solve(n);
		System.out.printf("S(%d) = %d%n", n, result);

		n = 7208785;
		long result2 = solve(n);
		System.out.printf("S(%d) = %d%n", n, result2);

		result += result2;
		System.out.println("Answer: " + result);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static long solve(int n) {
		long from = startOfNumbers(n - 2);
		long to = stopOfNumbers(n + 2);
		int number = (int) (to - from + 1);

		if (primeLimit < to) {
			primeBits2 = new BitSet(number); // default: false
			int to2 = (int) sqrt(to);
			for (int i = 2; i < to2; i = primeBits.nextClearBit(i + 1)) {
				for (int j = (int) ((from + i - 1) / i * i - from); j <= number; j += i) {
					primeBits2.set(j); // true
				}
			}
		}

		long result = 0;
		from = startOfNumbers(n);
		to = stopOfNumbers(n);
		
		for (long i = from; i <= to; i++) {
			if (!isPrime(i))
				continue;
			if (searchAt(i, n, true) > 1)
				result += i;
		}
		return result;
	}

	/*************************************************/
	public static int searchAt(long i, int n, boolean nest) {
		long from = startOfNumbers(n);
		long to = stopOfNumbers(n);

		long overAboveOne = startOfNumbers(n - 1);
		long toAboveOne = stopOfNumbers(n - 1);
		long diffAboveOne = from - overAboveOne;

		long overBelowOne = startOfNumbers(n + 1);
		long diffBelowOne = overBelowOne - from;

		int count = 0;
		long prime = 0;
		int numbers = 0;
		long aboveOne = i - diffAboveOne;
		long belowOne = i + diffBelowOne;

		for (long o = max(aboveOne - 1, overAboveOne); o <= min(aboveOne + 1, toAboveOne); o++) {
			if (!isPrime(o))
				continue;
			prime = o;
			numbers = n - 1;
			count++;
			if (count > 1)
				break;
		}
		if (count < 2)
			for (long u = max(belowOne - 1, overBelowOne); u <= belowOne + 1; u++) {
				if (!isPrime(u))
					continue;
				prime = u;
				numbers = n + 1;
				count++;
				if (count > 1)
					break;
			}
		if (count == 1 && nest) {
			count = searchAt(prime, numbers, false);
		}
		// System.out.printf( "Suche um %d in numbers %d: %d%n", i, n, count );
		return count;
	}

	static boolean isPrime(long z) {
		if (z < primeLimit)
			return !primeBits.get((int) z);
		int zz;
		if (z >= 25983272566154L)
			zz = (int) (z - 25983272566154L);
		else if (z >= 16119981111301L)
			zz = (int) (z - 16119981111301L);
		else if (z >= 49975004L)
			zz = (int) (z - 49975004L);
		else
			zz = (int) z;
		return !primeBits2.get(zz);
	}

	public static long startOfNumbers(int n) {
		return (((long) n * (n - 1L)) >> 1) + 1L;
	}

	public static long stopOfNumbers(int n) {
		return ((long) n * (n + 1L)) >> 1;
	}

}
