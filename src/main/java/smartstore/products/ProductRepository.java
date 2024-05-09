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

  ArrayList<Product> findAllProduct(int limit, int currentPage) {
    ArrayList<Product> allProducts = new ArrayList<>(productTable.values());
    return fitArrayList(allProducts, limit, currentPage);
  }

  ArrayList<Product> findProductWithCategory(int categoryId, int limit, int currentPage) {
    ArrayList<Product> filteredProducts = new ArrayList<>();

    for (Product product : productTable.values()) {
      if (product.getCategoryId() == categoryId) {
        filteredProducts.add(product);
      }
    }

    return fitArrayList(filteredProducts, limit, currentPage);
  }

  ArrayList<Product> fitArrayList(ArrayList<Product> products, int limit, int currentPage) {
    ArrayList<Product> fit = new ArrayList<Product>();

    for (int i = limit*(currentPage-1) ; i < limit * currentPage ; i++) {
      if (i >= products.size()) {
        break;
      }

      fit.add(products.get(i));
    }

    return fit;
  }

  Product findProductWithId(int id) {
    return productTable.get(id);
  }
}
