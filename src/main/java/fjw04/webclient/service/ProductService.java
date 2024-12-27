package fjw04.webclient.service;

import fjw04.webclient.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product createProduct(Product product);

    void updateProduct(Long id, Product product);

    void deleteProduct(Long id);
}
