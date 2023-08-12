import java.util.ArrayList;
import java.util.List;

public class Customer implements CanShop {
    private String name;
    private Cart cart;
    private List<Order> orderHistory;

    public Customer(String name) {
        this.name = name;
        this.cart = new Cart();
        this.orderHistory = new ArrayList<>();
    }

    public void addToCart(Product product, int quantity) {
        OrderItem orderItem = new OrderItem(product, quantity);
        cart.addOrderItem(orderItem);
    }

    public void checkout() {
        if (!cart.getOrderList().isEmpty()) {
            Order order = new Order(cart);
            orderHistory.add(order);
            cart = new Cart();
        } else {
            System.out.println("Keranjang Anda kosong");
        }
    }
    public double getDiscountRate() {
        return 0.0; // Tidak ada diskon default
    }
}
