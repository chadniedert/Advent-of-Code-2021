import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.*;

public class Day3 
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

		// Star 1
		String gammaRate = "", epsilonRate = ""; 
		int powerCons = 0;

		ArrayList<Integer> bit1Count = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0));
		ArrayList<Integer> bit0Count = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0));

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
		
		// System.out.println(bit1Count);
		// System.out.println(bit0Count);
		/* OUTPUT FOR ABOVE PRINT STATEMENTS
		 * [519, 498, 501, 504, 506, 528, 517, 509, 508, 514, 490, 521]
		 * [481, 502, 499, 496, 494, 472, 483, 491, 492, 486, 510, 479]
		 * Elapsed time: 43906266ns
		 */

		for (int i = 0; i < bit1Count.size(); i++)
		{
			if (bit1Count.get(i) > bit0Count.get(i))
			{
				gammaRate += "1";
				epsilonRate += "0";
			}
			else
			{
				gammaRate += "0";
				epsilonRate += "1";
			}
		}

		System.out.println("gammaRate = " + gammaRate);
		System.out.println("epsilonRate = " + epsilonRate);

		// Convert gammaRate and epsilonRate to decimals and multiply
		int gammaRateInt = Integer.parseInt(gammaRate, 2);
		int epsilonRateInt = Integer.parseInt(epsilonRate, 2);

		powerCons = gammaRateInt * epsilonRateInt;

		System.out.println("gammaRateInt = " + gammaRateInt);
		System.out.println("epsilonRateInt = " + epsilonRateInt);
		System.out.println("powerCons = " + powerCons);

	
		// keep this line at the end of your code
		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.format("Elapsed time: %dns%n", elapsedTime);
	}
}