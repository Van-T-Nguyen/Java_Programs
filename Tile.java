/**
 * 
 */

/**
 * @author VanV1
 * This is a Tile, it can be flipped or matched, it also holds the info of everything
 */
public class Tile {

	private int value;
	private boolean flipped;
	private boolean matched;
	
	/**
	 * Empty Tile constructor for whenever I want a new instance of it
	 */
	public Tile() {
	
	}
	
	/**
	 * This makes a Tile and assigns it a value and a ID
	 * @param value the value to be given to the tile
	 * @param id the number to be displayed on the unflipped card
	 */
	public Tile(int value, int id){
		this.setValue(value);
		setFlipped(false);
		setMatched(false);
	}
	
	/**
	 * This flips a card and adds moves
	 * @param p The player whose moves are to be augmented
	 */
	public void Flip(Player p) {
		this.setFlipped(true);
		p.AddMoves();

	}
	
	/**
	 * This prints out a line
	 */
	void printLine(){
		System.out.print("---------");	
	}
	
	/**
	 * This prints out nonvalue borders, matched is blank
	 */
	void printBorder() {
		if (this.isMatched()){
			System.out.print("         ");
		}
		else {
			System.out.print("|       |");
		}
	}
	
	/**
	 * This prints out the value or ID of a card depending on whether it's flipped or not, matched is blank
	 * @param id This is the value to be displayed on an unflipped card
	 */
	 void printValue(int id) {
		if (this.isMatched()) {
			System.out.print("         ");
		}
		else if (this.isFlipped()) {
			System.out.printf("|**%2d***|", this.getValue());
		}
		else {
			System.out.printf("|  %2d   |", id);
		}
	}

	 /**
	  * Tells whether a tile is flipped or not
	  * @return flipped status
	  */
	public boolean isFlipped() {
		return flipped;
	}

	/**
	 * This flips or unflips a tile
	 * @param flipped the status of a flip
	 */
	public void setFlipped(boolean flipped) {
		this.flipped = flipped;
	}
	
	/**
	 * This tells a tile's value
	 * @return value the tile's value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * This set's a tile's value
	 * @param value the tile's value to be set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * This tells whether a tile is matched with another yet
	 * @return matched The matched status of a tile
	 */
	public boolean isMatched() {
		return matched;
	}

	/**
	 * This sets a tile's match status
	 * @param matched The matched status to be set
	 */
	public void setMatched(boolean matched) {
		this.matched = matched;
	}
}