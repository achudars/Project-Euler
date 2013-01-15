import java.math.BigInteger;
import java.util.ArrayList;

public class PE065 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int result = 0;

		ArrayList<Integer> contFractions = new ArrayList<Integer>();

		contFractions.add(2);

		for (int i = 0; i < 33; i++) {
			contFractions.add(1);
			contFractions.add((i + 1) * 2);
			contFractions.add(1);
		}

		BigInteger nominator = BigInteger.ONE;
		BigInteger denominator = BigInteger.valueOf(contFractions.get(contFractions.size() - 1));

		for (int i = contFractions.size() - 2; i >= 0; i--) {
			nominator = nominator.add(denominator.multiply(BigInteger.valueOf(contFractions.get(i))));

			BigInteger n = nominator;
			nominator = denominator;
			denominator = n;
		}

		// one additional swap is needed
		BigInteger n = nominator;
		nominator = denominator;
		denominator = n;

		String strNominator = nominator.toString();

		for (int i = 0; i < strNominator.length(); i++) {
			result += Integer.parseInt(Character
					.valueOf(strNominator.charAt(i)).toString());
		}

		System.out.println("Answer: " + result);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	private static int continuedFractionTerm(int i) {
		if (i == 0)
			return 2;
		else if (i % 3 == 2)
			return i / 3 * 2 + 2;
		else
			return 1;
	}

}
