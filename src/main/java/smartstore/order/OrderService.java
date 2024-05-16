package smartstore.order;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import smartstore.products.Product;
import smartstore.products.ProductService;

@Service
@AllArgsConstructor
public class OrderService {

  OrderRepository orderRepository;
  ProductService productService;

  Order createOrder(OrderDTO orderDTO) {
    Product productToOrder = productService.findProductWithId(orderDTO.getProductId());
    Order orderToSave = new Order(-1, productToOrder, orderDTO.getQuantity());

    return orderRepository.createOrder(orderToSave);
  }
}
