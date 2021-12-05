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

		// keep this line at the end of your code
		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.format("Elapsed time: %dns%n", elapsedTime);
	}

	public static void checkNumber(String in)
	{
		
	}
}