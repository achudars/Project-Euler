import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PE096 {

	private static Grid gg;
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();

		
		int sum = 0;
	      List<String> positions;
	      List<Grid> games = new LinkedList<Grid>();
	      Grid g;
	      try
	      {
	         FileInputStream fstream = new FileInputStream("src/sudoku.txt");
	         DataInputStream in = new DataInputStream(fstream);
	         BufferedReader br = new BufferedReader(new InputStreamReader(in));
	         String strLine;
	         for(int i = 0; i < 50; i++)
	         {
	            br.readLine();
	            positions = new ArrayList<String>();
	            for(int j = 0; j < 9; j++)
	            {
	               positions.add(br.readLine());
	            }
	            g = new Grid(positions);
	            games.add(g);
	         }
	         in.close();
	      }catch (Exception e)
	      {
	         System.err.println("Error: " + e.getMessage());
	      }
	      for(Grid tmp:games)
	      {
	         gg = tmp;
	         Solve();
	         sum += Integer.parseInt(tmp.board[0][0] +""+tmp.board[0][1] +"" +tmp.board[0][2]);
	      }
	      System.out.println("Answer: " + sum);
		
		
		
		
		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	private static final int[] possibleNumbers = {0,1,2,3,4,5,6,7,8,9};

	   private static class Grid
	   {
	      int[][] board = new int[9][9];

	      public Grid(List<String> positions)
	      {
	         int pos = 0;
	         for(String s: positions)
	         {
	            for(int i = 0; i < s.length(); i++)
	            {
	               board[pos][i] = s.charAt(i) - 48;
	            }
	            pos++;
	         }
	      }

	   }

	   private static boolean Solve()
	   {
	      int nZeros;
	      int[] possibilities;
	      int row, column;
	      for(int i = 0; i < 9; i++)
	      {
	         for(int j = 0; j < 9; j++)
	         {
	            if(gg.board[i][j] == 0)
	            {
	               possibilities = possibleNumbers.clone();
	               for(int l = 0; l < 9; l++)
	               {
	                  possibilities[gg.board[l][j]] = 0;
	                  possibilities[gg.board[i][l]] = 0;
	               }
	               row = i/3;column = j/3;
	               for(int l = row*3; l < (row*3)+3; l++)
	               {
	                  for(int m = column*3; m < (column*3)+3; m++)
	                  {
	                     possibilities[gg.board[l][m]] = 0;
	                  }
	               }
	               nZeros = 0;
	               for(int n: possibilities)
	               {
	                  if(n == 0) nZeros++;
	               }
	               if(nZeros == 10) return false;
	               for(int n: possibilities)
	               {
	                  if(n != 0)
	                  {
	                     gg.board[i][j] = n;
	                     if(Solve()) return true;
	                  }
	               }
	               gg.board[i][j] = 0;
	               return false;
	            }
	         }
	      }
	      return true;
	   }
}
