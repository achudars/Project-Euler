public class PE207 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long perfect = 1, total = 2;
		while (total <= 12345 * perfect)
			if (((total & (++total)) == 0))
				perfect++;
		System.out.println("Answer: " + (total * (total + 1)));

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
