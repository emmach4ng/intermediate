package AllGames.Superstore;

public class EmployeeItem extends Item {
    
    EmployeeItem(String name, int bottomPriceRange, int topPriceRange) {
        super(name, bottomPriceRange, topPriceRange);
    }

    @Override
    boolean isQuantityLimit() {
        if (count >= 10) {
            return true;
        } else {
            return false;
        }
    }

}
