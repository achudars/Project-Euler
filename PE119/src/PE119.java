import java.util.Collections;
import java.util.Vector;

public class PE119 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long i, j, k, m;

		Vector<Long> v = new Vector();

		for (i = 2; i <= 100; i++) {
			k = i;
			for (j = 2; j <= 9; j++) {
				k *= i;
				m = sumOfDigits(k);
				if (m == i)
					v.add(k);
			}
		}
		Collections.sort(v);
		System.out.println("Answer: " + v.get(29));

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static int sumOfDigits(long x) {
		int sum = 0;
		for (; x > 0; x /= 10)
			sum += (x % 10);
		return sum;
	}
}
