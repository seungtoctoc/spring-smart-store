package smartstore.order;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

  Map<Integer, Order> orderTable = new HashMap<>();
  private int end = -1;

  Order addOrder(Order order) {
    order.setId(++end);
    orderTable.put(end, order);

    return orderTable.get(end);
  }
}
