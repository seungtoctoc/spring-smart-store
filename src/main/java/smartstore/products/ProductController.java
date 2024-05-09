package smartstore.products;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    return new ResponseEntity<>(HttpStatus.CREATED);
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

  // paging 구현 필요
  @GetMapping("/products")
  public ResponseEntity<ArrayList<Product>> findProducts(
      @RequestParam(value="categoryId", required = false) Integer categoryId,
      @RequestParam(value="limit") Integer limit,
      @RequestParam(value="currentPage") Integer currentPage

      ) {

    if (limit == null || currentPage == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    if (categoryId == null) {
      ArrayList<Product> allProducts =  productService.findAllProduct(limit, currentPage);

      if (allProducts == null) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
      return new ResponseEntity<ArrayList<Product>>(allProducts, HttpStatus.OK);
    }

    if (!Validator.isNumber(categoryId)) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    ArrayList<Product> filteredProducts = productService.findProductWithCategory(categoryId, limit, currentPage);

    if (filteredProducts == null) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity<ArrayList<Product>>(filteredProducts, HttpStatus.OK);
  }
}
