package smartstore.products;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import smartstore.products.productDTO.ProductRes;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

  @Id
  private Integer id;

  private String name;
  private String description;
  private int price;
  private int sellerId;
  private int categoryId;

  public ProductRes makeProductRes() {
    return new ProductRes(name, description, price, sellerId, categoryId);
  }
}
