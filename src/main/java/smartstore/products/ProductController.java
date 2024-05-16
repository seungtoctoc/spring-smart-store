package smartstore.products;

import java.util.ArrayList;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import smartstore.utility.Validator;

@RestController
@AllArgsConstructor
public class ProductController {

  private ProductService productService;

  @PostMapping("/products")
  public ResponseEntity addProduct(@RequestBody Product product) {
    // validate
    if (!Validator.isEnglish(product.getName())) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    if (!Validator.isNumber(product.getPrice())) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    if (product.getPrice() < 0) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // add product
    Product savedProduct = productService.addProduct(product);

    // return
    if (savedProduct == null) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
  }

  @PutMapping("/products/{id}")
  public ResponseEntity<Product> updateProduct(
      @PathVariable(value = "id") int id,
      @RequestBody Product product
  ) {
    // validate
    if (!Validator.isNumber(id)) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    if (findProductWithId(id) == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // update product
    Product updatedProduct = productService.updateProduct(id, product);

    // return
    return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);
  }

  @GetMapping("/products/{id}")
  public ResponseEntity<Product> findProductWithId(@PathVariable(value = "id") int id) {
    // validate
    if (!Validator.isNumber(id)) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // find product with id
    Product resultProduct = productService.findProductWithId(id);

    // return
    if (resultProduct == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Product>(resultProduct, HttpStatus.OK);
  }

  @GetMapping("/products")
  public ResponseEntity<ArrayList<Product>> findProducts(
      @RequestParam(value = "categoryId", required = false) Integer categoryId,
      @RequestParam(value = "limit") Integer limit,
      @RequestParam(value = "currentPage") Integer currentPage
  ) {

    // validate
    if (limit == null || currentPage == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // Find all products
    if (categoryId == null) {
      // find
      ArrayList<Product> allProducts = productService.findProducts(limit, currentPage);

      // return
      if (allProducts == null) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
      return new ResponseEntity<ArrayList<Product>>(allProducts, HttpStatus.OK);
    }

    // Find products by category
    // validate
    if (!Validator.isNumber(categoryId)) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // find
    ArrayList<Product> filteredProducts = productService.findProducts(limit, currentPage,
        categoryId);

    // return
    if (filteredProducts == null) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<ArrayList<Product>>(filteredProducts, HttpStatus.OK);
  }

  @PostMapping("/products/remove")
  public ResponseEntity removeProducts(
      @RequestBody Map<String, int[]> data
  ) {
    int[] productIds = data.get("productIds");

    // validate
    if (productIds.length == 0) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // Remove
    for (int productId : productIds) {
      // validate
      if (findProductWithId(productId) == null) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }

      // remove
      productService.removeProducts(productId);
    }

    // validate
    for (int productId : productIds) {
      if (findProductWithId(productId) != null) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    // return
    return new ResponseEntity<>(HttpStatus.OK);
  }
}