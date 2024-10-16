package classwork07_10_24;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger implements Message
{
	private String messagePrefix = "[Logger]:";
	private PrintWriter writer;
	
	public FileLogger()
	{
		Date ltm = new Date( );
	    //SimpleDateFormat lt = new SimpleDateFormat ("'dd.MM:hh:mm:ss a'");
	    //final String logtm = lt.format(ltm);
	    try {
			writer = new PrintWriter("LOGTIME_"+"02020112120", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    String prefix = "[Logger]:";

	    writer.println(prefix + "Logger opened!"); 

	    writer.println("----------xXx----------");
	    writer.flush();
	}
	
	@Override
	public void Print(String message)
	{
		try
		{
			writer.println(messagePrefix + " - " + message);		
			writer.flush();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
