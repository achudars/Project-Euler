import java.util.ArrayList;
import java.util.List;

public class PE060 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int sum = 0;
		List<Integer> listOfPrimes = new ArrayList<Integer>();

		for (int i = 2; i < 10000; i++) {
			if (isPrime(i)) {
				listOfPrimes.add(i);
			}
		}

		outer : for (Integer item1 : listOfPrimes) {
			for (Integer item2 : listOfPrimes) {
				if (       isPrime(Integer.parseInt("" + item1 + item2))
						&& isPrime(Integer.parseInt("" + item2 + item1))) {
					for (Integer item3 : listOfPrimes) {
						if (       isPrime(Integer.parseInt("" + item1 + item3))
								&& isPrime(Integer.parseInt("" + item3 + item1))
								&& isPrime(Integer.parseInt("" + item2 + item3))
								&& isPrime(Integer.parseInt("" + item3 + item2))) {
							for (Integer item4 : listOfPrimes) {
								if (       isPrime(Integer.parseInt("" + item1 + item4))
										&& isPrime(Integer.parseInt("" + item4 + item1))
										&& isPrime(Integer.parseInt("" + item2 + item4))
										&& isPrime(Integer.parseInt("" + item4 + item2))
										&& isPrime(Integer.parseInt("" + item3 + item4))
										&& isPrime(Integer.parseInt("" + item4 + item3))) {
									for (Integer item5 : listOfPrimes) {
										if (       isPrime(Integer.parseInt("" + item1 + item5))
												&& isPrime(Integer.parseInt("" + item5 + item1))
												&& isPrime(Integer.parseInt("" + item2 + item5))
												&& isPrime(Integer.parseInt("" + item5 + item2))
												&& isPrime(Integer.parseInt("" + item3 + item5))
												&& isPrime(Integer.parseInt("" + item5 + item3))
												&& isPrime(Integer.parseInt("" + item4 + item5))
												&& isPrime(Integer.parseInt("" + item5 + item4))) {
											System.out.println(item1 + " " + item2 + " " + item3+ " " + item4+ " " + item5);
											sum = item1 + item2 + item3 + item4 + item5;
											break outer;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println("Answer: " + sum);
		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	// prime number checking function
	public static boolean isPrime(int n) {
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
