
public class PE219 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		System.out.println("Answer: " + solve(1000000000));

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	private static long solve(int n) {
	    long m = 0, f0 = 1, f1 = 0, f2 = 0, f3 = 0, f4 = 0;
	    long remaining = n - 1;
	    while (remaining > 0) {
	        if (remaining >= f0) {
	            // advance the sequence by f0
	            remaining = remaining - f0;
	            f1 = f1 + f0;
	            f4 = f4 + f0;
	            f0 = f1;
	            f1 = f2;
	            f2 = f3;
	            f3 = f4;
	            f4 = 0;
	            m = m + 1;
	        } else {
	            // advance the sequence by remaining
	            f0 = f0 - remaining;
	            f1 = f1 + remaining;
	            f4 = f4 + remaining;
	            remaining = 0;
	        }
	    }
	    return f0*m + f1*(m+1) + f2*(m+2) + f3*(m+3) + f4*(m+4);
	}
}
