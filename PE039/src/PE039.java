public class PE039 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int absolute = 0;
		int inner = 0;
		int valueOfP = 0;

		// trial and error revealed that it's pointless to start any time sooner
		// as the algorithm is inefficient and takes ~10seconds to execute
		for (int p = 800; p <= 1000; p++) {
			inner = 0;
			for (int a = 3; a <= 300; a++) {
				for (int b = 4; b <= 400; b++) {
					for (int c = 5; c <= 500; c++) {
						if (((a + b + c) == p) && (a < b) && (b < c)
								&& (a * a + b * b) == (c * c)) {
							System.out.println("inner= " + inner + " absolute="
									+ absolute + " || YES, a=" + a + " b=" + b
									+ " c=" + c + " p=" + p + " (a+b+c)="
									+ (a + b + c));
							inner++;

						}
					}
				}
			}
			if (inner > absolute) {
				absolute = inner;
				valueOfP = p;
			}
		}

		System.out.println("Answer (Number Of Solutions): " + absolute + " at p = "
				+ valueOfP);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

}
