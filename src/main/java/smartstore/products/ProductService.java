package smartstore.products;

import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import smartstore.products.productDTO.FindProductReq;
import smartstore.products.productDTO.FindProductsReq;
import smartstore.products.productDTO.ProductReq;
import smartstore.products.productDTO.ProductRes;

@Service
@AllArgsConstructor
public class ProductService {

  private ProductJPARepository productJPARepository;

  @Transactional
  ProductRes saveProduct(ProductReq productReq) {
    Product savedProduct = productJPARepository.save(productReq.makeProduct());

    return savedProduct.makeProductRes();
  }

  Product updateProduct(int id, Product product) {
    return null;
  }

  Page<Product> findProducts(FindProductsReq findProductsReq) {
    PageRequest pageRequest = PageRequest.of(findProductsReq.getCurrent(),
        findProductsReq.getLimit());
    Page<Product> products = productJPARepository.findAll(pageRequest);

    if (products.getSize() == 0) {
      throw new IllegalStateException();
    }

    return products;
  }

  ArrayList<Product> findProducts(int limit, int currentPage, int categoryId) {
    return null;
  }

  ProductRes findProductWithId(FindProductReq findProductReq) {
    Optional<Product> foundProduct = productJPARepository.findById(findProductReq.getId());

    if (foundProduct.isEmpty()) {
      throw new IllegalStateException();
    }

    return foundProduct.get().makeProductRes();
  }

  void removeProducts(int productId) {

  }
}
