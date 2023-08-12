import java.time.LocalDate;
import java.util.List;

public class Order {
    private Cart cart;
    private double discountRate;
    private LocalDate orderDate;
    private double totalPrice;

    public Order(Cart cart) {
        this.cart = cart;
        this.discountRate = calculateDiscountRate();
        this.orderDate = LocalDate.now();
        this.totalPrice = calculateTotalPrice();
        decreaseStockAllItem();
    }

    public double getFinalPrice() {
        return totalPrice * (1 - discountRate);
    }

    private double calculateDiscountRate() {
        // You might use cart.getOrderList() to access the items in the cart
        // You can return the discount rate as a percentage (e.g., 0.15 for 15% discount)
        return 0.0; // Placeholder, replace with actual calculation
    }

    private double calculateTotalPrice() {
        return cart.getTotalPrice();
    }

    private void decreaseStockAllItem() {
        List<OrderItem> orderItems = cart.getOrderList();
        for (OrderItem orderItem : orderItems) {
            orderItem.getProduct().decreaseStock(orderItem.getQuantity());
        }
    }
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tanggal Checkout        : ").append(orderDate).append("\n");
        stringBuilder.append("Total Harga     : ").append(getFinalPrice()).append("\n");
        stringBuilder.append("Daftar Pembelian        :\n");
        
        for (OrderItem orderItem : cart.getOrderList()) {
            stringBuilder.append(orderItem.toString()).append("\n");
        }
        
        return stringBuilder.toString();
    }

    // Other methods as needed
}
