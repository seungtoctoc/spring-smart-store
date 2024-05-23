package smartstore.products.productDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import smartstore.products.Product;

@Getter
public class ProductReq {

  @NotBlank(message = "이름은 필수!")
  private String name;

  @NotBlank(message = "설명은 필수!")
  private String description;

  @NotBlank(message = "가격은 필수!")
  private int price;

  @NotBlank(message = "판매자 id는 필수!")
  private int sellerId;

  @NotBlank(message = "카테고리 id는 필수!")
  private int categoryId;

  public Product makeProduct() {
    return new Product(0, name, description, price, sellerId, categoryId);
  }
}
