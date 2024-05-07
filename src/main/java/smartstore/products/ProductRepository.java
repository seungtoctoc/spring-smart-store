package smartstore.products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
  private Map<Integer, Product> productTable = new HashMap<>();
  private int id = 0;

  void addProduct(Product product) {
    productTable.put(id++, product);
  }

  ArrayList<Product> getAllProducts() {
    return new ArrayList<>(productTable.values());
  }
}
