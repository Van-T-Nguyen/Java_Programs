public class Entree extends MenuItem
{
    boolean vegetarian; // New Variable
    
	//Inherits from MenuItem
    public Entree(String name, String orderCode, double price, boolean vegetarian){
        super(name, orderCode, price);
        this.vegetarian = vegetarian;
    }   
    
	// Setter
    public void setVegetarian(boolean vegetarian)
    {
        this.vegetarian = vegetarian;
    }
    
	
	// Getter
    public boolean getVegetarian()
    {
        return vegetarian;
    }
}