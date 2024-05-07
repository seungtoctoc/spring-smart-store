package smartstore.products;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
  private int id;
  private String name;
  private String desc;
  private int price;
  private int sellerId;
  private int categoryId;
}
