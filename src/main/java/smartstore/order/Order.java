package smartstore.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import smartstore.products.Product;

@Getter
@Setter
@AllArgsConstructor
public class Order {

  private int id;
  //  private int userId;
  // ddd 스러운 설계... (sql식이었으면 productId)
  private Product product;
  private int quantity;
}
