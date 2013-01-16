public class PE086 {

  
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		int paths = 0;
		
		
		long solutions = 0;
		long i;
		for (i = 1; solutions <= 1000000; i++) {
			for (int jk = 1; jk <= i + i; jk++) {
				if (sqrtIsInteger(i, jk)) {
					if (jk > i + 1)
						solutions += (i + i + 2 - jk) / 2;
					else
						solutions += jk / 2;
				}
			}
		}
		paths = (int) --i;
		
		
		// BRUTE FORCE BELOW (takes 52 seconds to compute)
		
/*
		int limit = 2000;
	
		
		dance : for (int a = 1; a <= limit; a++) {
			for (int b = 1; b <= a; b++) {
				for (int c = 1; c <= b; c++) {
					if(shortestPathIn3D(a, b, c) == (int)shortestPathIn3D(a, b, c)){
						System.out.println("Answer: " + (int)shortestPathIn3D(a, b, c) + " for {"+a+","+b+","+c+"} paths=" + paths);
						paths++;
					}
					
				}
			}
			if(paths>=1000000){
				System.out.println("---- at: M="+ a);
				break dance;
			}
		}
*/
		
		System.out.println("Answer: " + paths);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static double shortestPathIn3D(int a, int b, int c) {
		double shortestPath = 0;

		shortestPath = Math.min(
					            Math.min(
					            		 Math.sqrt((a + b) * (a + b) + c * c),
					            		 Math.sqrt((b + c) * (b + c) + a * a)),
					            		 Math.sqrt((c + a) * (c + a) + b * b));

		return shortestPath;
	}

	// dynamic programming
	public static boolean sqrtIsInteger(long x, long sum_y_z) {
		double d = Math.sqrt(x * x + sum_y_z * sum_y_z);
		return d == (long) d;
	}

}
