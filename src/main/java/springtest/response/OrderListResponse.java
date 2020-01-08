package springtest.response;

import springtest.data.Order;

import java.util.List;

public class OrderListResponse extends BaseResponse {
    private final List<Order> orders;

    public OrderListResponse(String status, Integer code, List<Order> orders) {
        super(status, code);
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

}
