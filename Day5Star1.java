import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.*;

public class Day5Star1 
{
	public static void main(String[] args) 
	{
		Path filePath = Paths.get("day5data.txt");
		Charset charset = StandardCharsets.UTF_8;
		List<String> dataLines = new ArrayList<String>();
		try {
			dataLines = Files.readAllLines(filePath, charset);
		} catch (IOException ex) {
			System.out.format("I/O error: %s%n", ex);
		}
		long start = System.nanoTime();

		// create all Coordinates objects
		ArrayList<Coordinates> allCoords = new ArrayList<Coordinates>();
		for (int i = 0; i < dataLines.size(); i++)
		{
			int leftIndex = 0;
			int rightIndex = dataLines.get(i).indexOf(",");
			int a = Integer.parseInt(dataLines.get(i).substring(leftIndex, rightIndex));
			leftIndex = rightIndex + 1;
			rightIndex = dataLines.get(i).indexOf(" ");
			int b = Integer.parseInt(dataLines.get(i).substring(leftIndex, rightIndex));
			leftIndex = rightIndex + 4;
			rightIndex = dataLines.get(i).indexOf(",", leftIndex);
			int c = Integer.parseInt(dataLines.get(i).substring(leftIndex, rightIndex));
			leftIndex = rightIndex + 1;
			rightIndex = dataLines.get(i).length();
			int d = Integer.parseInt(dataLines.get(i).substring(leftIndex, rightIndex));
			Coordinates tempCoord = new Coordinates(a, b, c, d);
			allCoords.add(tempCoord);
		} // allCoords ArrayList is complete

		// create game board
		int[][] board = new int[1000][1000];
		for (int i = 0; i < 1000; i++)
		{
			for (int j = 0; j < 1000; j++)
			{
				board[i][j] = 0;
			}
		} // game board complete

		// checks for only vertical or horizontal movement
		for (int i = 0; i < allCoords.size(); i++)
		{
			if (allCoords.get(i).getX1() == allCoords.get(i).getX2())
			{
				int row = allCoords.get(i).getX1();
				if (allCoords.get(i).getY1() < allCoords.get(i).getY2())
				{
					for (int j = allCoords.get(i).getY1(); j <= allCoords.get(i).getY2(); j++)
					{
						int temp = board[row][j];
						board[row][j] = temp + 1;
					}
				}
				else
				{
					for (int j = allCoords.get(i).getY2(); j <= allCoords.get(i).getY1(); j++)
					{
						int temp = board[row][j];
						board[row][j] = temp + 1;
					}
				}
			}
			else if (allCoords.get(i).getY1() == allCoords.get(i).getY2())
			{
				int col = allCoords.get(i).getY1();
				if (allCoords.get(i).getX1() < allCoords.get(i).getX2())
				{
					for (int j = allCoords.get(i).getX1(); j <= allCoords.get(i).getX2(); j++)
					{
						int temp = board[j][col];
						board[j][col] = temp + 1;
					}
				}
				else
				{
					for (int j = allCoords.get(i).getX2(); j <= allCoords.get(i).getX1(); j++)
					{
						int temp = board[j][col];
						board[j][col] = temp + 1;
					}
				}
			}
		}

		// count intersections of 2 or more
		int intCount = 0;
		for (int i = 0; i < 1000; i++)
		{
			for (int j = 0; j < 1000; j++)
			{
				if (board[i][j] > 1)
				{
					intCount++;
				}
			}
		}

		System.out.println("intCount = " + intCount);
	
		// keep this line at the end of your code
		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.format("Elapsed time: %dns%n", elapsedTime);
	}
}