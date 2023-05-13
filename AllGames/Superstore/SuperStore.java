package AllGames.Superstore;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

import AllGames.Games.Game1;

class Item {
        
    String name;
    int bottomPriceRange;
    int topPriceRange;
    int price;
    int Random;
    Random random = new Random();
    int count = 0;
    
    Item(String name, int bottomPriceRange, int topPriceRange) {
        this.name = name;
        this.bottomPriceRange = bottomPriceRange;
        this.topPriceRange = topPriceRange;
        this.price = random.nextInt((topPriceRange-bottomPriceRange) + 1) + bottomPriceRange;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public int getTopPriceRange() {
        return topPriceRange;
    }

    public int getBottomPriceRange() {
        return bottomPriceRange;
    }

    boolean isQuantityLimit() {
        if (count > 10) {
            return true;
        } else {
            return false;
        }
    }

}

public class SuperStore implements Game1 {

    /**
     * @param args
     * @throws Exception
     */

    static ArrayList<Item> items = new ArrayList<Item>(); //items in the store
    static ArrayList<Item> inventory = new ArrayList<Item>();
    static Player player = new Player();
    static int numPurchases = 0;
    public static boolean x = false;

    public static void main(String[] args) throws Exception {

        //store items
        items.add(new FoodItem("McDonalds", 1300000, 1500000));
        items.add(new FoodItem("Michelin Star Restaurant", 5000000, 10000000));
        items.add(new FoodItem("Boba Shop", 100000, 150000));
        items.add(new FoodItem("Steakhouse", 750000, 775000));
        items.add(new FoodItem("Gyro Truck", 80000, 100000));
        items.add(new FoodItem("KBBQ Restaurant", 300000, 400000));
        items.add(new FoodItem("Unlimited Grocery Delivery Service", 100000, 150000));
        items.add(new FoodItem("Cafe", 150000, 200000));
        items.add(new EmployeeItem("Chauffeur", 30000, 40000));
        items.add(new EmployeeItem("Housekeeper", 45000, 50000));
        items.add(new EmployeeItem("Private Chef", 90000, 100000));
        items.add(new EmployeeItem("Pilot", 90000, 100000));
        items.add(new EmployeeItem("Lifeguard", 30000, 45000));
        items.add(new EmployeeItem("Gardener", 35000, 40000));
        items.add(new HousingItem("Victorian Mansion", 600000, 800000));
        items.add(new HousingItem("Modern Flat", 2000000, 3000000));
        items.add(new HousingItem("Mobile Home", 80000, 100000));
        items.add(new HousingItem("Canopy", 25000, 50000));
        items.add(new LeisureItem("Pool", 50000, 75000));
        items.add(new LeisureItem("Hot Tub", 10000, 15000));
        items.add(new LeisureItem("Bowling Alley", 400000, 450000));
        items.add(new LeisureItem("Karaoke Machine", 2000, 2500));
        items.add(new LeisureItem("Seaplane", 30000, 35000));
        items.add(new LeisureItem("Helicopter", 1500000, 1600000));
        items.add(new LeisureItem("Gaming Setup", 10000, 12000));
        items.add(new LeisureItem("Movie Theater", 10000, 15000));
        items.add(new LeisureItem("Beachside Villa", 2000, 3000));
        items.add(new LeisureItem("Amusement Park", 10000000, 15000000));
        items.add(new LeisureItem("Arcade", 4000, 4500));
        
    }

    @Override
    public String getGameName() {
        String name = "Superstore";
        return name;
    }

