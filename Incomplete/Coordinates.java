public class Coordinates
{
	private int x1, y1, x2, y2;

	public Coordinates(int initX1, int initY1, int initX2, int initY2)
	{
		x1 = initX1;
		y1 = initY1;
		x2 = initX2;
		y2 = initY2;
	}

	public int getX1()
	{
		return x1;
	}

	public int getY1()
	{
		return y1;
	}

	public int getX2()
	{
		return x2;
	}

	public int getY2()
	{
		return y2;
	}

	public String toString()
	{
		return "Left: (" + x1 + ", " + y1 + "); Right: (" + x2 + ", " + y2 + ")";
	}
}