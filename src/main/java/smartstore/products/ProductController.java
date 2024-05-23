package smartstore.products;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import smartstore.products.productDTO.FindProductsReq;
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

//  @PutMapping("/products/{id}")
//  public ResponseEntity<Product> updateProduct(
//      @PathVariable(value = "id") int id,
//      @RequestBody Product product
//  ) {
//    // validate
//    if (!Validator.isNumber(id)) {
//      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//    if (findProductWithId(id) == null) {
//      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//
//    // update product
//    Product updatedProduct = productService.updateProduct(id, product);
//
//    // return
//    return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);
//  }

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
      @Valid @RequestBody FindProductsReq findProductsReq
  ) {

    try {
      Page<Product> products = productService.findProducts(findProductsReq);

      return ApiUtils.success(products);
    } catch (IllegalStateException e) {
      return ApiUtils.error("not found", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

//  @PostMapping("/products/remove")
//  public ResponseEntity removeProducts(
//      @RequestBody Map<String, int[]> data
//  ) {
//    int[] productIds = data.get("productIds");
//
//    // validate
//    if (productIds.length == 0) {
//      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//
//    // Remove
//    for (int productId : productIds) {
//      // validate
//      if (findProductWithId(productId) == null) {
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//      }
//
//      // remove
//      productService.removeProducts(productId);
//    }
//
//    // validate
//    for (int productId : productIds) {
//      if (findProductWithId(productId) != null) {
//        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//      }
//    }
//
//    // return
//    return new ResponseEntity<>(HttpStatus.OK);
//  }
}