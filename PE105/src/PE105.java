import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PE105 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		long startTime = System.nanoTime();

		int total = 0;
		BufferedReader rdr = new BufferedReader(new FileReader("src/sets.txt"));
		main: while (rdr.ready()) {
			String s[] = rdr.readLine().split(",");
			int n = s.length;
			int[] nums = new int[n];
			for (int i = 0; i < n; i++)
				nums[i] = Integer.valueOf(s[i]);
			for (int i = 0; i < (1 << n); i++) {
				for (int j = i + 1; j < (1 << n); j++) {
					if (i == 0 || (i & j) != 0)
						continue;
					
					int bts1 = Integer.bitCount(i);
					int bts2 = Integer.bitCount(j);
					int sm1 = 0;
					int sm2 = 0;
					
					for (int k = 0; k < n; k++) {
						if ((i & (1 << k)) != 0)
							sm1 += nums[k];
						else if ((j & (1 << k)) != 0)
							sm2 += nums[k];
					}
					if (sm1 == sm2 || (bts1 > bts2 && sm1 < sm2)
							|| (bts2 > bts1 && sm2 < sm1))
						continue main;
				}
			}
			for (int i : nums)
				total += i;
		}
		System.out.println("Answer: " + total);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
