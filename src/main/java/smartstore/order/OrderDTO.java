package smartstore.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {

  private int userId;
  private int productId;
  private int quantity;

}
