import java.util.HashSet;
import java.util.Set;

public class PE125 {

	static final long LIMIT = 100000000;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		Set<Long> numbers = new HashSet<Long>();
		int i = 1;
		while (i * i < LIMIT) {
			long sum = i * i + (i + 1) * (i + 1);
			int u = i + 2;
			while (sum < LIMIT) {
				if (sum < LIMIT && isPalindrome(sum))
					numbers.add(sum);
				sum += u * u;
				u++;
			}
			i++;
		}
		long sum = 0;
		for (long l : numbers)
			sum += l;
		System.out.println("Answer: " + sum);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	static boolean isPalindrome(long n) {
		String s = "" + n;
		for (int i = 0; i < s.length() >> 1; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		}
		return true;
	}

}