    @Override
    public boolean isHighScore(int score, String highscore) {
        int num = Integer.parseInt(highscore);
        if (score > num) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void play() {
        //begins the game
        openingText();
        
        while (x == false) { //loops the game until the player wins or chooses to quit
            inputCommand();
            if (player.cash <= 100) { //checks if the player has less than or equal to $100 left, in which case they win
                System.out.println("Congratulations! You've spent all your money and win the game!");
                writeHighScore(null);
                replay(); //gives option to quit or replay
            }
            if (numPurchases == 3) {
                for (int i = 0; i < items.size(); i++) {
                    Random random = new Random();
                    items.get(i).price = random.nextInt((items.get(i).getTopPriceRange() - items.get(i).getBottomPriceRange()) + 1) + items.get(i).getBottomPriceRange();
                }
            }
        }

    }

    static void openingText() {
        System.out.println("You won the lottery! Your prize included a private island, but it's completely deserted. Spend all your prize money upgrading the island!");
        System.out.println("You have $25 million to spend!");
        System.out.println("Keep in mind: after every 2 purchases, the market value of each item will automatically adjust.");
        System.out.println("Choose what you buy carefully! If you would like to rescind a purchase, you must pay a a fee 10% of the current purchase price.");
        System.out.println("");
        System.out.println("To play this game, you may enter the following commands:");
        System.out.println("view instructions (to view game instructions)");
        System.out.println("view store (to view list of purchasable items)");
        System.out.println("view inventory (to view purchased items and remaining cash)");
        System.out.println("purchase (to buy something)");
        System.out.println("sell (to sell a purchased item)");
        System.out.println("quit (to exit the game)");
        System.out.println("");
        System.out.println("There's only so much space on your island, so you may only buy 5 food items, hire 10 employees, buy 3 houses, and buy 7 leisure facilities at most.");
        System.out.println("You win if you successfully spend (almost) all of your money! (Less than $100 remaining)");
    }

    static void replay() {
        System.out.println("Would you like to play again? (Yes or No)");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (!input.matches("[a-zA-Z ]+")) { //checks for letters and spaces in the input

            System.out.println("Error: Invalid input. Please enter only letters and spaces.");
            replay();

        } else {
            if (input.equals("Yes")) { //everything in this bracket resets the game
                System.out.println("You have restarted the game.");
                player.cash = 25000000;
                inventory.clear();
                for (int i = 0; i < items.size(); i++) {
                    Item item = items.get(i);
                    item.count = 0;
                }
                openingText();
            } else if (input.equals("No")) {
                System.out.println("Bye!");
                x = true;
            } else {
                System.out.println("Please enter Yes or No");
                replay();
            }
        }
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
        System.out.println("There's only so much space on your island, so you may only buy 4 food items, hire 10 employees, buy 3 houses, and buy 7 leisure facilities at most.");
        System.out.println("You win if you successfully spend all of your money!");
    }
    
    static void printItems() {
        for (int i = 0; i < items.size(); i++) { //loops through each store item and prints the price
            Item item = items.get(i);
            System.out.println(item.name + " - $" + item.price);
        }
    }

    static void purchaseItem() {
        System.out.println("What item would you like to purchase?");
        System.out.print("Enter an item name: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        boolean inList = false;

        // Check that input contains only letters and/or spaces
        if (!input.matches("[a-zA-Z ]+")) {

            System.out.println("Error: Invalid input. Please enter only letters and spaces.");
            purchaseItem();

        } else {

            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getName().equals(input)) { // if the input matches the name of an item in the store
                    inList = true;
                    items.get(i).isQuantityLimit();
                    if (items.get(i).getPrice() > player.cash) { // checks if the player can afford the item
                        System.out.println("Sorry, but you cannot afford this item.");
                    } else if (items.get(i).isQuantityLimit() == true) { // if the player reached the quantity limit
                        System.out.println("Sorry, you've already bought the maximum amount of this item.");
                    } else {
                        inventory.add(items.get(i)); // adds item to inventory
                        items.get(i).count++;
                        player.cash -= items.get(i).getPrice(); // deducts the price of the item from the player's cash
                        System.out.println("The purchase was successful. You now have " + items.get(i).getCount() + " " + items.get(i).getName() + "(s)");
                        System.out.println("You have $" + player.cash + " remaining.");
                        numPurchases++;
                    }
                    break;
                }
            }

            if (inList == false) { // if the input does not match a store item
                System.out.println("Please enter a valid item");
                purchaseItem();
            }

        }
    }

