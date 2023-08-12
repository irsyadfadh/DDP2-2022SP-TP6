import java.util.List;

public interface CanShop {
    void addToCart(Product product, int quantity);
    void checkout();
    List<OrderItem> getOrderItemsInCart(); // Tambahkan metode ini

}
