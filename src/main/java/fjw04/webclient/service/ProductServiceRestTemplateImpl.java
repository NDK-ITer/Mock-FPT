package fjw04.webclient.service;

import fjw04.webclient.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of the ProductService interface using RestTemplate.
 * 
 * <p>RestTemplate is a synchronous client to perform HTTP requests. It is simple to use and
 * suitable for applications where blocking operations are acceptable. It provides a higher-level
 * abstraction over HTTP client libraries, making it easier to interact with RESTful services.</p>
 * 
 * <p>Benefits of using RestTemplate:
 * <ul>
 *   <li>Easy to use and integrate with Spring applications.</li>
 *   <li>Supports various HTTP methods and provides a convenient way to handle responses.</li>
 *   <li>Well-suited for applications where blocking I/O is not a concern.</li>
 * </ul>
 * </p>
 */
@Service("restTemplateService")
public class ProductServiceRestTemplateImpl implements ProductService {

    private final RestTemplate restTemplate;
    private static final String PRODUCT_API_URL = "https://fakestoreapi.com/products";

    public ProductServiceRestTemplateImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Fetches all products from the API.
     * 
     * <p>Uses RestTemplate's getForObject method to perform a GET request to the API URL.
     * The response is deserialized into an array of Product objects, which is then converted
     * to a List.</p>
     * 
     * @return a list of all products
     */
    @Override
    public List<Product> getAllProducts() {
        Product[] productsArray = restTemplate.getForObject(PRODUCT_API_URL, Product[].class);
        return Arrays.asList(productsArray);
    }

    /**
     * Fetches a product by its ID from the API.
     * 
     * <p>Uses RestTemplate's getForObject method to perform a GET request to the API URL
     * with the specified product ID. The response is deserialized into a Product object.</p>
     * 
     * @param id the ID of the product to fetch
     * @return the product with the specified ID
     */
    @Override
    public Product getProductById(Long id) {
        return restTemplate.getForObject(PRODUCT_API_URL + "/" + id, Product.class);
    }

    /**
     * Creates a new product using the API.
     * 
     * <p>Uses RestTemplate's postForObject method to perform a POST request to the API URL
     * with the product data. The response is deserialized into a Product object.</p>
     * 
     * @param product the product to create
     * @return the created product
     */
    @Override
    public Product createProduct(Product product) {
        return restTemplate.postForObject(PRODUCT_API_URL, product, Product.class);
    }

    /**
     * Updates an existing product using the API.
     * 
     * <p>Uses RestTemplate's put method to perform a PUT request to the API URL with the
     * specified product ID and updated product data. No response is expected.</p>
     * 
     * @param id the ID of the product to update
     * @param product the updated product data
     */
    @Override
    public void updateProduct(Long id, Product product) {
        restTemplate.put(PRODUCT_API_URL + "/" + id, product);
    }

    /**
     * Deletes a product by its ID using the API.
     * 
     * <p>Uses RestTemplate's delete method to perform a DELETE request to the API URL
     * with the specified product ID. No response is expected.</p>
     * 
     * @param id the ID of the product to delete
     */
    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete(PRODUCT_API_URL + "/" + id);
    }
}