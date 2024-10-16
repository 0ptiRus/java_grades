package classwork07_10_24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Grades {
	
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
	
	public static void main(String[] args)
	{
//		ConsoleLogger logger = new ConsoleLogger();
//		FileLogger fileLogger = new FileLogger();
//		
//		int grades = 7;
//		ArrayList<Integer> s1 = Grades.stud(grades);
//		ArrayList<Integer> s2 = Grades.stud(grades);
//		ArrayList<Integer> s3 = Grades.stud(grades);
//		
//		double avg1 = Grades.avg(grades, s1);
//		double avg2 = Grades.avg(grades, s2);
//		double avg3 = Grades.avg(grades, s3);
//		
//		if(avg1 < 6 || avg2 < 6 || avg3 < 6)
//		{
//			logger.Print("A student is failing a class!");
//			fileLogger.Print("A student is failing a class!");
//		}
//		
//		double max_avg = Math.max(avg1, Math.max(avg2, avg3));
//		double min_avg = Math.min(avg1, Math.min(avg2, avg3));
//		
//		int needed_grades = Grades.howFarBehind(max_avg, min_avg);
//		
//		System.out.println(avg1);
//		System.out.println(avg2);
//		System.out.println(avg3);
//		System.out.println("Best avg - " + max_avg);
//		System.out.println("The worst student needs " + needed_grades + " A's to reach the top student");
		
		List<Integer> numbers = Arrays.asList (5, 1, 4, 2, 3, 0);
		numbers.stream()
			.filter(number -> number % 2 == 0);
		
		Function<String, Integer> stringToLength = str -> str.length();
        System.out.println(stringToLength.apply("Hello"));
        
        Predicate<Integer> isPositive = num -> num > 0;
        System.out.println(isPositive.test(5));
        
        UnaryOperator<Integer> increment = num -> num + 1;
        System.out.println(increment.apply(5));
        
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(5, 3));
        
        Supplier<String> greetSupplier = () -> "Hello, World!";
        System.out.println(greetSupplier.get());
        
        Consumer<String> printNumber = val -> { if(val == "Hello, World!") System.out.println("Hello to you too!");};
        printNumber.accept(greetSupplier.get());
		
		//System.out.println("hello! :D");
	}
}
