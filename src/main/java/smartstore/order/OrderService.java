package smartstore.order;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import smartstore.products.Product;
import smartstore.products.ProductRepository;

@Service
@AllArgsConstructor
public class OrderService {

  OrderRepository orderRepository;
  ProductRepository productRepository;

  Order createOrder(OrderDTO orderDTO) {

    Product productToOrder = productRepository.findProductWithId(orderDTO.getProductId());
    Order orderToSave = new Order(-1, productToOrder, orderDTO.getQuantity());

    return orderRepository.createOrder(orderToSave);
  }
}
