import java.util.Scanner; 

public class Driver{
    public static void main(String[] args){
		// Lists out valid commands
        System.out.print("Valid commands include: \n'menu' - to print out menu; ");
        System.out.println("\n'show' - to print out your current order. ");
        System.out.print("'total' - to show your current total; \n'enter' to quit the program; ");
        System.out.println("\nand 'help' - to display this prompt.");  

        // Create 15 menuItems
        
        // Create 5 entrees
        Entree Pizza = new Entree("Pizza", "1", 7.99, false);
        Entree Pasta = new Entree("Pasta", "2", 5.99, true);
        Entree Spaghetti = new Entree("Spaghetti", "3", 6.99, false);
        Entree MeatballSub = new Entree("Meatball Sub", "4", 7.99, false);
        Entree Lasagna = new Entree("Lasagna", "5", 8.99, false); 
       
        // Create 5 desserts
        Dessert Gelato = new Dessert("Gelato", "6", 5.99);
        Dessert Biscotti = new Dessert("Biscotti", "7", 5.99);
        Dessert CCake = new Dessert("Chocolate Cake", "8", 6.99);
        Dessert ApplePie = new Dessert("Apple Pie", "9", 7.99);
        Dessert Cheesecake = new Dessert("Cheesecake", "10", 6.99);
        
        // Create 5 drinks
        Drink CocaCola = new Drink("Coca Cola", "11", 2.99);
        Drink Sprite = new Drink("Sprite", "12", 2.99);
        Drink RootBeer = new Drink("RootBeer", "13", 2.99);
        Drink Water = new Drink("Water", "14", 2.99);
        Drink Lemonade = new Drink("Lemonade", "15", 2.99);
		
        // Create menu
        Menu myMenu = new Menu("Antonio's Italian Delights");
        
        // Add items to menu
        myMenu.addMenuItem(Pizza);
        myMenu.addMenuItem(Pasta);
        myMenu.addMenuItem(Spaghetti);
        myMenu.addMenuItem(MeatballSub);
        myMenu.addMenuItem(Lasagna);
        
        myMenu.addMenuItem(Gelato);
        myMenu.addMenuItem(Biscotti);
        myMenu.addMenuItem(CCake);
        myMenu.addMenuItem(ApplePie);
        myMenu.addMenuItem(Cheesecake);
        
        myMenu.addMenuItem(CocaCola);
        myMenu.addMenuItem(Sprite);
        myMenu.addMenuItem(RootBeer);
        myMenu.addMenuItem(Lemonade);
        myMenu.addMenuItem(Water);
        
        Scanner theInput = new Scanner(System.in);    

        // Instantiate ticket object(name of ticket + table number only)        
        Ticket t1 = new Ticket(1);
        
        // Update the full menu for the ticket class object
        t1.updateFullMenu(Pizza);
        t1.updateFullMenu(Pasta);
        t1.updateFullMenu(Spaghetti);
        t1.updateFullMenu(MeatballSub);
        t1.updateFullMenu(Lasagna);
        
        t1.updateFullMenu(Gelato);
        t1.updateFullMenu(Biscotti);
        t1.updateFullMenu(CCake);
        t1.updateFullMenu(ApplePie);
        t1.updateFullMenu(Cheesecake);
        
        t1.updateFullMenu(CocaCola);
        t1.updateFullMenu(Sprite);
        t1.updateFullMenu(RootBeer);
        t1.updateFullMenu(Lemonade);
        t1.updateFullMenu(Water);
        
        System.out.print("\nEnter your order number (1-15) or press \"Enter\" to exit: "); // Takes user input
        String command = theInput.nextLine();

        while (!command.equals("") || !"menu".equals(command) || !"show".equals(command) || !"total".equals(command) || !"help".equals(command))        
        {
                    
            if (command.equals("")) {
                System.out.println("See you again!"); 
                System.exit(1);
            }
            
            if (command.toLowerCase().equals("menu")) { System.out.println(myMenu.toString() + "\n\n"); }
            
            if (command.toLowerCase().equals("show")) { System.out.println(myMenu.toString() + "\n\n"); }

            if (command.toLowerCase().equals("total")) { System.out.println(myMenu.toString() + "\n\n"); }

            if (command.toLowerCase().equals("delete")) { 
                    t1.deleteOrder();
                    t1 = new Ticket(1);
            }

            if (command.toLowerCase().equals("help")) {
                System.out.print("Valid commands include: menu - to print out menu; ");
                System.out.println("show - to print out your current order; ");
                System.out.print("total - to show your current total; delete - to delete the current order; ");
                System.out.println("\"enter\" to quit the program; and help - to display this prompt.");
            }
            
            if (command.matches("-?\\d+")){
                int orderCode = Integer.parseInt(command); //User input becomes orderCode 
                 // Add menu items via order code
                switch (orderCode){
                    case 1: t1.addByCode("1");
                            break;
                    case 2: t1.addByCode("2");
                            break;
                    case 3: t1.addByCode("3");
                            break;
                    case 4: t1.addByCode("4");
                            break;
                    case 5: t1.addByCode("5");
                            break;
                    case 6: t1.addByCode("6");
                            break;
                    case 7: t1.addByCode("7");
                            break;
                    case 8: t1.addByCode("8");
                            break;
                    case 9: t1.addByCode("9");
                            break;
                    case 10: t1.addByCode("10");
                            break;
                    case 11: t1.addByCode("11");
                            break;
                    case 12: t1.addByCode("12");
                            break;
                    case 13: t1.addByCode("13");
                            break;
                    case 14: t1.addByCode("14");
                            break;
                    case 15: t1.addByCode("15");
                            break;
                            
                }
            }           

            // Print both tickets to the screen
            System.out.println(t1.toString());
            System.out.println();	
            System.out.print("Please enter your order number or press \"Enter\" to exit(1-10): "); // Restarts the loop
            command = theInput.next();
        }
    }    
}