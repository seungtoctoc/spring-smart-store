package smartstore.products.productDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductRes {

  private String name;
  private String description;
  private int price;
  private int sellerId;
  private int categoryId;
}
