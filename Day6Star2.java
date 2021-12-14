import java.util.*;
import java.math.*;

public class Day6Star2
{
	public static void main(String[] args) 
	{
		long start = System.nanoTime();

		/*ArrayList<Integer> numArr = new ArrayList<Integer>(Arrays.asList(3,1,4,2,1,1,1,1,1,1,1,4,1,4,1,2,1,1,2,1,3,4,5,1,1,4,1,3,3,1,1,1,1,3,3,1,3,3,1,5,5,1,1,3,1,1,2,1,1,1,3,1,4,3,2,1,4,3,3,1,1,1,1,5,1,4,1,1,1,4,1,4,4,1,5,1,1,4,5,1,1,2,1,1,1,4,1,2,1,1,1,1,1,1,5,1,3,1,1,4,4,1,1,5,1,2,1,1,1,1,5,1,3,1,1,1,2,2,1,4,1,3,1,4,1,2,1,1,1,1,1,3,2,5,4,4,1,3,2,1,4,1,3,1,1,1,2,1,1,5,1,2,1,1,1,2,1,4,3,1,1,1,4,1,1,1,1,1,2,2,1,1,5,1,1,3,1,2,5,5,1,4,1,1,1,1,1,2,1,1,1,1,4,5,1,1,1,1,1,1,1,1,1,3,4,4,1,1,4,1,3,4,1,5,4,2,5,1,2,1,1,1,1,1,1,4,3,2,1,1,3,2,5,2,5,5,1,3,1,2,1,1,1,1,1,1,1,1,1,3,1,1,1,3,1,4,1,4,2,1,3,4,1,1,1,2,3,1,1,1,4,1,2,5,1,2,1,5,1,1,2,1,2,1,1,1,1,4,3,4,1,5,5,4,1,1,5,2,1,3));*/
	
		ArrayList<Integer> numArr = new ArrayList<Integer>(Arrays.asList(3,4,3,1,2));

		// when value starts at 1
		ArrayList<Integer> numArrStart1 = new ArrayList<Integer>(Arrays.asList(1));
		int numDays = 18;
		for (int i = 1; i <= numDays; i++)
		{
			for (int j = 0; j < numArrStart1.size(); j++)
			{
				numArrStart1.set(j, numArrStart1.get(j) - 1);
				if (numArrStart1.get(j).equals(-1))
				{
					numArrStart1.add(9);
					numArrStart1.set(j, 6);
				}
			}
		}

		// when value starts at 2
		ArrayList<Integer> numArrStart2 = new ArrayList<Integer>(Arrays.asList(2));
		numDays = 18;
		for (int i = 1; i <= numDays; i++)
		{
			for (int j = 0; j < numArrStart2.size(); j++)
			{
				numArrStart2.set(j, numArrStart2.get(j) - 1);
				if (numArrStart2.get(j).equals(-1))
				{
					numArrStart2.add(9);
					numArrStart2.set(j, 6);
				}
			}
		}

		// when value starts at 3
		ArrayList<Integer> numArrStart3 = new ArrayList<Integer>(Arrays.asList(3));
		numDays = 18;
		for (int i = 1; i <= numDays; i++)
		{
			for (int j = 0; j < numArrStart3.size(); j++)
			{
				numArrStart3.set(j, numArrStart3.get(j) - 1);
				if (numArrStart3.get(j).equals(-1))
				{
					numArrStart3.add(9);
					numArrStart3.set(j, 6);
				}
			}
		}

		// when value starts at 4
		ArrayList<Integer> numArrStart4 = new ArrayList<Integer>(Arrays.asList(4));
		numDays = 18;
		for (int i = 1; i <= numDays; i++)
		{
			for (int j = 0; j < numArrStart4.size(); j++)
			{
				numArrStart4.set(j, numArrStart4.get(j) - 1);
				if (numArrStart4.get(j).equals(-1))
				{
					numArrStart4.add(9);
					numArrStart4.set(j, 6);
				}
			}
		}

		// when value starts at 5
		ArrayList<Integer> numArrStart5 = new ArrayList<Integer>(Arrays.asList(5));
		numDays = 18;
		for (int i = 1; i <= numDays; i++)
		{
			for (int j = 0; j < numArrStart5.size(); j++)
			{
				numArrStart5.set(j, numArrStart5.get(j) - 1);
				if (numArrStart5.get(j).equals(-1))
				{
					numArrStart5.add(9);
					numArrStart5.set(j, 6);
				}
			}
		}

		// tallies number of 1, 2, 3, 4, 5 in starting data set
		int[] startTallies = {0,0,0,0,0};
		for (Integer num : numArr)
		{
			if (num.equals(1))
			{
				startTallies[0]++;
			}
			else if (num.equals(2))
			{
				startTallies[1]++;
			}
			else if (num.equals(3))
			{
				startTallies[2]++;
			}
			else if (num.equals(4))
			{
				startTallies[3]++;
			}
			else if (num.equals(5))
			{
				startTallies[4]++;
			}
		}

		// builds lfCount to count # of lanternfish
		int from1 = startTallies[0] * numArrStart1.size();
		int from2 = startTallies[1] * numArrStart2.size();
		int from3 = startTallies[2] * numArrStart3.size();
		int from4 = startTallies[3] * numArrStart4.size();
		int from5 = startTallies[4] * numArrStart5.size();
		System.out.println(from1);
		System.out.println(from2);
		System.out.println(from3);
		System.out.println(from4);
		System.out.println(from5);
		BigInteger lfCount = BigInteger.valueOf(0);
		lfCount = lfCount.add(BigInteger.valueOf(from1));
		lfCount = lfCount.add(BigInteger.valueOf(from2));
		lfCount = lfCount.add(BigInteger.valueOf(from3));
		lfCount = lfCount.add(BigInteger.valueOf(from4));
		lfCount = lfCount.add(BigInteger.valueOf(from5));
		System.out.println("lfCount = " + lfCount);


		// keep this line at the end of your code
		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.format("Elapsed time: %dns%n", elapsedTime);
	}
}