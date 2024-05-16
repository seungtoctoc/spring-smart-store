package smartstore.order;

import static smartstore.utility.ApiUtils.error;
import static smartstore.utility.ApiUtils.success;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import smartstore.utility.ApiUtils.ApiResult;

@Slf4j
@RestController
@AllArgsConstructor
public class OrderController {

  OrderService orderService;

  @PostMapping("/orders")
  public ApiResult<Order> addOrder(@RequestBody Order order) {
    log.info("order.toString()\n" + order.toString());

    Order savedOrder = orderService.addOrder(order);

    if (savedOrder == null) {
      return error("server_error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return success(savedOrder);
  }
}