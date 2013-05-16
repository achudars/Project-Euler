public class PE181 {

	private int maxIndex[];
	private int size;
	private long d[];

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		PE181 p = new PE181(new int[] { 60, 40 });
		
		System.out.print("Answer: ");
		p.calc();


		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public PE181(int[] maxIndex) {
		this.maxIndex = maxIndex;
		size = 1;
		for (int m : maxIndex) {
			size *= m + 1;
		}
		d = new long[size];
		d[0] = 1;
	}

	public long calc() {
		int zero[] = new int[maxIndex.length];
		int add[] = new int[maxIndex.length];
		while (increment(add, zero)) {
			int start[] = new int[maxIndex.length];
			int end[] = new int[maxIndex.length];
			for (boolean ok = true; ok; ok = increment(start, add)) {
				for (int i = 0; i < maxIndex.length; i++) {
					end[i] = start[i] + add[i];
				}
				int start1 = encode(start);
				int end1 = encode(end);
				d[end1] += d[start1];
			}
		}
		System.out.println(d[size - 1]);
		return d[size - 1];
	}

	public int encode(int[] start) {
		int result = 0;
		int digitValue = 1;
		for (int i = 0; i < maxIndex.length; i++) {
			result += digitValue * start[i];
			digitValue *= maxIndex[i] + 1;
		}
		return result;
	}

	/**
	 * @return false if increment overflows
	 */
	public boolean increment(int[] index, int[] headRoom) {
		for (int i = 0; i < maxIndex.length; i++) {
			if (index[i] + headRoom[i] < maxIndex[i]) {
				index[i]++;
				return true; // increment accomplished
			}
			index[i] = 0; // zero and carry
		}
		return false;
	}

}
