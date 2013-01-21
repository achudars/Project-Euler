import java.util.ArrayList;

public class PE111 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long sum = 0;
		int target = 10;
		for (int i = 0; i < 10; i++)
			sum += S(target, i);
		System.out.println(sum);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	static ArrayList<String> enum_strings(int n, int d, int count) {
		ArrayList<String> numbers = new ArrayList<String>();
		if (n == 0) {
			numbers.add("");
		} else if (n == count) {
			String s = "";
			for (int i = 0; i < n; i++)
				s += Integer.toString(d);
			numbers.add(s);
		} else {
			for (int i = 0; i < 10; i++) {
				if (i == d)
					for (String s : enum_strings(n - 1, d, count - 1))
						numbers.add(Long.toString(i) + s);
				else
					for (String s : enum_strings(n - 1, d, count))
						numbers.add(Long.toString(i) + s);
			}
		}
		return numbers;
	}

	static ArrayList<Long> enum_primes(int n, int d, int count) {
		ArrayList<Long> numbers = new ArrayList<Long>();
		for (String s : enum_strings(n, d, count))
			if (s.charAt(0) != '0' && isPrime(Long.parseLong(s)))
				numbers.add(Long.parseLong(s));
		return numbers;
	}

	static int M(int n, int d) {
		int count = n;
		while (enum_primes(n, d, count).size() == 0)
			count -= 1;
		return count;
	}

	static int N(int n, int d) {
		return enum_primes(n, d, M(n, d)).size();
	}

	static long S(int n, int d) {
		long sum = 0;
		for (long i : enum_primes(n, d, M(n, d)))
			sum += i;
		return sum;
	}

	// prime number checking function
	public static boolean isPrime(long n) {
		if (n < 2)
			return false;
		if (n == 2 || n == 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		long sqrtN = (long) Math.sqrt(n) + 1;
		for (long i = 6L; i <= sqrtN; i += 6) {
			if (n % (i - 1) == 0 || n % (i + 1) == 0)
				return false;
		}

		return true;
	};

}
