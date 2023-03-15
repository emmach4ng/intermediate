//missing quit method, price volatility, sale price, inventory
//unfinished purchase method

import java.util.ArrayList;
import java.util.Scanner;

class Item {
        
    String name;
    String category;
    int bottomPriceRange;
    int topPriceRange;
    int salePrice; //PUT THIS IN LATER
    
    Item(String name, String category, int bottomPriceRange, int topPriceRange) {
        this.name = name;
        this.category = category;
        this.bottomPriceRange = bottomPriceRange;
        this.topPriceRange = topPriceRange;
        // this.salePrice = the purchase price - 10% fee
    }

}

public class SuperStore {

    /**
     * @param args
     * @throws Exception
     */

    static ArrayList<Item> items = new ArrayList<Item>();

    public static void main(String[] args) throws Exception {


        items.add(new Item("McDonald's", "Food", 1300000, 1500000));
        items.add(new Item("Michelin Star Restaurant", "Food", 5000000, 10000000));
        items.add(new Item("Boba Shop", "Food", 100000, 150000));
        items.add(new Item("Steakhouse", "Food", 750000, 775000));
        items.add(new Item("Gyro Truck", "Food", 80000, 100000));
        items.add(new Item("KBBQ Restaurant", "Food", 300000, 400000));
        items.add(new Item("Unlimited Grocery Delivery Service", "Food", 100000, 150000));
        items.add(new Item("Café", "Food", 150000, 200000));
        items.add(new Item("Chauffeur", "Employees", 30000, 40000));
        items.add(new Item("Housekeeper", "Employees", 45000, 50000));
        items.add(new Item("Private Chef", "Employees", 90000, 100000));
        items.add(new Item("Pilot", "Employees", 90000, 100000));
        items.add(new Item("Lifeguard", "Employees", 30000, 45000));
        items.add(new Item("Gardener", "Employees", 35000, 40000));
        items.add(new Item("Victorian Mansion", "Employees", 600000, 800000));
        items.add(new Item("Modern Flat", "Housing", 2000000, 3000000));
        items.add(new Item("Mini/Mobile Home", "Housing", 80000, 100000));
        items.add(new Item("Canopy", "Housing", 25000, 50000));
        items.add(new Item("Pool", "Leisure", 50000, 75000));
        items.add(new Item("Hot Tub", "Leisure", 10000, 15000));
        items.add(new Item("Bowling Alley", "Leisure", 400000, 450000));
        items.add(new Item("Karaoke Machine", "Leisure", 2000, 2500));
        items.add(new Item("Seaplane", "Leisure", 30000, 35000));
        items.add(new Item("Helicopter", "Leisure", 1500000, 1600000));
        items.add(new Item("Gaming Setup", "Leisure", 10000, 12000));
        items.add(new Item("Movie Theater", "Leisure", 10000, 15000));
        items.add(new Item("Beachside Villa", "Leisure", 2000, 3000));
        items.add(new Item("Amusement Park", "Leisure", 10000000, 15000000));
        items.add(new Item("Arcade", "Leisure", 4000, 4500));
 
        System.out.println("You won the lottery! Your prize included a private island, but it's completely deserted. Spend all your prize money upgrading the island!");
        System.out.println("You have $25 million to spend!");
        System.out.println("Keep in mind: after every 3 purchases, the market value of each item will automatically adjust.");
        System.out.println("Choose what you buy carefully! If you would like to rescind a purchase, you must pay a a fee 10% of what you paid.");
        System.out.println("");
        printInstructions();
        System.out.println("Enter your first command to get started!");
        inputCommand();
        

    }

    static void printInstructions() {
        System.out.println("To play this game, you may enter the following commands:");
        System.out.println("view instructions (to view game instructions)");
        System.out.println("view store (to view list of purchasable items)");
        System.out.println("view inventory (to view purchased items and remaining cash)");
        System.out.println("purchase (to buy something)");
        System.out.println("sell (to sell a purchased item)");
        System.out.println("quit (to exit the game)");
        System.out.println("");
        System.out.println("There's only so much space on your island, so you may only buy 4 food items, hire 10 employees, and buy 7 leisure facilities, at most.");
        System.out.println("You win if you successfully spend all of your money!");
    }
    
    static void printItems() {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.println(item.name);
        }
    }

    static void purchaseItem() {
        System.out.println("What item would you like to purchase?");
        System.out.print("Enter a an item name: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        // Check that input contains only letters and/or spaces
        if (!input.matches("[a-zA-Z ]+")) {

            System.out.println("Error: Invalid input. Please enter only letters and spaces.");
            purchaseItem();

        } else {

            if (input == "McDonald's") {
                printInstructions();
            } else if (input == "view store") {
                printItems();
            } else if (input == "view inventory") {
                //print purchased items
                //print remaining cash
            } else if (input == "purchase") {

            } else if (input == "sell") {

            } else if (input == "quit") {

            } else {
                System.out.println("Please enter a valid item");
                purchaseItem();
            }

        }
    }

    static void inputCommand() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Check that input contains only letters and/or spaces
        if (!input.matches("[a-zA-Z ]+")) {

            System.out.println("Error: Invalid input. Please enter only letters and spaces.");
            inputCommand();

        } else {

            if (input == "view instructions") {
                printInstructions();
            } else if (input == "view store") {
                printItems();
            } else if (input == "view inventory") {
                //print purchased items
                //print remaining cash
            } else if (input == "purchase") {

            } else if (input == "sell") {

            } else if (input == "quit") {

            } else {
                System.out.println("Please enter a valid command");
                inputCommand();
            }

        }
    }

}

class Player {
    int cash;
    static ArrayList<Item> inventory = new ArrayList<Item>();
}
