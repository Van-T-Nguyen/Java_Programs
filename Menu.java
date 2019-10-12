import java.util.ArrayList;
import java.util.Arrays;
import java.text.DecimalFormat;

public class Menu{
    String restaurantName;
    ArrayList<MenuItem> menuItems = new ArrayList<>();
    ArrayList<String> stringItems = new ArrayList<>();
    
    // Constructor
    public Menu(String restaurantName){
        this.restaurantName = restaurantName;
    }
    
    // Basic function to add an item to the menu
    public void addMenuItem(MenuItem item){
        menuItems.add(item);        
    }
    // Prints out the entirety of the menuitems ArrayList with no formatting (not being used)
    public String menuPrint(){
        return menuItems.toString();
    }
    
    // Returns `myArray` as a formatted array of the contents of the ArrayList.
    public String printMenu(){
        DecimalFormat df = new DecimalFormat("#.##");
        String[] myArray = new String[menuItems.size()];
        for (int i = 0; i < menuItems.size(); i++){
            myArray[i] = ("\nItem Name: " + menuItems.get(i).getName() + 
                          "\nPrice: $" + df.format(menuItems.get(i).getPrice()) +
                          "\nOrder Code: " + menuItems.get(i).getOrderCode() + "\n");

        }
        return Arrays.toString(myArray);
    }
    
    // Setter and getter for restaurantName
    public void setRestaurantName(String restaurantName){
        this.restaurantName = restaurantName;
    }
    public String getRestaurantName(){
        return this.restaurantName;
    }
    
    // call this function to print out the details of an item by orderCode
    public String getByOrderCode(String orderCode){
        DecimalFormat df = new DecimalFormat("#.##");
        String[] codeItem  = new String[1];
        for (int i = 0; i < menuItems.size(); i++){
            if (orderCode == menuItems.get(i).getOrderCode()){
                codeItem[i] = ("\nItem Name: " + menuItems.get(i).getName() + 
                          "\nPrice: $" + df.format(menuItems.get(i).getPrice()) +
                          "\nOrder Code: " + menuItems.get(i).getOrderCode() + "\n");
            }                    
        }
        return Arrays.toString(codeItem);
    }
    
    // toString override method
    @Override
    public String toString(){
        return getRestaurantName() + " serves: " + "\n" + printMenu();
    }
}
