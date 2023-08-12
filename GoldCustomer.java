public class GoldCustomer extends Customer {
    private static final double DISCOUNT_RATE = 0.85; // 85% discount

    public GoldCustomer(String name) {
        super(name);
    }

    @Override
    public double getDiscountRate() {
        return DISCOUNT_RATE;
    }
}
