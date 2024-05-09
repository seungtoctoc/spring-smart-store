package smartstore.products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
  private Map<Integer, Product> productTable = new HashMap<>();
  private int id = 0;

  Product addProduct(Product product) {
    product.setId(id);
    productTable.put(product.getId(), product);

    return productTable.get(id++);
  }

  ArrayList<Product> getAllProducts() {
    return new ArrayList<>(productTable.values());
  }

  ArrayList<Product> findProductWithCategory(int categoryId) {
    ArrayList<Product> filteredProducts = new ArrayList<>();

    for (Product product : productTable.values()) {
      if (product.getCategoryId() == categoryId) {
        filteredProducts.add(product);
      }
    }

    return filteredProducts;
  }

  Product findProductWithId(int id) {
    return productTable.get(id);
  }
}
