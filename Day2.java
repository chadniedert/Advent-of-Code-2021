import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.*;

public class Day2
{
	public static void main(String[] args) 
	{
		Path filePath = Paths.get("day2data.txt");
		Charset charset = StandardCharsets.UTF_8;
		List<String> dataLines = new ArrayList<String>();
		try {
			dataLines = Files.readAllLines(filePath, charset);
		} catch (IOException ex) {
			System.out.format("I/O error: %s%n", ex);
		}
		long start = System.nanoTime();

		int horizPos = 0;
		int vertPos = 0;
		int prod = 0;

		for (int i = 0; i < dataLines.size(); i++)
		{
			if (dataLines.get(i).contains("forward"))
			{
				horizPos += Integer.parseInt(dataLines.get(i).substring(8,9));
			}
			else if (dataLines.get(i).contains("up"))
			{
				vertPos -= Integer.parseInt(dataLines.get(i).substring(3,4));
			}
			else if (dataLines.get(i).contains("down"))
			{
				vertPos += Integer.parseInt(dataLines.get(i).substring(5,6));
			}
			else 
			{
				System.out.println("something went wrong");
				break;
			}
		}

		prod = horizPos * vertPos;
		System.out.println("horizPos = " + horizPos);
		System.out.println("vertPos = " + vertPos);
		System.out.println("prod = " + prod);

	
		// keep this line at the end of your code
		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.format("Elapsed time: %dns%n", elapsedTime);
	}
}