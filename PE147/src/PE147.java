public class PE147 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long result = 0;
		int W = 47;
		int H = 43;
		
		for (int w = 1; w <= W; w++)
			for (int h = 1; h <= H; h++)
				result += calcCrossHatchedGrids(w, h);
		System.out.println("Answer: " + result);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static int calcCrossHatchedGrids(int w, int h) {
		int num = 0;
		// Vertical number
		for (int xs = 1; xs <= w; xs++)
			for (int ys = 1; ys <= h; ys++)
				num += (w - xs + 1) * (h - ys + 1);

		// Diagonal number
		int gridSize = w + h;
		boolean[][] grid = new boolean[gridSize][gridSize];
		for (int y = 0; y < gridSize; y++)
			for (int x = 0; x < gridSize; x++)
				if (x + y >= w && x + y < w + h + h - 1
						&& (gridSize - x) + y > h
						&& (gridSize - x) + y < h + w + w)
					grid[x][y] = true;
				else
					grid[x][y] = false;

		for (int y = 0; y < gridSize; y++)
			for (int x = 0; x < gridSize; x++)
				if (grid[x][y])
					for (int y2 = y; y2 < gridSize; y2++)
						for (int x2 = x; x2 < gridSize; x2++)
							if (grid[x2][y] && grid[x][y2] && grid[x2][y2])
								num++;
							else
								break;

		return num;
	}

}
