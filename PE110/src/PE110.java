import java.util.ArrayList;
import java.util.Collections;

public class PE110 {

	private static ArrayList<Integer> p = new ArrayList<Integer>();
	static ArrayList<Long> v = new ArrayList<Long>();
	private static long cc = 100000000000000000l;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		primes();
		nest(0, 1, 10);
		Collections.sort(v);
		System.out.println("Answer: " + v.get(0));

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static long power(int n, int b) {
		return (long) Math.pow(n, b);
	}

	public static int nest(int p1, long s, int last) {
		int pc = p.get(p1), t, max = 0;
		long temp;
		if (p1 == p.size() - 1)
			return numSol(pf(pc * s));
		for (int i = 0; i <= last; i++) {
			temp = power(pc, i) * s;
			if (temp == 1) {
				continue;
			}
			if (temp > cc)
				break;
			t = numSol(pf(temp));
			if (t > 4000000)
				v.add(temp);
			if (t > max)
				max = t;
			t = nest(p1 + 1, temp, i);
			if (t > max)
				max = t;
		}
		return max;
	}

	public static void primes() {
		p.add(2);
		out: for (int i = 3; i < 50; i += 2) {
			for (int j = 0; j < p.size(); j++) {
				if (i % p.get(j) == 0)
					continue out;
			}
			p.add(i);
		}
	}

	public static int numSol(ArrayList<Integer> t) {
		if (t == null)
			return 0;
		int count = 1, temp, m = 1, t2;
		temp = t.size();
		for (int i = 0; i < temp; i++) {
			t2 = t.get(temp - 1 - i);
			count += t2 * m;
			m *= t2 * 2 + 1;
		}
		return count;
	}

	public static ArrayList<Integer> pf(long n) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		int last, count = -1;
		int t = (int) Math.sqrt(n), t2 = p.size(), t3;
		for (int i = 0; i < t2; i++) {
			if (count == 0)
				return null;
			t3 = p.get(i);
			if (t3 > t)
				break;
			last = count;
			count = 0;
			if (n % t3 == 0) {
				while (n % t3 == 0) {
					n /= t3;
					count++;
					if (count > last && last != -1)
						return null;
				}
				a.add(count);
				if (n == 1)
					break;
			}
		}
		if (a.size() == 0 || n > 1)
			a.add(1);
		Collections.sort(a);
		return a;
	}

}
