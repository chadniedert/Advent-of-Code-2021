import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.*;

public class Day5Star1 
{
	public static void main(String[] args) 
	{
		Path filePath = Paths.get("day5data.txt");
		Charset charset = StandardCharsets.UTF_8;
		List<String> dataLines = new ArrayList<String>();
		try {
			dataLines = Files.readAllLines(filePath, charset);
		} catch (IOException ex) {
			System.out.format("I/O error: %s%n", ex);
		}
		long start = System.nanoTime();

		// create all Coordinates objects
		ArrayList<Coordinates> allCoords = new ArrayList<Coordinates>();
		for (int i = 0; i < dataLines.size(); i++)
		{
			int leftIndex = 0;
			int rightIndex = dataLines.get(i).indexOf(",");
			int a = Integer.parseInt(dataLines.get(i).substring(leftIndex, rightIndex));
			leftIndex = rightIndex + 1;
			rightIndex = dataLines.get(i).indexOf(" ");
			int b = Integer.parseInt(dataLines.get(i).substring(leftIndex, rightIndex));
			leftIndex = rightIndex + 4;
			rightIndex = dataLines.get(i).indexOf(",", leftIndex);
			int c = Integer.parseInt(dataLines.get(i).substring(leftIndex, rightIndex));
			leftIndex = rightIndex + 1;
			rightIndex = dataLines.get(i).length();
			int d = Integer.parseInt(dataLines.get(i).substring(leftIndex, rightIndex));
			Coordinates tempCoord = new Coordinates(a, b, c, d);
			allCoords.add(tempCoord);
		}
	
		// keep this line at the end of your code
		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.format("Elapsed time: %dns%n", elapsedTime);
	}
}