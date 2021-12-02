import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.*;

public class Day1 
{
	public static void main(String[] args) 
	{
		Path filePath = Paths.get("day1data.txt");
		Charset charset = StandardCharsets.UTF_8;
		List<String> dataLines = new ArrayList<String>();
		try {
			dataLines = Files.readAllLines(filePath, charset);
		} catch (IOException ex) {
			System.out.format("I/O error: %s%n", ex);
		}
		long start = System.nanoTime();

		// part 1 solution
		List<Integer> convIntList = new ArrayList<Integer>();

		for (String x : dataLines)
		{
			convIntList.add(Integer.parseInt(x));
		}

		int count = 0;
		for (int i = 1; i < convIntList.size(); i++)
		{
			if (convIntList.get(i - 1) < convIntList.get(i))
				count++;
		}

		System.out.println("Day 1 Star 1: " + count);

		int pt2Count = 0;
		// part 2 solution
		for (int i = 0; i < convIntList.size() - 3; i++)
		{
			int sum1 = convIntList.get(i) + convIntList.get(i + 1) + convIntList.get(i + 2);
			int sum2 = convIntList.get(i + 1) + convIntList.get(i + 2) + convIntList.get(i + 3);
			if (sum1 < sum2)
			{
				pt2Count++;
			}
		}

		System.out.println("Day 1 Star 2: " + pt2Count);

		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.format("Elapsed time: %dns%n", elapsedTime);
	}
}