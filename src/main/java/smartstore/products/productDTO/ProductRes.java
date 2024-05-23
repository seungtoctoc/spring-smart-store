package smartstore.products.productDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductRes {

  private int id;
  private String name;
  private String desc;
  private int price;
  private int sellerId;
  private int categoryId;
}
