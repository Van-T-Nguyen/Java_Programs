import java.util.Random;

/**
 * 
 * @author VanV1
 * This is the board, it can print itself out, check matches, and make cards
 */
public class Board {
	
	/**
	 * This creates a collection of ints to assign to tiles
	 * @param row how many rows a board will have
	 * @param column how many columns a board will have
	 * @return values an array of ints with which to populate the board
	 */
	private int[] ValueSet(int row, int column) {
		
		int value = 1;
		int[] values = new int[row * column];
		
		for (int i = 0; i < values.length - 1;i ++) {
			values[i++] = value;
			values[i] = value++;
		}
		return values;
	}
	/**
	 * Makes a board with which to play and assigns values randomly
	 * @param row the amount of rows a board has
	 * @param column the amount of columns a board has
	 * @return board Gives a board consisting of row * column tiles
	 */
	public Tile[] MakeBoard(int row, int column) {
		
		int[] values = ValueSet(row, column);
		int id = 1;
		int temp;
		Random rand = new Random();
		int value;
		Tile[] board = new Tile[row * column];
		
		for (int i = 0; i < row; i++) {
			
			for (int j = 0; j < column; j++) {
				value = rand.nextInt(values.length);
				board[id - 1] = new Tile(values[value], id++);
				int[] shrink = new int[values.length - 1]; // Makes a smaller values
				temp = values[value];
				values[value] = values[values.length - 1];
				values[values.length - 1] = temp; // chucks the random value at the end
				System.arraycopy(values, 0, shrink, 0, values.length - 1); 
				values = shrink; // cuts off the used value
			}
		}
		return board;
	}
	/**
	 * This compares two values and determines whether they are a match or not
	 * @param tile1 The first tile to be compared
	 * @param tile2 The second tile to be compared
	 * @return boolean whether the two tiles matched values or not
	 */
	public boolean CheckMatched(Tile tile1, Tile tile2) {
		
		if (tile1.getValue() == tile2.getValue()) {
			tile1.setMatched(true);
			tile2.setMatched(true);
			return true;
		}
		else {
			tile1.setFlipped(false);
			tile2.setFlipped(false);
			return false;
		}
	}
	/**
	 * This prints out the entire board a card at a time
	 * @param cards a collection of tiles
	 * @param row the amount of rows a board has
	 * @param column the amount of columns a board has
	 */
	public void PrintBoard(Tile[] cards, int row, int column) {
		
	int place = 0;
		for (int i = 0; i < column; i++) {
		cards[place].printLine();
		}
		for (int x = 0; x < row; x++)
		{
			System.out.println();
			
			for (int j = 0; j < column; j++) {
				cards[place++].printBorder();
			}
			place -= column; // resets card position for next for loop
			System.out.println();
			
			for (int j = 0; j < column; j++) {
				cards[place++].printValue(place);
			}
			place -= column; // resets card position for next for loop
			System.out.println();
			
			for (int j = 0; j < column; j++) {
				cards[place++].printBorder();
			}
			place -= column; // resets card position for next for loop
			System.out.println();
			
			for (int i = 0; i < column; i++) {
			cards[place++].printLine();
			}
		}
		System.out.println();
	}
}
