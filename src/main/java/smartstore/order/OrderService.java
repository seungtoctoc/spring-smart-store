package smartstore.order;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import smartstore.products.Product;

@Service
@AllArgsConstructor
public class OrderService {

  OrderRepository orderRepository;
  ProductRepository productRepository;

  Order createOrder(OrderDTO orderDTO) {
    Product productToOrder = productRepository.findProductWithId(orderDTO.getProductId());

    // DTO -> ENTITY (ORDER)
    Order orderToSave = new Order(productToOrder, orderDTO.getQuantity());

    return orderRepository.createOrder(orderToSave);
  }
}
