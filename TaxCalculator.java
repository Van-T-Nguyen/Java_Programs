/*Author: Van Nguyen
Class: Introduction to Java
Project: Project 02
DateDue: 2018.06.15
This program takes user input and determines tax, tip, and total
*/

import java.util.Scanner;

public class TaxCalculator {
	public static void main(String[] args){
		
		Scanner userInput[] = new Scanner(System.in);
		
		
		double tax = .08517;// tax constant
		
		System.out.print("Please enter a total: "); //Takes user input
		double total = theInput.nextDouble(); //User input becomes total
				
		System.out.print("Please enter a tip percentage: "); //Takes user input
		int tip = theInput.nextInt(); //User input becomes tip percentage
		
		double taxFee= (total * tax); //Calculates tax only
		System.out.printf("The tax is: $%.2f\n", taxFee);
		
		double newTip = (tip / (double)100) * (taxFee + total); //Calculates tip only
		System.out.printf("The tip is: $%.2f\n", newTip);

		double finalTotal = (taxFee + total + newTip); //Final total is total with the tax and tip
		System.out.printf("The total is: $%.2f\n", finalTotal);
		
	}
}