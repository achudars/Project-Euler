import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class PE084 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		System.out.println("Answer: " + solve(4));

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static int solve(int n) {
		int runs = 100_000;
		int[] board = new int[40];
		int[] goTo = {/* Should never get here, at [0] */40, 0, 10, 11, 24, 39, 5 };

		Integer[] allCCCards = { 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		Collections.shuffle(Arrays.asList(allCCCards));
		Queue<Integer> ccCards = new LinkedList<Integer>(
				Arrays.asList(allCCCards));

		Integer[] allCHCards = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0, 0, 0,
				0 };
		Collections.shuffle(Arrays.asList(allCHCards));
		Queue<Integer> chCards = new LinkedList<Integer>(
				Arrays.asList(allCHCards));

		int r = 0;
		int square = 0;
		int consecutive = 0;
		while (r < runs) {
			int die1 = (int) (Math.random() * n) + 1;
			int die2 = (int) (Math.random() * n) + 1;
			square += die1 + die2;

			if (square > board.length - 1) {
				square -= board.length;
				++r;
			}
			board[square]++;
			consecutive = die1 == die2 ? consecutive + 1 : 0;
			if (consecutive == 3) {
				board[square]--;
				square = goTo[2];
				board[square]++;
			} else if (isCC(square)) {
				int card = ccCards.remove();
				if (card > 0) {
					square = goTo[card];
					board[square]++;
				}
				ccCards.offer(card);
			} else if (isCH(square)) {
				int card = chCards.remove();
				if (card > 6) {
					if (card < 9) {
						square = getNextR(square);
						board[square]++;
					} else if (card < 10) {
						square = getNextU(square);
						board[square]++;
					} else {
						square = square > 2 ? square - 3 : board.length
								- square - 1;
					}
				} else if (card > 0) {
					square = goTo[card];
					board[square]++;
				}
				chCards.offer(card);
			} else if (isG2J(square)) {
				square = goTo[2];
				board[square]++;
			} else
				;
		}
		int modalInt = 0;
		for (int i = 0; i < 3; ++i) {
			int max = 0, maxIndex = 0;
			for (int j = 0; j < board.length; ++j) {
				if (board[j] > max) {
					max = board[j];
					maxIndex = j;
				}
			}
			board[maxIndex] = 0;
			modalInt *= 100;
			modalInt += maxIndex;
		}

		return modalInt;
	}

	private static boolean isCC(int i) {
		return i == 2 || i == 17 || i == 33;
	}

	private static boolean isCH(int i) {
		return i == 7 || i == 22 || i == 36;
	}

	private static boolean isG2J(int i) {
		return i == 30;
	}

	private static int getNextR(int i) {
		if (i < 5)
			return 5;
		if (i < 15)
			return 15;
		if (i < 25)
			return 25;
		if (i < 35)
			return 35;
		return 5;
	}

	private static int getNextU(int i) {
		if (i < 12)
			return 12;
		if (i < 28)
			return 28;
		return 12;
	}

}
