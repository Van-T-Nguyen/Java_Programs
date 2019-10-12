import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author VanV1
 *This is the game, it checks for errors and lets you interact with everything else
 */
public class Game {
	Player p = new Player(); // new permanent player

	/**
	 * This checks out all the possible errors
	 * @param response The bad input to be changed
	 * @param row The rows a board has
	 * @param column THe columns a board has
	 * @param cards A collection of tiles
	 * @param scnr This is how a response is changed
	 * @return response The input that is now fixed
	 */
	int errorLoop(int response, int row, int column, Tile[] cards, Scanner scnr) {
		System.out.println("Let's try this again, enter something we can use this time.");
		response = scnr.nextInt();
		while ((response < 1 || response > row * column) || (cards[response - 1].isFlipped())){
			response = scnr.nextInt();
		}
		return response;
	}
	/**
	 * This loops through the game until it's over or until a non int is entered
	 * @param scnr This lets you change the response
	 */
	void GameLoop(Scanner scnr) {
		int row = 6;
		int column = 6;
		int response;
		
		if (((row * column) % 2)) != 0){
			row++;
		}
		
		Board b = new Board();
		Tile[] cards = b.MakeBoard(row, column);
		
		b.PrintBoard(cards, row, column);
		
		System.out.printf("Enter a number between 1 and %d that aren't already flipped, or enter otherwise to quit\n", row * column);
		
		Tile tile1 = new Tile();
		Tile tile2 = new Tile();
		
		
		try {
			while (p.getMatches() < (row * column) / 2){
				response = scnr.nextInt();
				if ((response < 1 || response > row * column) || (cards[response - 1].isFlipped()))
				{
					response = errorLoop(response, row, column, cards, scnr);
				}
				cards[response - 1].Flip(p);
				tile1 = cards[response - 1];
				b.PrintBoard(cards, row, column);
				response = scnr.nextInt();
				if ((response < 1 || response > row * column) || (cards[response - 1].isFlipped()))
				{
					response = errorLoop(response, row, column, cards, scnr);
				}
				if (cards[response - 1] == tile1) {
					while(cards[response - 1] == tile1) {
						response = errorLoop(response, row, column, cards, scnr);
					}
				}
				cards[response - 1].Flip(p);
				tile2 = cards[response - 1];
				b.PrintBoard(cards, row, column);
				if (tile1 != tile2 && b.CheckMatched(tile1, tile2)) {
					p.AddMatches();
				}
			}
			System.out.printf("You were able to get %d matches in %d moves\n", p.getMatches(), p.getMoves());
			return;
		}
		catch (InputMismatchException e) {
			System.out.printf("You were able to get %d matches in %d moves\n", p.getMatches(), p.getMoves());
			System.out.println("Goodbye!");
			scnr.close();
			System.exit(0);
		}
		scnr.close();

	}
	/**
	 * This sets up the game and allows for continued replays
	 * @param args
	 */
	public static void main(String[] args) {
		Game newGame = new Game();
		Scanner scnr = new Scanner(System.in);
		int response;
		System.out.println("This is a simple game of memory, enter an int to start or otherwise to quit.");
		try {
			response = scnr.nextInt();
			while (response != 4324) { //random int that no one should ever get
					newGame.GameLoop(scnr);
					System.out.println("Enter an int to continue, or otherwise to quit");
					response = scnr.nextInt();
				}
		}
		catch (InputMismatchException e) {
			 System.out.println("Goodbye!");
			 scnr.close();
			 System.exit(0);
		}
	scnr.close();
	}
}
