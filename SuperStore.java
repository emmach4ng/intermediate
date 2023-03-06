import java.util.ArrayList;

class Item {
    
    String name;
    String category;
    int bottomPriceRange;
    int topPriceRange;
    int salePrice;

    Item(String name, String category, int bottomPriceRange, int topPriceRange) {
        this.name = name;
        this.category = category;
        this.bottomPriceRange = bottomPriceRange;
        this.topPriceRange = topPriceRange;
    }

    public void addValues(String[] names, String[] categories, int[] bottomPriceRanges, int[] topPriceRanges) {    
 
        ArrayList<Item> store = new ArrayList<Item>();
        
        for (int i = 0; i < 29; i++) {
            store.add(new Item(names[i], categories[i], bottomPriceRanges[i], topPriceRanges[i]));
        }

    }

}

public class IslandSuperstore {

    public void main(String[] args) throws Exception {

        String[] names = { "McDonald's", "Michelin Star Restaurant", "Boba Shop", "Steakhouse", "Gyro Truck", "KBBQ Restaurant",
                            "Unlimited Grocery Delivery Service", "Café", "Chauffeur", "Housekeeper", "Private Chef"};
        String[] categories
            = { "Food", "Employees", "Housing", "Leisure" };
        int[] bottomPriceRanges = { };
        int[] topPriceRanges = { };
 
        //store.addValues(names, categories, bottomPriceRanges, topPriceRanges);

        //for (int i = 0; i < 29; i++) {
        //    System.out.println(store[i]);
        //}
        
        System.out.println("You won the lottery! Your prize included a private island, but it's completely deserted. Spend all your prize money upgrading the island!");
        System.out.println("You have $25 million to spend!");
        System.out.println("Keep in mind: after every 3 purchases, the market value of each item will automatically adjust.");
        System.out.println("Choose what you buy carefully! After you purchase an item, you must pay a fee to rescind your purchase.");

    }

}

class Player {

}
