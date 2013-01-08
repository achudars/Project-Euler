import java.math.BigInteger;

public class PE015 {

	public static void main(String[] args) {

		// basically we are looking for central binomial coefficient (largest
		// number in the row) in Pascal's triangle
		// (2*n)! <--- upper
		// ----- <--------------- result
		// (n!)^2 <--- lower

		int n = 20;

		BigInteger upper = factorial(2 * n); // (2*n)!
		BigInteger lower = factorial(n).pow(2); // (n!)^2

		BigInteger result = upper.divide(lower);

		System.out.println("Answer: " + result);

	};

	public static BigInteger factorial(int n) {
		BigInteger product = BigInteger.ONE;
		if (n < 0) {
			return new BigInteger("-1");
		}
		/* Chain Multiply from 'n' to '1' */
		for (int c = n; c > 0; c--) {
			product = product.multiply(BigInteger.valueOf(c));
		}
		return product;
	};
}
