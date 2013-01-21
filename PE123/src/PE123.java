import java.util.ArrayList;

public class PE123 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		ArrayList<Long> a = primes();
		long temp = 0, max = 0, t, maxval = -1, maxp = -1;
		for (long i = 1; i < 111111; i += 2) {
			temp = a.get((int) (i - 1));
			t = (temp * i * 2l) % (temp * temp);
			if (t > max) {
				max = t;
				maxval = i;
				maxp = temp;
			}
			if (t > 10000000000l) {
				break;
			}
		}
		// System.out.println(max + " " + maxp + " " + maxval);

		System.out.println("Answer: " + maxval);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static ArrayList<Long> primes() {
		ArrayList<Long> p = new ArrayList<Long>();
		p.add(2l);
		p.add(3l);
		p.add(5l);
		p.add(7l);
		for (long i = 11; i < 250000; i += 2)
			if (isPrime(i))
				p.add(i);
		return p;
	}

	public static int prymes() {
		int count = 4;
		for (int i = 11; i < 50000000; i += 2)
			if (isPrime(i))
				count++;
		return count;
	}

	public static ArrayList<Integer> erast() {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 3; i < 50000000; i += 2) {
			a.add(i);
		}
		return a;
	}

	private static ArrayList<Integer> pf(int n) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		int temp = n;
		if (temp % 2 == 0) {
			while (temp % 2 == 0) {
				temp /= 2;
			}
			a.add(2);
		}
		int b = (int) Math.sqrt(temp);
		for (int i = 3; i <= b; i += 2) {
			if (temp % i == 0) {
				temp /= i;
				if (a.size() == 0 || a.get(a.size() - 1) != i)
					a.add(i);
				i -= 2;
			}
		}
		if (temp > 1)
			a.add(temp);
		return a;
	}

	public static boolean isPrime(long n) {
		int b = (int) Math.sqrt(n);
		for (int i = 3; i <= b; i += 2) {
			if (n % i == 0) {
				n /= i--;
				return false;
			}
		}
		return true;
	}

}
