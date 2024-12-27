package fjw04.webclient.service;

import fjw04.webclient.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;

/**
 * Implementation of the ProductService interface using WebClient.
 * 
 * <p>WebClient is a non-blocking, reactive client to perform HTTP requests. It is part of the
 * Spring WebFlux module and is suitable for applications that require high concurrency and
 * scalability. WebClient provides a flexible and efficient way to interact with RESTful services
 * in a non-blocking manner.</p>
 * 
 * <p>Benefits of using WebClient:
 * <ul>
 *   <li>Non-blocking and reactive, suitable for high-concurrency applications.</li>
 *   <li>Supports a fluent API for building requests and handling responses.</li>
 *   <li>Integrates well with reactive programming paradigms and libraries.</li>
 * </ul>
 * </p>
 */
@Service("webClientService")
public class ProductServiceWebClientImpl implements ProductService {

    private final WebClient webClient;

    public ProductServiceWebClientImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://fakestoreapi.com").build();
    }

    /**
     * Fetches all products from the API.
     * 
     * <p>Uses WebClient's get method to perform a GET request to the API endpoint.
     * The response is processed as a Flux of Product objects, which is collected into a List
     * using collectList and blocked to wait for the result.</p>
     * 
     * @return a list of all products
     */
    @Override
    public List<Product> getAllProducts() {
        return webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(Product.class)
                .doOnEach(System.out::println)
                .doOnError(e -> System.err.println("Error fetching products: " + e.getMessage()))
                .collectList()
                .block();
    }

    /**
     * Fetches a product by its ID from the API.
     * 
     * <p>Uses WebClient's get method to perform a GET request to the API endpoint
     * with the specified product ID. The response is processed as a Mono of Product
     * and blocked to wait for the result.</p>
     * 
     * @param id the ID of the product to fetch
     * @return the product with the specified ID
     */
    @Override
    public Product getProductById(Long id) {
        return webClient.get()
                .uri("/products/{id}", id)
                .retrieve()
                .bodyToMono(Product.class)
                .block();
    }

    /**
     * Creates a new product using the API.
     * 
     * <p>Uses WebClient's post method to perform a POST request to the API endpoint
     * with the product data. The response is processed as a Mono of Product and blocked
     * to wait for the result.</p>
     * 
     * @param product the product to create
     * @return the created product
     */
    @Override
    public Product createProduct(Product product) {
        return webClient.post()
                .uri("/products")
                .bodyValue(product)
                .retrieve()
                .bodyToMono(Product.class)
                .block();
    }

    /**
     * Updates an existing product using the API.
     * 
     * <p>Uses WebClient's put method to perform a PUT request to the API endpoint
     * with the specified product ID and updated product data. The response is processed
     * as a Mono of Void and blocked to wait for completion.</p>
     * 
     * @param id the ID of the product to update
     * @param product the updated product data
     */
    @Override
    public void updateProduct(Long id, Product product) {
        webClient.put()
                .uri("/products/{id}", id)
                .bodyValue(product)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    /**
     * Deletes a product by its ID using the API.
     * 
     * <p>Uses WebClient's delete method to perform a DELETE request to the API endpoint
     * with the specified product ID. The response is processed as a Mono of Void and blocked
     * to wait for completion.</p>
     * 
     * @param id the ID of the product to delete
     */
    @Override
    public void deleteProduct(Long id) {
        webClient.delete()
                .uri("/products/{id}", id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}