public class PE017 {

	public static void main(String[] args) {
		System.out.println(LetterCount());
	}

	public static int LetterCount() {
		int count = 0;
		
		int onetToNine = "onetwothreefourfivesixseveneightnine".length();
		int tenToNineteen = "teneleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteen".length();
		int and = "and".length();
		int twentyToNinety = "twentythirtyfortyfiftysixtyseventyeightyninety".length();
		int hundred = "hundred".length();
		int thousand = "thousand".length();
		
		count = "one".length() + thousand + 900 * hundred + 100 * onetToNine
				+ 100 * twentyToNinety + 891 * and + 80 * onetToNine + 10
				* (onetToNine + tenToNineteen);
		
		return count;
	}

}
