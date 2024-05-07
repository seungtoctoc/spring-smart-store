package smartstore.products;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
  private String name;
  private String desc;
  private int price;
  private int sellerId;
}
