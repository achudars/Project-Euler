import java.math.BigInteger;

public class PE055 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		BigInteger origin = BigInteger.ZERO;
		BigInteger reverse = BigInteger.ZERO;
		int iterations = 1;

		int counter = 0;

		for (Integer i = 11; i < 10000; i++) {
			origin = BigInteger.valueOf(i);
			iterations = 1;
			reverse = reverseInt(origin);

			while (iterations < 51) {
				if (isPalindrome("" + (reverse.add(origin)))) {
					//if (iterations > 1)
					//System.out.println(i + " => "
					//		+ (reverse.add(origin)) + " at " + iterations
					//		+ " iterations.");
					iterations = 51;
				} else {
					if (iterations == 50){
						//System.out.println("Lychrel number: " + i);
						counter++;
					}
					iterations++;
					origin = reverse.add(origin);
					reverse = reverseInt(origin);
				}
			}

		}
		System.out.println("Answer: " + counter);
		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

	// palindrome check for strings
	private static boolean isPalindrome(String toBePalindromed) {
		String comparedPart = new StringBuffer(toBePalindromed).reverse()
				.toString();
		if (toBePalindromed.equals(comparedPart)) {
			return true;
		} else {
			return false;
		}

	}

	public static BigInteger reverseInt(BigInteger origin) {
		String a = "" + origin;
		//System.out.println("a: " + a);
		char[] chars = a.toCharArray();
		char[] reversedChars = new char[chars.length];
		int placement = 0;
		for (int i = chars.length - 1; i >= 0; i--) {
			reversedChars[placement] = chars[i];
			placement++;
		}
		String out = String.copyValueOf(reversedChars);
		return new BigInteger(out);
	}

}
