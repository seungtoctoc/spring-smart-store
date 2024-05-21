package smartstore.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import smartstore.products.Product;

@Getter
@Setter
@RequiredArgsConstructor
public class Order {

  private int id;
  // private int userId;
  // DDD(도메인 주도 설계)스러운 설계... (sql식이었으면 productId)
  private final Product product;
  private final int quantity;
}
