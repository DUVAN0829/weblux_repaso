package co.duvan.webflux.app.services;

import co.duvan.webflux.app.models.Category;
import co.duvan.webflux.app.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoryServiceImpl implements CategoryService {

    //* Vars
    private final CategoryRepository repository;

    //* Constructor
    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    //* Methods
    @Override
    public Mono<Category> save(Category product) {
        return repository.save(product);
    }

    @Override
    public Mono<Category> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Flux<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }

}
