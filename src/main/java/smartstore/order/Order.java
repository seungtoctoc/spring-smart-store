package smartstore.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

  private int id;
  private int userId;
  private int orderNumber;
  private int productId;

  @Override
  public String toString() {
    return "Order{" +
        "id=" + id +
        ", userId=" + userId +
        ", orderNumber=" + orderNumber +
        ", productId=" + productId +
        ", quantity=" + quantity +
        '}';
  }

  private int quantity;
}
