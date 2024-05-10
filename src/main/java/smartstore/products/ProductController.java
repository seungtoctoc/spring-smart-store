package smartstore.products;

import java.lang.reflect.Array;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
  private static Logger logger = LoggerFactory.getLogger(ProductController.class);

  @PostMapping("/products")
  public ResponseEntity addProduct(@RequestBody Product product) {
    if (!Validator.isEnglish(product.getName())) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    if (!Validator.isNumber(product.getPrice())) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    if (product.getPrice() < 0) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    Product savedProduct = productService.addProduct(product);

    if (savedProduct == null) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
  }

  @PutMapping("/products/{id}")
  public ResponseEntity<Product> updateProduct(
      @PathVariable(value="id") int id,
      @RequestBody Product product
    ) {
    if (!Validator.isNumber(id)) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    ResponseEntity<Product> response = productService.updateProduct(id, product);

    if (response == null) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return response;
  }

  @GetMapping("/products/{id}")
  public ResponseEntity<Product> findProductWithId(@PathVariable(value="id") int id) {
    if (!Validator.isNumber(id)) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    Product resultProduct = productService.findProductWithId(id);

    if (resultProduct == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Product>(resultProduct, HttpStatus.OK);
  }

  @GetMapping("/products")
  public ResponseEntity<ArrayList<Product>> findProducts(
      @RequestParam(value="categoryId", required = false) Integer categoryId,
      @RequestParam(value="limit") Integer limit,
      @RequestParam(value="currentPage") Integer currentPage

      ) {

    // check parameters
    if (limit == null || currentPage == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // find all products
    if (categoryId == null) {
      ArrayList<Product> allProducts =  productService.findProducts(limit, currentPage);

      if (allProducts == null) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
      return new ResponseEntity<ArrayList<Product>>(allProducts, HttpStatus.OK);
    }

    // find products by category
    if (!Validator.isNumber(categoryId)) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    ArrayList<Product> filteredProducts = productService.findProducts(limit, currentPage, categoryId);

    // return
    if (filteredProducts == null) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity<ArrayList<Product>>(filteredProducts, HttpStatus.OK);
  }

  @PostMapping("/products/remove")
  public void removeProduct(
      @RequestBody int[] productIds
  ) {

    return new ResponseEntity<>(HttpStatus.OK);
  }
}


