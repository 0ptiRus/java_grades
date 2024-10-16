package classwork07_10_24;

public class ConsoleLogger implements Message 
{
	@Override
	public void Print(String message)
	{
		System.out.println(message);
	}
}
