package smartstore.products;

import java.util.ArrayList;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import smartstore.products.productDTO.FindProductReq;
import smartstore.products.productDTO.ProductReq;
import smartstore.products.productDTO.ProductRes;

@Service
@AllArgsConstructor
public class ProductService {

  private ProductJPARepository productJPARepository;

  ProductRes saveProduct(ProductReq productReq) {
    Product savedProduct = productJPARepository.save(productReq.makeProduct());

    return savedProduct.makeProductRes();
  }

  Product updateProduct(int id, Product product) {
    return null;
  }

  ArrayList<Product> findProducts(int limit, int currentPage) {
    return null;
  }

  ArrayList<Product> findProducts(int limit, int currentPage, int categoryId) {
    return null;
  }

  ProductRes findProductWithId(FindProductReq findProductReq) {
    Optional<Product> foundProduct = productJPARepository.findById(findProductReq.getId());

    if (foundProduct.isEmpty()) {
      return null;
    }

    return foundProduct.get().makeProductRes();
  }

  void removeProducts(int productId) {

  }
}
