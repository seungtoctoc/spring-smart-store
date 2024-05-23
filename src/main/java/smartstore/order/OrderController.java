package smartstore.order;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class OrderController {

  OrderService orderService;

  @PostMapping("/orders")
  public void createOrder(@RequestBody OrderDTO orderDTO) {
//    Order savedOrder = orderService.createOrder(orderDTO);
//
//    if (savedOrder == null) {
//      return ApiUtils.error("server error", HttpStatus.BAD_REQUEST);
//    }
//
//    return ApiUtils.success(savedOrder);
  }
}
