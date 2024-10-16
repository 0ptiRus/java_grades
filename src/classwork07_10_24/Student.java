package classwork07_10_24;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Student implements Consumer<Student>, Predicate<Double> {
	private String name;
	private ArrayList<Integer> grades;
	private double avg;
	
	public Student(String _name, ArrayList<Integer> _grades, double _avg)
	{
		name = _name;
		grades = _grades;
		avg = _avg;
	}
	
	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	
	public ArrayList<Integer> getGrades() { return this.grades; }
	public void setGrades(ArrayList<Integer> grades) { this.grades = grades; }
	
	public double getAvg() { return this.avg; }
	public void setAvg(double avg) { this.avg = avg; }
	
	static ArrayList<Integer> stud(int count)
	{
		Random rand = new Random();
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i < count; i++)
		{
			arr.add(1 + rand.nextInt(12));
		}
		return arr;
	}
	
	static double avg(int amount, ArrayList<Integer> grades)
	{
		int sum = 0;
		for(int i = 0; i < grades.size(); i++)
		{
			sum += grades.get(i);
		}
		return (double) (sum / amount);
	}
	
	static int howFarBehind(double max_avg, double min_avg)
	{
		int max_grade = 12;
		if(min_avg >= max_avg)
		{
			return 0;
		}
		
		double difference = max_avg - min_avg;
        double needed_grades = Math.ceil(difference / (max_grade - min_avg));
        
        return (int) needed_grades;
	}


	@Override
	public void accept(Student s) 
	{
	    try (PrintWriter writer = new PrintWriter("STUDENT_"+s.getName(), "UTF-8")) {
	    	writer.println("Student - " + s.getName() + " " + s.getGrades() + " " + s.getAvg());
	    	writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public boolean test(Double t) 
	{
		return t > 7;
	}
	
	
}
