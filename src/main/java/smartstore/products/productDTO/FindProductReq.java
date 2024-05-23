package smartstore.products.productDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class FindProductReq {

  @NotBlank(message = "id 똑바로 부탁드려요 고갱님")
  private int id;
}
