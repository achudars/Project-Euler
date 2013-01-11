import java.util.HashSet;

public class PE051 {

	public static void main(String[] args) {

		long startTime = System.nanoTime();

		boolean[] primeArray = new boolean[1000000];
		int numOfPrimes = primeSieve(primeArray);
		// HashSet for speed
		HashSet<String> primes = makeArray(numOfPrimes, primeArray);
		primeArray = null;
		int head = 0;
		String smallestPrime = "999999";

		for (String p : primes) {
			for (int i = 0; i < 10; i++) {
				int position = 1;
				// push 0+1 ... 0+9 [1..9]
				for (int j = 1; j < 10; j++) {
					char bit = (char) (48 + ((i + j) % 10));

					boolean found = false;
					StringBuffer check = new StringBuffer();

					for (int k = 0; k < p.length(); k++) {
						if (p.charAt(k) == i + 48) {
							check.append(bit);
							found = true;
						} else {
							check.append(p.charAt(k));
						}
					}

					if (found && primes.contains(check.toString())) {
						position++;
					}
				}

				if (position > head) {
					head = position;
					smallestPrime = p;
				} else if (position == head) {
					if (p.compareTo(smallestPrime) < 0) {
						smallestPrime = p;
					}
				}
			}
		}
		System.out.println("Answer: " + smallestPrime);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

	private static int primeSieve(boolean[] array) {
		array[0] = true;
		array[1] = true;
		int c = 2;
		for (int j = 4; j < array.length; j += 2) {
			array[j] = true;
			c++;
		}

		for (int i = 3; i < Math.sqrt(array.length); i += 2) {
			if (array[i]) {
				continue;
			}

			int k = 2 * i;
			for (int j = i * i; j < array.length; j += k) {
				if (array[j]) {
					continue;
				}
				array[j] = true;
				c++;
			}
		}
		return array.length - c;
	}

	private static HashSet<String> makeArray(int n, boolean[] array) {

		HashSet<String> newArray = new HashSet<String>();

		for (int i = 0; i < array.length; i++) {
			if (!array[i]) {
				newArray.add(i + "");
			}
		}
		return newArray;
	}
}
