import java.util.ArrayList;

public class PE175 {

	static long g_n = 13717421;
	static long g_d = 109739369;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long a_n = 0;
		long a_d = 1;
		long b_n = 1;
		long b_d = 1;
		boolean equal = false;
		ArrayList<Long> store = new ArrayList<Long>();
		long currentCount = 0;
		int old = -1;
		int first = -1;
		while (!equal) {
			long c_n = a_n + b_n;
			long c_d = a_d + b_d;
			long diff = c_n * g_d - g_n * c_d;
			if (diff == 0) {
				equal = true;
			} else if (diff < 0) {
				a_n = c_n;
				a_d = c_d;
				if (old == -1) {
					first = 0;
					old = 0;
					currentCount++;
				} else if (old == 0)
					currentCount++;
				else {
					store.add(currentCount);
					currentCount = 1;
					old = 0;
				}
			} else {
				b_n = c_n;
				b_d = c_d;
				if (old == -1) {
					first = 1;
					old = 1;
					currentCount++;
				} else if (old == 1)
					currentCount++;
				else {
					store.add(currentCount);
					currentCount = 1;
					old = 1;
				}
			}
		}
		store.add(currentCount);
		String s;
		s = (first == 1) ? ("," + (store.get(0) + 1))
				: ("," + (store.get(0)) + ",1");
		first = (first + 1) % 2;
		for (int i = 1; i < store.size() - 1; i++) {
			s = "," + store.get(i) + s;
			first = (first + 1) % 2;
		}
		s = (first == 0) ? s = "1," + store.get(store.size() - 1) + s
				: (1 + store.get(store.size() - 1)) + s;
		System.out.println("Answer: " + s);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
