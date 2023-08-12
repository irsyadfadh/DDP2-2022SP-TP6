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
    /*menghitung harga akhir pesanan setelah diberlakukan diskon. */
    public double getFinalPrice() {
        return totalPrice * (1 - discountRate);
    }
    /*menghitung tingkat diskon berdasarkan item dalam keranjang. */
    private double calculateDiscountRate() {

        return 0.0; 
    }
    /*menghitung total harga dari seluruh item dalam keranjang. */
    private double calculateTotalPrice() {
        return cart.getTotalPrice();
    }
    /*mengurangi stok semua item dalam keranjang setelah checkout. */
    private void decreaseStockAllItem() {
        List<OrderItem> orderItems = cart.getOrderList();
        for (OrderItem orderItem : orderItems) {
            orderItem.getProduct().decreaseStock(orderItem.getQuantity());
        }
    }
    /*menghasilkan representasi String dari pesanan. */
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
