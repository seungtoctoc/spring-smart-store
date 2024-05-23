package smartstore.products;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import smartstore.products.productDTO.ProductReq;
import smartstore.products.productDTO.ProductRes;
import smartstore.utility.ApiUtils;

@RestController
@AllArgsConstructor
public class ProductController {

  private ProductService productService;

  @PostMapping("/products")
  public ApiUtils.ApiResult<Object> addProduct(@RequestBody ProductReq productReq) {
    ProductRes productRes = productService.saveProduct(productReq);

    if (productRes == null) {
      return ApiUtils.error("server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return ApiUtils.success(productRes);
  }

  @GetMapping("/products/{id}")
  public ApiUtils.ApiResult<Object> findProductWithId(
      @PathVariable("id") int id) {
    {
      try {
        ProductRes productRes = productService.findProductWithId(id);

        if (productRes == null) {
          return ApiUtils.error("server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ApiUtils.success(productRes);
      } catch (IllegalStateException e) {
        return ApiUtils.error("not found", HttpStatus.NOT_FOUND);
      }
    }
  }

  @GetMapping("/products")
  public ApiUtils.ApiResult<Object> findProducts(
      @RequestParam int current,
      @RequestParam int limit
  ) {

    try {
      Page<Product> products = productService.findProducts(current, limit);

      return ApiUtils.success(products);
    } catch (IllegalStateException e) {
      return ApiUtils.error("not found", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}