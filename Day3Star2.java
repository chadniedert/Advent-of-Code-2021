import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.*;

public class Day3Star2 
{
	public static void main(String[] args) 
	{
		Path filePath = Paths.get("day3data.txt");
		Charset charset = StandardCharsets.UTF_8;
		List<String> dataLines = new ArrayList<String>();
		try {
			dataLines = Files.readAllLines(filePath, charset);
		} catch (IOException ex) {
			System.out.format("I/O error: %s%n", ex);
		}
		long start = System.nanoTime();

		String gammaRate = "", epsilonRate = ""; 
		int powerCons = 0;

		ArrayList<Integer> bit1Count = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0));
		ArrayList<Integer> bit0Count = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0));
		ArrayList<String> oxyGenList = new ArrayList<String>();

		// Build oxyGenList from dataLines
		for (String num : dataLines)
		{
			oxyGenList.add(num);
		}

		// Builds bit1Count and bit0Count
		for (String num : dataLines)
		{
			for (int i = 0; i < num.length(); i++)
			{
				if (num.substring(i, i+1).equals("1"))
				{
					bit1Count.set(i, bit1Count.get(i) + 1);
				}
				else if (num.substring(i, i+1).equals("0"))
				{
					bit0Count.set(i, bit0Count.get(i) + 1);
				}
				else
				{
					System.out.println("Something went wrong.");
					break;
				}
			}
		}

		// remove index 0 (1 most common)
		for (int i = 0; i < oxyGenList.size(); i++)
		{
			if (oxyGenList.get(i).substring(0, 1).equals("0"))
			{
				oxyGenList.remove(i);
				i--;
			}
		}

		// remove index 1 (0 most common)
		for (int i = 0; i < oxyGenList.size(); i++)
		{
			if (oxyGenList.get(i).substring(1, 2).equals("1"))
			{
				oxyGenList.remove(i);
				i--;
			}
		}

		// remove index 2 (1 most common)
		for (int i = 0; i < oxyGenList.size(); i++)
		{
			if (oxyGenList.get(i).substring(2, 3).equals("0"))
			{
				oxyGenList.remove(i);
				i--;
			}
		}

		// remove index 3 (1 most common)
		for (int i = 0; i < oxyGenList.size(); i++)
		{
			if (oxyGenList.get(i).substring(3, 4).equals("0"))
			{
				oxyGenList.remove(i);
				i--;
			}
		}

		// remove index 4 (1 most common)
		for (int i = 0; i < oxyGenList.size(); i++)
		{
			if (oxyGenList.get(i).substring(4, 5).equals("0"))
			{
				oxyGenList.remove(i);
				i--;
			}
		}

		// remove index 5 (1 most common)
		for (int i = 0; i < oxyGenList.size(); i++)
		{
			if (oxyGenList.get(i).substring(5, 6).equals("0"))
			{
				oxyGenList.remove(i);
				i--;
			}
		}

		// remove index 6 (1 most common)
		for (int i = 0; i < oxyGenList.size(); i++)
		{
			if (oxyGenList.get(i).substring(6, 7).equals("0"))
			{
				oxyGenList.remove(i);
				i--;
			}
		}

		// remove index 7 (1 most common)
		for (int i = 0; i < oxyGenList.size(); i++)
		{
			if (oxyGenList.get(i).substring(7, 8).equals("0"))
			{
				oxyGenList.remove(i);
				i--;
			}
		}

		// remove index 8 (1 most common)
		oxyGenList.remove(0);

		System.out.println("oxyGenList: " + oxyGenList);
		
		int oxyGenRating = Integer.parseInt(oxyGenList.get(0), 2);
		System.out.println("oxyGenRating = " + oxyGenRating);
		System.out.println("oxyGenList.size() = " + oxyGenList.size());

		ArrayList<String> co2List = new ArrayList<String>();

		// Build co2List from dataLines
		for (String num : dataLines)
		{
			co2List.add(num);
		}

		// remove index 0 (0 least common)
		for (int i = 0; i < co2List.size(); i++)
		{
			if (co2List.get(i).substring(0, 1).equals("1"))
			{
				co2List.remove(i);
				i--;
			}
		}

		// remove index 1 (1 least common)
		for (int i = 0; i < co2List.size(); i++)
		{
			if (co2List.get(i).substring(1, 2).equals("0"))
			{
				co2List.remove(i);
				i--;
			}
		}

		// remove index 2 (0 least common)
		for (int i = 0; i < co2List.size(); i++)
		{
			if (co2List.get(i).substring(2, 3).equals("1"))
			{
				co2List.remove(i);
				i--;
			}
		}

		// remove index 3 (0 least common)
		for (int i = 0; i < co2List.size(); i++)
		{
			if (co2List.get(i).substring(3, 4).equals("1"))
			{
				co2List.remove(i);
				i--;
			}
		}

		// remove index 4 (0 least common)
		for (int i = 0; i < co2List.size(); i++)
		{
			if (co2List.get(i).substring(4, 5).equals("1"))
			{
				co2List.remove(i);
				i--;
			}
		}

		// remove index 5 (0 least common)
		for (int i = 0; i < co2List.size(); i++)
		{
			if (co2List.get(i).substring(5, 6).equals("1"))
			{
				co2List.remove(i);
				i--;
			}
		}

		// remove index 6 (0 least common)
		for (int i = 0; i < co2List.size(); i++)
		{
			if (co2List.get(i).substring(6, 7).equals("1"))
			{
				co2List.remove(i);
				i--;
			}
		}

		// remove index 7 (0 least common)
		for (int i = 0; i < co2List.size(); i++)
		{
			if (co2List.get(i).substring(7, 8).equals("1"))
			{
				co2List.remove(i);
				i--;
			}
		}

		// remove index 8 (0 least common)
		for (int i = 0; i < co2List.size(); i++)
		{
			if (co2List.get(i).substring(8, 9).equals("1"))
			{
				co2List.remove(i);
				i--;
			}
		}

		// remove index 9 (0 least common)
		for (int i = 0; i < co2List.size(); i++)
		{
			if (co2List.get(i).substring(9, 10).equals("1"))
			{
				co2List.remove(i);
				i--;
			}
		}

		// remove index 10 (1 least common)
		for (int i = 0; i < co2List.size(); i++)
		{
			if (co2List.get(i).substring(10, 11).equals("0"))
			{
				co2List.remove(i);
				i--;
			}
		}

		// remove index 11 (0 least common)
		for (int i = 0; i < co2List.size(); i++)
		{
			if (co2List.get(i).substring(11, 12).equals("1"))
			{
				co2List.remove(i);
				i--;
			}
		}

		System.out.println("co2List: " + co2List);
		
		int co2Rating = Integer.parseInt(co2List.get(0), 2);
		System.out.println("co2Rating = " + co2Rating);
		System.out.println("co2List.size() = " + co2List.size());

		System.out.println()

		// keep this line at the end of your code
		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.format("Elapsed time: %dns%n", elapsedTime);
	}
}