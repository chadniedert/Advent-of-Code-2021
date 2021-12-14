import java.util.*;
import java.math.*;

public class Day6Star2
{
	public static void main(String[] args) 
	{
		long start = System.nanoTime();

		ArrayList<Integer> numArr = new ArrayList<Integer>(Arrays.asList(3,1,4,2,1,1,1,1,1,1,1,4,1,4,1,2,1,1,2,1,3,4,5,1,1,4,1,3,3,1,1,1,1,3,3,1,3,3,1,5,5,1,1,3,1,1,2,1,1,1,3,1,4,3,2,1,4,3,3,1,1,1,1,5,1,4,1,1,1,4,1,4,4,1,5,1,1,4,5,1,1,2,1,1,1,4,1,2,1,1,1,1,1,1,5,1,3,1,1,4,4,1,1,5,1,2,1,1,1,1,5,1,3,1,1,1,2,2,1,4,1,3,1,4,1,2,1,1,1,1,1,3,2,5,4,4,1,3,2,1,4,1,3,1,1,1,2,1,1,5,1,2,1,1,1,2,1,4,3,1,1,1,4,1,1,1,1,1,2,2,1,1,5,1,1,3,1,2,5,5,1,4,1,1,1,1,1,2,1,1,1,1,4,5,1,1,1,1,1,1,1,1,1,3,4,4,1,1,4,1,3,4,1,5,4,2,5,1,2,1,1,1,1,1,1,4,3,2,1,1,3,2,5,2,5,5,1,3,1,2,1,1,1,1,1,1,1,1,1,3,1,1,1,3,1,4,1,4,2,1,3,4,1,1,1,2,3,1,1,1,4,1,2,5,1,2,1,5,1,1,2,1,2,1,1,1,1,4,3,4,1,5,5,4,1,1,5,2,1,3));
	
		//ArrayList<Integer> numArr = new ArrayList<Integer>(Arrays.asList(3,4,3,1,2));

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
		numArr.clear();

		// when value starts at 1
		ArrayList<Integer> numArrTemp = new ArrayList<Integer>(Arrays.asList(1));
		int numDays = 80;
		for (int i = 1; i <= numDays; i++)
		{
			for (int j = 0; j < numArrTemp.size(); j++)
			{
				numArrTemp.set(j, numArrTemp.get(j) - 1);
				if (numArrTemp.get(j).equals(-1))
				{
					numArrTemp.add(9);
					numArrTemp.set(j, 6);
				}
			}
		}
		int num1 = numArrTemp.size();
		numArrTemp.clear();
		
/*
		// when value starts at 2
		numArrTemp.add(2);
		for (int i = 1; i <= numDays; i++)
		{
			for (int j = 0; j < numArrTemp.size(); j++)
			{
				numArrTemp.set(j, numArrTemp.get(j) - 1);
				if (numArrTemp.get(j).equals(-1))
				{
					numArrTemp.add(9);
					numArrTemp.set(j, 6);
				}
			}
		}
		int num2 = numArrTemp.size();
		numArrTemp.clear();

		// when value starts at 3
		numArrTemp.add(3);
		for (int i = 1; i <= numDays; i++)
		{
			for (int j = 0; j < numArrTemp.size(); j++)
			{
				numArrTemp.set(j, numArrTemp.get(j) - 1);
				if (numArrTemp.get(j).equals(-1))
				{
					numArrTemp.add(9);
					numArrTemp.set(j, 6);
				}
			}
		}
		int num3 = numArrTemp.size();
		numArrTemp.clear();

		// when value starts at 4
		numArrTemp.add(4);
		for (int i = 1; i <= numDays; i++)
		{
			for (int j = 0; j < numArrTemp.size(); j++)
			{
				numArrTemp.set(j, numArrTemp.get(j) - 1);
				if (numArrTemp.get(j).equals(-1))
				{
					numArrTemp.add(9);
					numArrTemp.set(j, 6);
				}
			}
		}
		int num4 = numArrTemp.size();
		numArrTemp.clear();

		// when value starts at 5
		numArrTemp.add(5);
		for (int i = 1; i <= numDays; i++)
		{
			for (int j = 0; j < numArrTemp.size(); j++)
			{
				numArrTemp.set(j, numArrTemp.get(j) - 1);
				if (numArrTemp.get(j).equals(-1))
				{
					numArrTemp.add(9);
					numArrTemp.set(j, 6);
				}
			}
		}
		int num5 = numArrTemp.size();
		numArrTemp.clear();*/

		// builds lfCount to count # of lanternfish
		int from1 = startTallies[0] * num1;
		/*int from2 = startTallies[1] * num2;
		int from3 = startTallies[2] * num3;
		int from4 = startTallies[3] * num4;
		int from5 = startTallies[4] * num5;*/
		System.out.println(from1); // 242373
		/*System.out.println(from2);
		System.out.println(from3);
		System.out.println(from4);
		System.out.println(from5);
		BigInteger lfCount = BigInteger.valueOf(0);
		lfCount = lfCount.add(BigInteger.valueOf(from1));
		lfCount = lfCount.add(BigInteger.valueOf(from2));
		lfCount = lfCount.add(BigInteger.valueOf(from3));
		lfCount = lfCount.add(BigInteger.valueOf(from4));
		lfCount = lfCount.add(BigInteger.valueOf(from5));
		System.out.println("lfCount = " + lfCount);*/


		// keep this line at the end of your code
		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.format("Elapsed time: %dns%n", elapsedTime);
	}
}