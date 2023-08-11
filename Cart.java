import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<OrderItem> orderList;

    public Cart() {
        orderList = new ArrayList<>();
    }

    public void addOrderItem(OrderItem orderItem) {
        orderList.add(orderItem);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderItem orderItem : orderList) {
            totalPrice += orderItem.getProduct().getPrice() * orderItem.getQuantity();
        }
        return totalPrice;
    }

    // Getter for orderList if needed
    public List<OrderItem> getOrderList() {
        return orderList;
    }
}
