import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.*;

public class Day4Star1 
{
	public static void main(String[] args) 
	{
		Path filePath = Paths.get("day4data_callednums.txt");
		Path filePath2 = Paths.get("day4data_boards.txt");
		Charset charset = StandardCharsets.UTF_8;
		List<String> dataLines = new ArrayList<String>();
		List<String> dataLines2 = new ArrayList<String>();
		try {
			dataLines = Files.readAllLines(filePath, charset);
			dataLines2 = Files.readAllLines(filePath2, charset);
		} catch (IOException ex) {
			System.out.format("I/O error: %s%n", ex);
		}
		long start = System.nanoTime();

		// Format numbersCalled and add 0 to all single digit numbers
		ArrayList<String> numbersCalled = new ArrayList<String>();
		int leftIndex = 0;
		int rightIndex = dataLines.get(0).indexOf(",");
		while (leftIndex < rightIndex)
		{
			numbersCalled.add(dataLines.get(0).substring(leftIndex, rightIndex));
			leftIndex = rightIndex + 1;
			if (leftIndex < dataLines.get(0).length())
			{
				rightIndex = dataLines.get(0).indexOf(",", leftIndex);
			}
		}
		for (int i = 0; i < numbersCalled.size(); i++)
		{
			if (numbersCalled.get(i).length() == 1)
			{
				String temp = numbersCalled.get(i);
				numbersCalled.set(i, "0" + temp);
			}
		}

		// Separate each row of game board, removes blanks, adds 0 in front of any single digit number
		ArrayList<String> separateRows = new ArrayList<String>();
		for (int i = 0; i < dataLines2.size(); i++)
		{
			separateRows.add(dataLines2.get(i));
		}
		for (int i = 0; i < separateRows.size(); i++)
		{
			if (separateRows.get(i).equals(""))
			{
				separateRows.remove(i);
				i--;
			}
		}
		for (int i = 0; i < separateRows.size(); i++)
		{
			for (int j = 0; j < separateRows.get(i).length(); j += 3)
			{
				if (j == 0 && separateRows.get(i).substring(j, j + 1).equals(" "))
				{
					String back = separateRows.get(i).substring(j + 1, separateRows.get(i).length());
					separateRows.set(i, "0" + back);
				}
				else if (separateRows.get(i).substring(j, j + 1).equals(" "))
				{
					String front = separateRows.get(i).substring(0, j);
					String back = separateRows.get(i).substring(j + 1, separateRows.get(i).length());
					separateRows.set(i, front + "0" + back);
				}	
			}
		}

		//System.out.println(separateRows);
		//System.out.println("separateRows.size() = " + separateRows.size());
		//System.out.println("separateRows.get(4) = " + separateRows.get(4));
		//System.out.println("separateRows.get(5) = " + separateRows.get(5));
		//System.out.println("separateRows.get(6) = " + separateRows.get(6));

		// Separate each board number to its own index
		ArrayList<String> allOptions = new ArrayList<String>();
		for (int i = 0; i < separateRows.size(); i++)
		{
			for (int j = 0; j < separateRows.get(i).length(); j++)
			{
				if (separateRows.get(i).substring(j, j + 1).equals(" "))
				{
					allOptions.add(separateRows.get(i).substring(j - 2, j));
				}
				else if (j == separateRows.get(i).length() - 1)
				{
					allOptions.add(separateRows.get(i).substring(j - 1, j + 1));
				}
			}
		}

		String lastNumCalled = "0";
		boolean winnerFound = false;


		// keep this line at the end of your code
		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.format("Elapsed time: %dns%n", elapsedTime);
	}

	public static void newNumberDrawn(String initNum)
	{
		lastNumCalled = initNum;
		for (int i = 0; i < allOptions.size(); i++)
		{
			if (allOptions.get(i).equals(initNum))
			{
				newNum = "x" + initNum;
				allOptions.set(i, newNum);
			}
		}
	}

	public static void checkRows()
	{
		for (int i = 0; i < allOptions.size(); i += 5)
		{
			if (allOptions.get(i).substring(0, 1).equals("x") && allOptions.get(i + 1).substring(0, 1).equals("x") && allOptions.get(i + 2).substring(0, 1).equals("x") && allOptions.get(i + 3).substring(0, 1).equals("x") && allOptions.get(i + 4).substring(0, 1).equals("x"))
			{
				winnerFound = true;
				break;
			}
		}
	}

	public static void checkColumns()
	{
		for (int i = 0; i < allOptions.size(); i += 25)
		{
			for (int j = 0; j < 5; j++)
			{
				if (allOptions.get(i + j).substring(0, 1).equals("x") && allOptions.get(i + j + 5).substring(0, 1).equals("x") && allOptions.get(i + j + 10).substring(0, 1).equals("x") && allOptions.get(i + j + 15).substring(0, 1).equals("x") && allOptions.get(i + j + 20).substring(0, 1).equals("x"))
				{
					winnerFound = true;
				}
			}
			if (winnerFound == true)
				break;
		}
	}

}