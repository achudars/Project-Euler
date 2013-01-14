public class PE052 {

	public static void main(String[] args) {

		long startTime = System.nanoTime();

		Integer x, x2, x3, x4, x5, x6 = 0;

		for (int i = 100000; i < 1000000; i++) {
			x = i;
			x2 = i * 2;
			x3 = i * 3;
			x4 = i * 4;
			x5 = i * 5;
			x6 = i * 6;

			if (x.SIZE == x2.SIZE && x2.SIZE == x3.SIZE && x3.SIZE == x4.SIZE
					&& x4.SIZE == x5.SIZE && x5.SIZE == x6.SIZE) {

				String unsortedx = x.toString();
				char[] contentx = unsortedx.toCharArray();
				java.util.Arrays.sort(contentx);
				String sortedx = new String(contentx);

				String unsortedx2 = x2.toString();
				char[] contentx2 = unsortedx2.toCharArray();
				java.util.Arrays.sort(contentx2);
				String sortedx2 = new String(contentx2);

				if (sortedx.equals(sortedx2)) {

					String unsortedx3 = x3.toString();
					char[] contentx3 = unsortedx3.toCharArray();
					java.util.Arrays.sort(contentx3);
					String sortedx3 = new String(contentx3);

					if (sortedx.equals(sortedx3)) {

						String unsortedx4 = x4.toString();
						char[] contentx4 = unsortedx4.toCharArray();
						java.util.Arrays.sort(contentx4);
						String sortedx4 = new String(contentx4);

						if (sortedx.equals(sortedx4)) {

							String unsortedx5 = x5.toString();
							char[] contentx5 = unsortedx5.toCharArray();
							java.util.Arrays.sort(contentx5);
							String sortedx5 = new String(contentx5);

							if (sortedx.equals(sortedx5)) {

								String unsortedx6 = x6.toString();
								char[] contentx6 = unsortedx6.toCharArray();
								java.util.Arrays.sort(contentx6);
								String sortedx6 = new String(contentx6);

								if (sortedx.equals(sortedx6)) {

									System.out.println("Answer: " + i);
									break;
								}
							}
						}
					}
				}
			}
		}

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}
}
