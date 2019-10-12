abstract public class MenuItem{
    // Variable declarations
    String name;
    String orderCode;
    double price;
    
    
    public MenuItem(String name, String orderCode, double price){
        this.name = name;
        this.price = price;
        this.orderCode = orderCode;
    }
    
    // Setters
    public void setName(String name){
        this.name = name;
    }    
    public void setPrice(double price){
        this.price = price; 
    }    
    public void setOrderCode(String orderCode){
        this.orderCode = orderCode;
    }
    
    // Getters
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public String getOrderCode(){
        return orderCode;
    }
    
    /*
    // toString override method
    @Override
    public String toString(){
        return "Item Name: " + getName() + " Price: " + getPrice() + "Desc: " + getDescription() + " OrderCode: " + getOrderCode();
    }
    */
	
}