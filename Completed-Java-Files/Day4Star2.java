import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.*;

public class Day4Star2 
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

		// Separate each board number to its own index and creates allOptions
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

		int calledIndex = 0;
		while (allOptions.size() > 25)
		{
			newNumberDrawn(allOptions, numbersCalled.get(calledIndex)); // appends x to values called
			for (int i = 0; i < allOptions.size(); i += 5)
			{
				if (allOptions.get(i).substring(0, 1).equals("x") && allOptions.get(i + 1).substring(0, 1).equals("x") && allOptions.get(i + 2).substring(0, 1).equals("x") && allOptions.get(i + 3).substring(0, 1).equals("x") && allOptions.get(i + 4).substring(0, 1).equals("x"))
				{
					int rowOriginIndex = i - (i % 25);
					String originIndexRowMod = "W" + allOptions.get(rowOriginIndex);
					allOptions.set(rowOriginIndex, originIndexRowMod);
				}
			} // checks rows and adds "W" to originIndex for winning "boards"
			for (int i = 0; i < allOptions.size() ; i += 25)
			{
				for (int j = 0; j < 5; j++)
				{
					if (allOptions.get(i + j).substring(0, 1).equals("x") && allOptions.get(i + j + 5).substring(0, 1).equals("x") && allOptions.get(i + j + 10).substring(0, 1).equals("x") && allOptions.get(i + j + 15).substring(0, 1).equals("x") && allOptions.get(i + j + 20).substring(0, 1).equals("x"))
					{
						int colOriginIndex = i;
						String originIndexColMod = "W" + allOptions.get(colOriginIndex);
						allOptions.set(colOriginIndex, originIndexColMod);
					}
				} 
			}  // checks columns 
			for (int i = 0; i < allOptions.size(); i += 25)
			{
				if (allOptions.get(i).substring(0, 1).equals("W"))
				{
					for (int j = 0; j < 25; j++)
					{
						allOptions.remove(i);
					}
					i -= 25;
				}
			}
			calledIndex++; // increments index for numbersCalled so it'll call next value
		}

		System.out.println(printWinningCard(allOptions, 0));
		System.out.println("last num called : " + numbersCalled.get(calledIndex));

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

	public static void checkRows(ArrayList<String> arr)
	{
		for (int i = 0; i < arr.size(); i += 5)
		{
			if (arr.get(i).substring(0, 1).equals("x") && arr.get(i + 1).substring(0, 1).equals("x") && arr.get(i + 2).substring(0, 1).equals("x") && arr.get(i + 3).substring(0, 1).equals("x") && arr.get(i + 4).substring(0, 1).equals("x"))
			{
				removeWinningCards(arr, i);
				i -= 5;
			}
		}
	}

	public static void checkColumns(ArrayList<String> arr)
	{
		for (int i = 0; i < arr.size(); i += 25)
		{
			for (int j = 0; j < 5; j++)
			{
				if (arr.get(i + j).substring(0, 1).equals("x") && arr.get(i + j + 5).substring(0, 1).equals("x") && arr.get(i + j + 10).substring(0, 1).equals("x") && arr.get(i + j + 15).substring(0, 1).equals("x") && arr.get(i + j + 20).substring(0, 1).equals("x"))
				{
					removeWinningCards(arr, i + j);
					i-=25;
				}
			}
		}
	}

	public static String printWinningCard(ArrayList<String> arr, int initWFI)
	{
		int originIndex = initWFI - (initWFI % 25);
		return arr.get(originIndex) + " " + arr.get(originIndex + 1) + " " + arr.get(originIndex + 2) + " "  + arr.get(originIndex + 3) + " "  + arr.get(originIndex + 4) + "\n"  + arr.get(originIndex + 5) + " "  + arr.get(originIndex+ 6) + " "  + arr.get(originIndex +7) + " "  + arr.get(originIndex +8) + " "  + arr.get(originIndex + 9) + "\n" + arr.get(originIndex + 10) + " " + arr.get(originIndex +11) + " " + arr.get(originIndex + 12) + " " + arr.get(originIndex +13) + " " + arr.get(originIndex +14) + "\n" + arr.get(originIndex +15) + " " + arr.get(originIndex +16) + " " + arr.get(originIndex +17) + " " + arr.get(originIndex +18) + " " + arr.get(originIndex + 19) + "\n" + arr.get(originIndex + 20) + " " + arr.get(originIndex + 21) + " " + arr.get(originIndex + 22) + " " + arr.get(originIndex + 23) + " " + arr.get(originIndex+ 24);
	}

	public static void removeWinningCards(ArrayList<String> arr, int initWFI)
	{
		int originIndex = initWFI - (initWFI % 25);
		for (int i = originIndex; i < originIndex + 25; i++)
		{
			arr.remove(i);
		}
	}

}