import java.util.ArrayList;

public class Ticket{
    int tableNumber;
    ArrayList<MenuItem> menuItems = new ArrayList<>();
    
    // Full menu list
    ArrayList<MenuItem> menuArray = new ArrayList<>();

    
    // Constructor to create a ticket object with a desired tableNumber
    public Ticket(int tableNumber){
        this.tableNumber = tableNumber;
    }    
   
    // Basic function to add an item to the order
    public void addMenuItem(MenuItem item){
        menuItems.add(item);        
    }
    
    public void updateFullMenu(MenuItem item){
        menuArray.add(item);
    }
    
    // Function to add an item to the ticket by orderCode
    public void addByCode(String orderCode){
        for (int i = 0; i < menuArray.size(); i++){
            if (orderCode.equals(menuArray.get(i).getOrderCode())){
                addMenuItem(menuArray.get(i));
            }                    
        }      
    }
    
    // Call seperately to list the items currently ordered.
    // Call through toString method to print out the order to the screen and show the total cost of the items ordered.
    public String orderPrint(){
        String itemNames = "";
        for (int i = 0; i < menuItems.size(); i++){
            itemNames = itemNames + ", " + menuItems.get(i).getName();
        }
        
        return itemNames;
    }
    
    // Setter and getter for tableNumber
    public void setTableNumber(int tableNumber){
        this.tableNumber = tableNumber;
    }
    
    public int getTableNumber(){
        return tableNumber;
    }
    
    // Calculates the total cost of the items
    public double getTotal(){
        double total = 0;
        for (int i = 0; i < menuItems.size(); i++){
            total = total + menuItems.get(i).getPrice();
        }  
        return total;        
    }
	
    public String viewOrder(){
        String itemNames = "";
        for (int i = 0; i < menuItems.size(); i++){
            itemNames = itemNames + ", " + menuItems.get(i).getName();
        }
        
        return itemNames;	
    }
    
    // Clears the arraylist, empties the order.
    public void deleteOrder(){
        menuItems.clear();
    }
	
    @Override
    // Print table number, the items, total of the items in the ticket.
    public String toString(){
        return "Table Number: " + tableNumber + "\nItems ordered (in ticket): " + orderPrint() + "\nTotal cost of items ordered: $" + getTotal();
    }
    
    
    
}
