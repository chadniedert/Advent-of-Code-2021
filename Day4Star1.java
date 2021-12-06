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
		int winnerFoundIndex = -1;
		int checkingIndex = 0;

		while (winnerFoundIndex == -1)
		{
			lastNumCalled = numbersCalled.get(checkingIndex);
			newNumberDrawn(allOptions, lastNumCalled);
			winnerFoundIndex = checkRows(allOptions);
			if (winnerFoundIndex == -1)
			{
				winnerFoundIndex = checkColumns(allOptions);
			}
			checkingIndex++;
		}

		System.out.println(printWinningCard(allOptions, winnerFoundIndex));
		System.out.println("lastNumCalled = " + lastNumCalled);
		
		int sum = 18+ 88 + 10 + 51+ 79 + 24+ 89 + 21 + 57+ 17 + 58+ 92+14+60;
		int prod = sum * Integer.parseInt(lastNumCalled);
		System.out.println("Answer: " + prod);

		// keep this line at the end of your code
		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.format("Elapsed time: %dns%n", elapsedTime);
	}

	public static void newNumberDrawn(ArrayList<String> arr, String initNum)
	{
		for (int i = 0; i < arr.size(); i++)
		{
			if (arr.get(i).equals(initNum))
			{
				String newNum = "x" + initNum;
				arr.set(i, newNum);
			}
		}
	}

	public static int checkRows(ArrayList<String> arr)
	{
		for (int i = 0; i < arr.size(); i += 5)
		{
			if (arr.get(i).substring(0, 1).equals("x") && arr.get(i + 1).substring(0, 1).equals("x") && arr.get(i + 2).substring(0, 1).equals("x") && arr.get(i + 3).substring(0, 1).equals("x") && arr.get(i + 4).substring(0, 1).equals("x"))
			{
				return i;
			}
		}
		return -1;
	}

	public static int checkColumns(ArrayList<String> arr)
	{
		for (int i = 0; i < arr.size(); i += 25)
		{
			for (int j = 0; j < 5; j++)
			{
				if (arr.get(i + j).substring(0, 1).equals("x") && arr.get(i + j + 5).substring(0, 1).equals("x") && arr.get(i + j + 10).substring(0, 1).equals("x") && arr.get(i + j + 15).substring(0, 1).equals("x") && arr.get(i + j + 20).substring(0, 1).equals("x"))
				{
					return i + j;
				}
			}
		}
		return -1;
	}

	public static String printWinningCard(ArrayList<String> arr, int initWFI)
	{
		int originIndex = initWFI - (initWFI % 25);
		return arr.get(originIndex) + " " + arr.get(originIndex + 1) + " " + arr.get(originIndex + 2) + " "  + arr.get(originIndex + 3) + " "  + arr.get(originIndex + 4) + "\n"  + arr.get(originIndex + 5) + " "  + arr.get(originIndex+ 6) + " "  + arr.get(originIndex +7) + " "  + arr.get(originIndex +8) + " "  + arr.get(originIndex + 9) + "\n" + arr.get(originIndex + 10) + " " + arr.get(originIndex +11) + " " + arr.get(originIndex + 12) + " " + arr.get(originIndex +13) + " " + arr.get(originIndex +14) + "\n" + arr.get(originIndex +15) + " " + arr.get(originIndex +16) + " " + arr.get(originIndex +17) + " " + arr.get(originIndex +18) + " " + arr.get(originIndex + 19) + "\n" + arr.get(originIndex + 20) + " " + arr.get(originIndex + 21) + " " + arr.get(originIndex + 22) + " " + arr.get(originIndex + 23) + " " + arr.get(originIndex+ 24) + "\n originIndex = " + originIndex;
	}

}