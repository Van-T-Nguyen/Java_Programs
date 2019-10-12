import java.io.*;

public class ItemWriter{

	public static void main( String[] args ){
	
		// Makes 10 and defines 10 items
		Item Apple = new Item("ap", "apple", 11);
		Item Orange = new Item("or", "orange", 27);
		Item Kiwi = new Item("kw", "kiwi", 30);
		Item Banana = new Item("bn", "banana", 124);
		Item Peach = new Item("ph", "peach", 45);
		Item Strawberry = new Item("sb", "strawberry", 598);
		Item Cherry = new Item("ch", "cherry", 201);
		Item Blueberry = new Item("bb", "blueberry", 321);
		Item Grape = new Item("gp", "grape", 25);
		Item Watermelon = new Item("wm", "watermelon", 2);	
		
		try(
			FileWriter fw = new FileWriter( "item.csv" );
			BufferedWriter bw = new BufferedWriter( fw );
			PrintWriter pw = new PrintWriter( bw );
		){

			//Writes the items to the csv file
			pw.println( Apple.toCSV() );
			pw.println( Orange.toCSV() );
			pw.println( Kiwi.toCSV() );
			pw.println( Banana.toCSV() );
			pw.println( Peach.toCSV() );
			pw.println( Strawberry.toCSV() );
			pw.println( Cherry.toCSV() );
			pw.println( Blueberry.toCSV() );
			pw.println( Grape.toCSV() );
			pw.println( Watermelon.toCSV() );			
			
		}catch( IOException e ){
			e.printStackTrace();
		}
		
	
	}

}