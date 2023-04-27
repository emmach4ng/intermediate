public class HousingItem extends Item {
    
    HousingItem(String name, int bottomPriceRange, int topPriceRange) {
        super(name, bottomPriceRange, topPriceRange);
    }

    @Override
    boolean isQuantityLimit() {
        if (count >= 3) {
            return true;
        } else {
            return false;
        }
    }

}
