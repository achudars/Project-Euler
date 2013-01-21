public class PE112 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int i, j = 0;
		for (i = 100;; i++) {
			if (isIncrease(i) == true)
				continue;
			if (isDecrease(i) == true)
				continue;
			j++;
			if (i * 99 == j * 100)
				break;
		}
		System.out.println("Answer: " + i);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static boolean isIncrease(int x) {
		String temp = new String(x + "");
		int i, j = temp.length();
		for (i = 1; i < j; i++)
			if (temp.charAt(i - 1) > temp.charAt(i))
				return false;
		return true;
	}

	public static boolean isDecrease(int x) {
		String temp = new String(x + "");
		int i, j = temp.length();
		for (i = 1; i < j; i++)
			if (temp.charAt(i - 1) < temp.charAt(i))
				return false;
		return true;
	}

}
