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

		System.out.println(dataLines);
		System.out.println(dataLines.size());
		System.out.println(dataLines2);

		// keep this line at the end of your code
		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.format("Elapsed time: %dns%n", elapsedTime);
	}
}