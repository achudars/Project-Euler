import java.io.File;
import java.util.Scanner;

public class PE081 {

	private static int[][] matrix = new int[80][80];
	private static int[][] memTable = new int[80][80];

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		// dynamic programming for finding in the shortest path in a matrix

		Scanner scanner;
		try {
			scanner = new Scanner(new File("src/matrix.txt"));
		} catch (Exception e) {
			throw new RuntimeException("file not found");
		}
		for (int row = 0; row < matrix.length; row++) {
			String line = scanner.nextLine();
			String[] entries = line.split(",");
			for (int col = 0; col < matrix[0].length; col++) {
				matrix[row][col] = Integer.parseInt(entries[col]);
			}
		}
		System.out.println("Answer: " + findShortestPath(matrix.length - 1,
				matrix[0].length - 1));

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	private static int findShortestPath(int row, int col) {
		if (memTable[row][col] != 0)
			return memTable[row][col];
		else if (row == 0 && col == 0) {
			memTable[row][col] = matrix[row][col];
			return matrix[row][col];
		} else {
			int min = Integer.MAX_VALUE;
			if (row != 0)
				min = Math.min(min, findShortestPath(row - 1, col));
			if (col != 0)
				min = Math.min(min, findShortestPath(row, col - 1));
			min += matrix[row][col];
			memTable[row][col] = min;
			return min;
		}
	}
}
