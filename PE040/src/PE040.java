public class PE040 {

	public static void main(String[] args) {
		StringBuffer result = new StringBuffer();
		
		for (int i = 0; i < 1000000; i++) {
			result.append(i);
		}
		int d1 = Integer.parseInt("" + result.charAt(1));
		int d10 = Integer.parseInt("" + result.charAt(10));
		int d100 = Integer.parseInt("" + result.charAt(100));
		int d1000 = Integer.parseInt("" + result.charAt(1000));
		int d10000 = Integer.parseInt("" + result.charAt(10000));
		int d100000 = Integer.parseInt("" + result.charAt(100000));
		int d1000000 = Integer.parseInt("" + result.charAt(1000000));

		int Champernowne = d1 * d10 * d100 * d1000 * d10000 * d100000 * d1000000;
		System.out.println("Answer: " + Champernowne);

	}

}
