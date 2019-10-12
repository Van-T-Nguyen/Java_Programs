import java.io.*;

public class Item implements Serializable{

	private String id;
	private String name;
	private int quantity;
	}
	
	public Book( String csv ){
		String[] temp = csv.split( "," );
		this.title = temp[ 0 ];
		this.pageCount = Integer.parseInt( temp[ 1 ] );
		this.author = new Author( temp[ 3 ].trim(), temp[ 2 ].trim() );
	}*/
	
	// Parameterized Constructor
	// note the arguments between the parens.
	public Item( String id, String name, int quantity ){
		this.id = id;
		this.name = name;
		this.quantity = quantity;
	}
	
	// Setters and getters
	public void setID( String id ){
		this.id = id;
	}
	
	public String getID(){
		return id;
	}
	
	public void setName( String name ){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setQuantity( int Quantity ){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return quantity;
	}
	
	public String toString(){
		return "ID: " + id
			+ ", Name: " + name
			+ ", Quantity: " + quantity;
	}
	
	public String toCSV(){
		return id + "," + name + "," + quantity;
	}
	
}















