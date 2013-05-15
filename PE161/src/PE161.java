import static java.lang.System.*;
import static java.lang.Math.*;
import static java.lang.Integer.*;
import static java.lang.Long.*;
import static java.math.BigInteger.*;

import java.util.HashMap;

/**
 * # represents nonempty boxes, X and $ represents new triominoes. There are
 * only 8 ways on how to fill up the lower-most, leftmost empty box.
 * 
 * Case I II III IV V VI VII VIII
 * 
 * X X X X XX XX XX$ XX #X #XXX #XX #XX #X #X# #X$$ #X$$$ ##### ##### #####
 * ##### ##### ##### ##### #####
 */

public class PE161 {

	static int w, h;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		w = args.length <= 0 ? 9 : parseInt(args[0]);
		h = args.length <= 1 ? 12 : parseInt(args[1]);
		byte b[] = new byte[w];
		long ans = ans(b, 0, 0);
		out.println("Answer: " + ans);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	static HashMap<Long, Long> ans = new HashMap<Long, Long>();

	static long pro(byte b[], int i) {// put the bits into a single long
		return i >= b.length ? 0 : (pro(b, i + 1) << 3) + b[i];
	}

	static long ans(byte b[], int p, int c) {// memo
		long hsh = (pro(b, 0) << 8) + (p << 4) + c;
		if (!ans.containsKey(hsh)) {
			ans.put(hsh, ans0(b, p, c));
		}
		return ans.get(hsh);
	}

	static long ans0(byte b[], int p, int c) {
		if (p == h) {// no more empty boxes
			return 1;
		}
		if (c == w) {// current row done
			int min = h;
			for (byte bb : b)
				min = min(min, bb);
			return ans(b, min, 0);
		}
		if (b[c] != p) {// this box is not empty
			return ans(b, p, c + 1);
		}
		long total = 0;
		if (p + 3 <= h) {// Case 1
			if (c + 1 <= w) {
				b[c] += 3;
				total += ans(b, p, c + 1);
				b[c] -= 3;
			}
		}
		if (p + 1 <= h) {// Case 2
			if (c + 3 <= w) {
				if (b[c] == b[c + 1] && b[c] == b[c + 2]) {
					b[c] += 1;
					b[c + 1] += 1;
					b[c + 2] += 1;
					total += ans(b, p, c + 3);
					b[c] -= 1;
					b[c + 1] -= 1;
					b[c + 2] -= 1;
				}
			}
		}
		if (p + 2 <= h) {// Case 3
			if (c + 2 <= w) {
				if (b[c] == b[c + 1]) {
					b[c] += 2;
					b[c + 1] += 1;
					total += ans(b, p, c + 2);
					b[c] -= 2;
					b[c + 1] -= 1;
				}
			}
		}
		if (p + 2 <= h) {// Case 4
			if (c + 2 <= w) {
				if (b[c] == b[c + 1]) {
					b[c] += 1;
					b[c + 1] += 2;
					total += ans(b, p, c + 2);
					b[c] -= 1;
					b[c + 1] -= 2;
				}
			}
		}
		if (p + 2 <= h) {// Case 5
			if (c - 1 >= 0) {
				if (b[c - 1] == b[c] + 1) {
					b[c - 1] += 1;
					b[c] += 2;
					total += ans(b, p, c + 1);
					b[c - 1] -= 1;
					b[c] -= 2;
				}
			}
		}
		if (p + 2 <= h) {// Case 6
			if (c + 2 <= w) {
				if (b[c + 1] == b[c] + 1) {
					b[c + 1] += 1;
					b[c] += 2;
					total += ans(b, p, c + 2);
					b[c + 1] -= 1;
					b[c] -= 2;
				}
			}
		}
		if (p + 2 <= h) {// Case 7
			if (c + 3 <= w) {
				if (b[c] == b[c + 1] && b[c] == b[c + 2]) {
					b[c] += 2;
					b[c + 1] += 2;
					b[c + 2] += 2;
					total += ans(b, p, c + 3);
					b[c] -= 2;
					b[c + 1] -= 2;
					b[c + 2] -= 2;
				}
			}
		}
		if (p + 2 <= h) {// Case 8
			if (c + 4 <= w) {
				if (b[c] == b[c + 1] && b[c] == b[c + 2] && b[c] == b[c + 3]) {
					b[c] += 2;
					b[c + 1] += 2;
					b[c + 2] += 1;
					b[c + 3] += 1;
					total += ans(b, p, c + 4);
					b[c] -= 2;
					b[c + 1] -= 2;
					b[c + 2] -= 1;
					b[c + 3] -= 1;
				}
			}
		}
		return total;
	}
}
