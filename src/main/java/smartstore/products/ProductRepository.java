package smartstore.products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
  private Map<Integer, Product> productTable = new HashMap<>();
  private int endId = 0;

  Product addProduct(Product product) {
    product.setId(endId);
    productTable.put(product.getId(), product);

    return productTable.get(endId++);
  }

  ResponseEntity<Product> updateProduct(int id, Product product) {
    if (id >= productTable.size()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    Product prevProduct = productTable.get(id);
    Product updatedProduct = product;
    updatedProduct.setId(prevProduct.getId());

    productTable.replace(id, updatedProduct);

    return new ResponseEntity<Product>(productTable.get(id), HttpStatus.OK);
  }

  ArrayList<Product> findProducts(int limit, int currentPage) {
    ArrayList<Product> allProducts = new ArrayList<>(productTable.values());
    return fitArrayList(allProducts, limit, currentPage);
  }

  ArrayList<Product> findProducts(int limit, int currentPage, int categoryId) {
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
