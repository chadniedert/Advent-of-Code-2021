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

		ArrayList<Integer> oxy_bit1Count = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0));
		ArrayList<Integer> oxy_bit0Count = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0));
		ArrayList<Integer> co2_bit1Count = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0));
		ArrayList<Integer> co2_bit0Count = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0));
		ArrayList<String> oxyList = new ArrayList<String>();
		ArrayList<String> co2List = new ArrayList<String>();

		// Build oxyGenList, co2List from dataLines
		for (String num : dataLines)
		{
			oxyList.add(num);
			co2List.add(num);
		}

		// Builds oxy_bit1Count, oxy_bit0Count, co2_bit1Count, co2_bit2Count
		for (String num : dataLines)
		{
			for (int i = 0; i < num.length(); i++)
			{
				if (num.substring(i, i+1).equals("1"))
				{
					oxy_bit1Count.set(i, oxy_bit1Count.get(i) + 1);
					co2_bit1Count.set(i, co2_bit1Count.get(i) + 1);
				}
				else if (num.substring(i, i+1).equals("0"))
				{
					oxy_bit0Count.set(i, oxy_bit0Count.get(i) + 1);
					co2_bit0Count.set(i, co2_bit0Count.get(i) + 1);
				}
				else
				{
					System.out.println("Something went wrong.");
					break;
				}
			}
		}

		// Removes appropriate values from oxyList
		for (int i = 0; i < 12; i++)
		{
			updateCounts(oxyList, oxy_bit1Count, oxy_bit0Count);
			if (oxy_bit1Count.get(i) >= oxy_bit0Count.get(i))
			{
				for (int j = 0; j < oxyList.size(); j++)
				{
					if (oxyList.get(j).substring(i, i + 1).equals("0"))
					{
						if (oxyList.size() > 1)
						{
							oxyList.remove(j);
							j--;
						}
					}
				}
			}
			else
			{
				for (int k = 0; k < oxyList.size(); k++)
				{
					if (oxyList.get(k).substring(i, i + 1).equals("1"))
					{
						if (oxyList.size() > 1)
						{
							oxyList.remove(k);
							k--;
						}
					}
				}
			}
		}

		// Removes appropriate values from co2List
		for (int i = 0; i < 12; i++)
		{
			updateCounts(co2List, co2_bit1Count, co2_bit0Count);
			if (co2_bit1Count.get(i) < co2_bit0Count.get(i))
			{
				for (int j = 0; j < co2List.size(); j++)
				{
					if (co2List.get(j).substring(i, i + 1).equals("0"))
					{
						if (co2List.size() > 1)
						{
							co2List.remove(j);
							j--;
						}
					}
				}
			}
			else
			{
				for (int k = 0; k < co2List.size(); k++)
				{
					if (co2List.get(k).substring(i, i + 1).equals("1"))
					{
						if (co2List.size() > 1)
						{
							co2List.remove(k);
							k--;
						}
					}
				}
			}
		}

		System.out.println("oxyList: " + oxyList);
		int oxyRating = Integer.parseInt(oxyList.get(0), 2);
		System.out.println("oxyRating = " + oxyRating);
		System.out.println("oxyList.size() = " + oxyList.size());

		System.out.println("co2List: " + co2List);
		int co2Rating = Integer.parseInt(co2List.get(0), 2);
		System.out.println("co2Rating = " + co2Rating);
		System.out.println("co2List.size() = " + co2List.size());

		int lifeSupportRating = oxyRating * co2Rating;
		System.out.println("lifeSupportRating = " + lifeSupportRating);
		
		// keep this line at the end of your code
		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.format("Elapsed time: %dns%n", elapsedTime);
	}

	public static void updateCounts(ArrayList<String> storageArr, ArrayList<Integer> arr1, ArrayList<Integer> arr0)
	{
		// Reset arr1, arr2 to 0
		for (int i = 0; i < arr1.size(); i++)
		{
			arr1.set(i, 0);
		}
		for (int i = 0; i < arr0.size(); i++)
		{
			arr0.set(i, 0);
		}

		for (String num : storageArr)
		{
			
			for (int i = 0; i < num.length(); i++)
			{
				if (num.substring(i, i + 1).equals("1"))
				{
					arr1.set(i, arr1.get(i) + 1);
				}
				else if (num.substring(i, i+1).equals("0"))
				{
					arr0.set(i, arr0.get(i) + 1);
				}
				else
				{
					System.out.println("Something went wrong.");
					break;
				}
			}
		}
	}
}