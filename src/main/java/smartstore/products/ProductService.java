package smartstore.products;

import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import smartstore.products.productDTO.ProductReq;
import smartstore.products.productDTO.ProductRes;

@Service
@AllArgsConstructor
public class ProductService {

  private ProductJPARepository productJPARepository;

  @Transactional
  ProductRes saveProduct(ProductReq productReq) {
    Product productToSave = productReq.makeProduct();
    Product savedProduct = productJPARepository.save(productToSave);

    return savedProduct.makeProductRes();
  }

  Page<Product> findProducts(int current, int limit) {
    PageRequest pageRequest = PageRequest.of(current, limit);
    Page<Product> products = productJPARepository.findAll(pageRequest);

    if (products.getSize() == 0) {
      throw new IllegalStateException();
    }

    return products;
  }

  ArrayList<Product> findProducts(int limit, int currentPage, int categoryId) {
    return null;
  }

  ProductRes findProductWithId(int id) {
    Optional<Product> foundProduct = productJPARepository.findById(id);

    if (foundProduct.isEmpty()) {
      throw new IllegalStateException();
    }

    return foundProduct.get().makeProductRes();
  }
}
