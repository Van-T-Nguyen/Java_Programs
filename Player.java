/**
 * 
 */

/**
 * @author VanV1
 * This makes a player and keeps track of their matches and number of moves
 */
public class Player {

	private int moves;
	private int matches;
	
	/**
	 * Makes a player and sets moves and matches to zero
	 */
	Player() {
		moves = 0;
		matches = 0;
	}
	
	/**
	 * Increments Matches
	 */
	public void AddMatches() {
		matches++;
	}

	/**
	 * Returns the amount of matches
	 * @return matches the amount of card pairs matched
	 */
	public int getMatches() {
		return matches;
	}

	/**
	 * Increments moves
	 */
	public void AddMoves() {
		moves++;
	}

	/**
	 * Returns the amount of moves
	 * @return moves the amount of flips a player makes
	 */
	public int getMoves() {
		return moves;
	}
}