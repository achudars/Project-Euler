public class PE033 {

	public static void main(String[] args) {
		
		double product = 1;
		
		for (double n = 1; n < 9; n++) {
			for (double m = 1; m < 10; m++) {
				for (double k = 1; k < 10; k++) {
					if (n / m == ((n * 10 + k) / (k * 10 + m)) && ((n * 10 + k) != (k * 10 + m)) ) {
						// list all four non-tivial fractions
						System.out.println((n * 10 + k) + "/" + (k * 10 + m));
						product *= (n/m);
					}
				}
			}
		}
		System.out.println("Product (and answer): " + product + " which is 1/100, where the denominator is the answer.");

	}

}
