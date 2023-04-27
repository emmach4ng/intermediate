public class FoodItem extends Item {
    
    FoodItem(String name, int bottomPriceRange, int topPriceRange) {
        super(name, bottomPriceRange, topPriceRange);
    }

    @Override
    boolean isQuantityLimit() {
        if (count > 5) {
            return true;
        } else {
            return false;
        }
    }

}
