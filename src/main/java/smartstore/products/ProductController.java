package smartstore.products;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import smartstore.utility.Validator;

@RestController
@AllArgsConstructor
public class ProductController {
  ProductService productService;

  @PostMapping("/products")
  public void addProduct(@RequestBody Product product) {
    if (!Validator.isEnglish(product.getName())) {
      System.out.println("name should be english");
      return;
    }

    if (!Validator.isNumber(product.getPrice())) {
      System.out.println("price should be number");
      return;
    }

    if (product.getPrice() < 0) {
      System.out.println("price should be positive number");
      return;
    }

    productService.addProduct(product);
  }

  @GetMapping("/products")
  public ArrayList<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @GetMapping("/products/{id}")
  public Product findProductWithId(@PathVariable int id) {
    if (!Validator.isNumber(id)) {
      System.out.println("id should be number");
    }

    return productService.findProductWithId(id);
  }
}
