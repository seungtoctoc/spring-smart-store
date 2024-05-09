package smartstore.products;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
  private ProductRepository productRepository;

  Product addProduct(Product product) {
    return productRepository.addProduct(product);
  }

  ArrayList<Product> findAllProduct(int limit, int currentPage) {
    return productRepository.findAllProduct(limit, currentPage);
  }

  ArrayList<Product> findProductWithCategory(int id, int limit, int currentPage) {
    return productRepository.findProductWithCategory(id, limit, currentPage);
  }

  Product findProductWithId(int id) {
    return productRepository.findProductWithId(id);
  }
}
