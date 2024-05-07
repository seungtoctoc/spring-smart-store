package smartstore.products;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
      System.out.println("name을 확인하세요");
      return;
    }

    if(!Validator.isNumber(product.getPrice()) || product.getPrice() < 0) {
      System.out.println("price를 확인하세요");
      return;
    }

    productService.addProduct(product);
  }

  @GetMapping("/products")
  public ArrayList<Product> getAllProducts() {
    return productService.getAllProducts();
  }
}
