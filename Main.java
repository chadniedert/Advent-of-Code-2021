
/*
Thanks for using Replit for Advent of Code!

Here are a few tips:

1. To install packages, just import them and Replit will install them for you, or click on the cube in the sidebar to install manually.
2. If you're stuck, try using the debugger in the sidebar shaped like a play/pause button.
3. When you're done, you can share your project by clicking the project name and then "Publish"
3.a When you share your project, use the #adventofcode hashtag!
4. Have fun, and good luck!
*/
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.*;

class Main {
	public static void main(String[] args) {
		/*
		 * Place your question data into the data.txt file. You may need to parse the
		 * data!
		 */
		Path filePath = Paths.get("data.txt");
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

		// Keep this line at the end of your code
		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.format("Elapsed time: %dns%n", elapsedTime);
	}
}