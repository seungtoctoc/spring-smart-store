package smartstore.products.productDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class FindProductsReq {

  @NotBlank(message = "current page 입력")
  private int current;

  @NotBlank(message = "limit 입력")
  private int limit;
}
