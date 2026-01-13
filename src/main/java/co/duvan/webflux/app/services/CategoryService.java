package co.duvan.webflux.app.services;

import co.duvan.webflux.app.models.Category;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryService {

    Mono<Category> save(Category product);

    Mono<Category> findById(String id);

    Flux<Category> findAll();

    Mono<Void> deleteById(String id);

}
