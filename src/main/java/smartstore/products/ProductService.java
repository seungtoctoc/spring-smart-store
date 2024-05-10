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

  ArrayList<Product> findProducts(int limit, int currentPage) {
    return productRepository.findProducts(limit, currentPage);
  }

  ArrayList<Product> findProducts(int limit, int currentPage, int categoryId) {
    return productRepository.findProducts(limit, currentPage, categoryId);
  }

  Product findProductWithId(int id) {
    return productRepository.findProductWithId(id);
  }
}
