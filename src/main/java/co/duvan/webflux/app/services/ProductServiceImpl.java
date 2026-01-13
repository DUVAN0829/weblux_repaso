package co.duvan.webflux.app.services;

import co.duvan.webflux.app.models.Product;
import co.duvan.webflux.app.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

    //* Vars
    private final ProductRepository repository;

    //* Constructor
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    //* Methods
    @Override
    public Mono<Product> save(Product product) {
        return repository.save(product);
    }

    @Override
    public Mono<Product> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Flux<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }

}