    static void sellItem() {
        System.out.println("What item would you like to sell?");
        System.out.print("Enter an item name: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        boolean inList = false;

        // Check that input contains only letters and/or spaces
        if (!input.matches("[a-zA-Z ]+")) {

            System.out.println("Error: Invalid input. Please enter only letters and spaces.");
            sellItem();

        } else {

            for (int i = 0; i < items.size(); i++) {
                double salePrice = items.get(i).getPrice() - (0.1 * items.get(i).getPrice());
                
                if (items.get(i).getName().equals(input)) { // if input matches the name of a store item
                    inList = true;
                    if (items.get(i).getCount() == 0) { // checks if the player owns it
                        System.out.println("Sorry, you don't have any of this item.");
                    } else {
                        // print sale price and confirm that the player wants to sell
                        System.out.println("Are you sure you want to sell a(n) " + items.get(i).getName() + " for " + salePrice + "? (Yes or No)");
                        input = sc.nextLine();

                        if (!input.matches("[a-zA-Z ]+")) { //checks input for letters and spaces

                            System.out.println("Error: Invalid input. Please enter only letters and spaces.");
                            sellItem();

                        } else {
                            if (input.equals("Yes")) { // if player confirms
                                inventory.remove(items.get(i));
                                items.get(i).count -= 1;
                                player.cash += salePrice;
                                System.out.println("The sale was successful. You now have " + items.get(i).getCount() + " " + items.get(i).getName() + "(s)");
                                System.out.println("You have $" + player.cash + " remaining.");
                            } else if (input.equals("No")) { // if player changes their mind
                                System.out.println(items.get(i).getName() + " has not been sold.");
                            } else { // invalid input
                                System.out.println("Please enter Yes or No");
                                sellItem();
                            }
                        }
                    }
                }
            }

            if (inList == false) { // input doesn't exist in store items
                System.out.println("Please enter a valid item");
                sellItem();
            }

        }
    }
    

    static void printInventory() {
        System.out.println("Purchased Items:");
            ArrayList<Item> alreadyPrinted = new ArrayList<Item>(); // keeps track of which items' names in the inventory have already been printed
            for (int i = 0; i < inventory.size(); i++) {
                Item item = inventory.get(i);
                if (alreadyPrinted.isEmpty() == true) { // if the name has already been printed it doesn't print it again
                    System.out.println(item.count + " " + item.name);
                    alreadyPrinted.add(item);
                } else { // prints if the name hasn't been printed already
                    Boolean listContains = false;
                    for (int u = 0; u < alreadyPrinted.size(); u++) {
                        Item item1 = alreadyPrinted.get(u);
                        if (item.getName() == item1.getName()) {
                            listContains = true;
                        }
                    }
                    if (listContains == false) {
                        System.out.println(item.count + " " + item.name);
                        alreadyPrinted.add(item);
                    }
                }
            }
            System.out.println("Money: $" + player.cash);
    }

    static void quit() {
        System.out.println("Are you sure you want to quit the game? (Yes or No)");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (!input.matches("[a-zA-Z ]+")) { // checks for letters and spaces

            System.out.println("Error: Invalid input. Please enter only letters and spaces.");
            quit();

        } else {
            if (input.equals("Yes")) {
                System.out.println("You have quit the game.");
                System.out.println("In all, you spent " + (25000000 - player.cash) + ".");
                replay(); // gives player option to replay
            } else if (input.equals("No")) {
                System.out.println("You have resumed the game.");
            } else {
                System.out.println("Please enter Yes or No");
                quit();
            }
        }
    }

    static void inputCommand() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a command: ");
        String input = sc.nextLine();

        // Check that input contains only letters and/or spaces
        if (!input.matches("[a-zA-Z ]+")) {

            System.out.println("Error: Invalid input. Please enter only letters and spaces.");
            inputCommand();

        } else {

            if (input.equals("view instructions")) {
                printInstructions();
            } else if (input.equals("view store")) {
                printItems();
            } else if (input.equals("view inventory")) {
                printInventory();
            } else if (input.equals("purchase")) {
                purchaseItem();
            } else if (input.equals("sell")) {
                sellItem();
            } else if (input.equals("quit")) {
                quit();
            } else {
                System.out.println("Please enter a valid command");
                inputCommand();
            }

        }
    }
    

    @Override
    public int getScore() {
        return player.cash;
    }

    @Override
    public void writeHighScore(File f) {
    }
}

class Player {
    int cash = 25000000;
    static ArrayList<Item> inventory = new ArrayList<Item>();
}
