public class LeisureItem extends Item {
    
    LeisureItem(String name, int bottomPriceRange, int topPriceRange) {
        super(name, bottomPriceRange, topPriceRange);
    }

    @Override
    boolean isQuantityLimit() {
        if (count > 7) {
            return true;
        } else {
            return false;
        }
    }
    
}
