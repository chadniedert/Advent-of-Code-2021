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
		ArrayList<String> co2List = new ArrayList<String>();

		// Build oxyGenList, co2List from dataLines
		for (String num : dataLines)
		{
			oxyGenList.add(num);
			co2List.add(num);
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

		// Removes appropriate values from oxyGenList, co2List
		for (int i = 0; i < 12; i++)
		{
			if (bit1Count.get(i) >= bit0Count.get(i))
			{
				for (int j = 0; j < oxyGenList.size(); j++)
				{
					if (oxyGenList.get(j).substring(i, i + 1).equals("0"))
					{
						if (oxyGenList.size() > 1)
						{
							oxyGenList.remove(j);
							j--;
						}
					}
				}
				for (int l = 0; l < co2List.size(); l++)
				{
					if (co2List.get(l).substring(i, i + 1).equals("1"))
					{
						if (co2List.size() > 1)
						{
							co2List.remove(l);
							l--;
						}
					}
				}	
			}
			else
			{
				for (int k = 0; k < oxyGenList.size(); k++)
				{
					if (oxyGenList.get(k).substring(i, i + 1).equals("1"))
					{
						if (oxyGenList.size() > 1)
						{
							oxyGenList.remove(k);
							k--;
						}
					}
				}
				for (int m = 0; m < co2List.size(); m++)
				{
					if (co2List.get(m).substring(i, i + 1).equals("0"))
					{
						if (co2List.size() > 1)
						{
							co2List.remove(m);
							m--;
						}
					}
				}
			}
			
		}

		
		System.out.println("oxyGenList: " + oxyGenList);
		
		int oxyGenRating = Integer.parseInt(oxyGenList.get(0), 2);
		System.out.println("oxyGenRating = " + oxyGenRating);
		System.out.println("oxyGenList.size() = " + oxyGenList.size());

		System.out.println("co2List: " + co2List);
		
		int co2Rating = Integer.parseInt(co2List.get(0), 2);
		System.out.println("co2Rating = " + co2Rating);
		System.out.println("co2List.size() = " + co2List.size());

		System.out.println("generator rating: " + co2Rating * oxyGenRating);

		// keep this line at the end of your code
		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.format("Elapsed time: %dns%n", elapsedTime);
	}
}