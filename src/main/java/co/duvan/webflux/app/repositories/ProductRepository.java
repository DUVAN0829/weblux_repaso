package co.duvan.webflux.app.repositories;

import co.duvan.webflux.app.models.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<Product, String> {
}
