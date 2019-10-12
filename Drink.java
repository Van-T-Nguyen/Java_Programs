public class Drink extends MenuItem{
    
	char size; // New variable
    
	// Inherits from MenuItem
    public Drink(String name, String orderCode, double price){
        super(name, orderCode, price);
    }
    
	// Setter
    public void setSize(char size){
        this.size = size;
    }
    
	//Getter
    public char getSize(){
        return size;
    }
}