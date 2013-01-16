import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class PE087 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		List<Long> primeListX = new ArrayList<Long>();
		// fill the list with all primes till the limit
		for (Long i = 0L; i <= 8000; i++) {
			if (isPrime(i)) {
				primeListX.add(i);
			}
		}
		List<Long> primeListY = new ArrayList<Long>();
		// fill the list with all primes till the limit
		for (Long i = 0L; i <= 400; i++) {
			if (isPrime(i)) {
				primeListY.add(i);
			}
		}
		List<Long> primeListZ = new ArrayList<Long>();
		// fill the list with all primes till the limit
		for (Long i = 0L; i <= 100; i++) {
			if (isPrime(i)) {
				primeListZ.add(i);
			}
		}
		
		long FIFTYMILLION = 50000000L;

		SortedSet<Long> XYZ = new TreeSet<Long>();
		
		for (Long z : primeListZ) {
			for (Long y : primeListY) {
				long yz = z*z*z*z + y*y*y;
				if(yz > FIFTYMILLION) break;
				for (Long x : primeListX) {
					if ((x * x + yz) > FIFTYMILLION) {
						break;
					}
					//System.out.println("{" + x + "^2," + y + "^3," + z + "^4}=" + (x * x + y * y * y + z * z * z * z));
					XYZ.add((x * x + y * y * y + z * z * z * z));
				}
			}
		}
		
		// AFTER REMOVED DUPLICATES
		System.out.println("Answer: " + XYZ.size());

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

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
