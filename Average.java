/*Author: Van Nguyen
Class: Introduction to Java
Project: Project 03
DateDue: 2018.06.22
This program fills an arraylist with arguments and outputs max, min, and average values
*/

import java.util.*;

public class Average{
	public static void main(String[] args){

		ArrayList<Integer> numbers = new ArrayList<>(); //Creates an ArrayList called "numbers"
		

		for( String s : args ){
		
		numbers.add( Integer.parseInt(s) ); //Populates numbers with arguments from the command line
		}
		
			
		int sum = 0;
		
		for (int i: numbers) {
			
			sum += i; //Gets the sum of all the values in the ArrayList
		
		}
		
		System.out.println("Welcome to the average program. It is rather average.");
		
		if (numbers.size() == 0){
			
			System.out.println("This program fills an arraylist with arguments and outputs max, min, and average values"); //Back-up message in the case of no inputs
		
		}else{
						
			System.out.println("The highest given value: " + Collections.max(numbers)); //Gets and prints out highest value in numbers
		
			System.out.println("The lowest given value: " + Collections.min(numbers)); //Gets and prints out lowest value in numbers
		
			double average = ((double)sum / (double)numbers.size()); //Finds the average value in numbers
		
			System.out.printf("The average is: %.1f", average); //Prints out average value
	
		}

	}	
}