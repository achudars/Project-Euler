import java.math.BigInteger;

public class PE008 {

	public static void main(String[] args) {
		BigInteger series = new BigInteger(
				"7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450");

		BigInteger set = new BigInteger("100000");
		BigInteger divisor = new BigInteger("10");
		BigInteger divisor2 = new BigInteger("100");
		BigInteger divisor3 = new BigInteger("1000");
		BigInteger divisor4 = new BigInteger("10000");

		BigInteger greatestProduct = new BigInteger("1");
		BigInteger tempGreatestProduct = new BigInteger("1");

		while (series.compareTo(set) == 1) {
			// get the remainder
			BigInteger remainder = series.remainder(set);

			BigInteger first = remainder.remainder(divisor);
			BigInteger second = remainder.remainder(divisor2).divide(divisor);
			BigInteger third = remainder.remainder(divisor3).divide(divisor2);
			BigInteger fourth = remainder.remainder(divisor4).divide(divisor3);
			BigInteger fifth = remainder.remainder(set).divide(divisor4);

			// check for zero
			if (first.compareTo(BigInteger.ZERO) == 1
					&& second.compareTo(BigInteger.ZERO) == 1
					&& third.compareTo(BigInteger.ZERO) == 1
					&& fourth.compareTo(BigInteger.ZERO) == 1
					&& fifth.compareTo(BigInteger.ZERO) == 1) {

				tempGreatestProduct = tempGreatestProduct.multiply(first)
						.multiply(second).multiply(third).multiply(fourth)
						.multiply(fifth);

				// if tempGreatestProduct > greatestProduct
				if (tempGreatestProduct.compareTo(greatestProduct) == 1) {
					// set the greatest product
					greatestProduct = greatestProduct.multiply(
							BigInteger.valueOf(0)).add(tempGreatestProduct);
				}
			}
			series = series.divide(divisor);
			tempGreatestProduct = tempGreatestProduct.multiply(
					BigInteger.valueOf(0)).add(BigInteger.valueOf(1));
		}
		System.out.println("ANSWER: " + greatestProduct);
	};
};
