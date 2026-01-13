package co.duvan.webflux.app.services;

import co.duvan.webflux.app.models.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    Mono<Product> save(Product product);

    Mono<Product> findById(String id);

    Flux<Product> findAll();

    Mono<Void> deleteById(String id);

}
