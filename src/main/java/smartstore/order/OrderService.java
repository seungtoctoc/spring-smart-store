package smartstore.order;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

  OrderRepository orderRepository;

  Order addOrder(Order order) {
    return orderRepository.addOrder(order);
  }
}
