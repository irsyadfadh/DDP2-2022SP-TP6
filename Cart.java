import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<OrderItem> orderList;

    public Cart() {
        orderList = new ArrayList<>();
    }
    /*Method untuk menambahkan OrderItem ke dalam keranjang. */
    public void addOrderItem(OrderItem orderItem) {
        orderList.add(orderItem);
    }
    /*Method untuk menghitung total harga dari seluruh item dalam keranjang. */
    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderItem orderItem : orderList) {
            totalPrice += orderItem.getProduct().getPrice() * orderItem.getQuantity();
        }
        return totalPrice;
    }

    // Getter mendapatkan daftar item dalam keranjang.
    public List<OrderItem> getOrderList() {
        return orderList;
    }
}
