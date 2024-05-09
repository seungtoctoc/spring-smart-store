package smartstore.products;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Generated;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
  private ProductRepository productRepository;

  Product addProduct(Product product) {
    return productRepository.addProduct(product);
  }

  ArrayList<Product> getAllProducts() {
    return productRepository.getAllProducts();
  }

  Product findProductWithId(int id) {
    return productRepository.findProductWithId(id);
  }
}
