package co.duvan.webflux.app.handlers;

import co.duvan.webflux.app.models.Product;
import co.duvan.webflux.app.services.ProductService;
import com.mongodb.internal.connection.Server;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.LocalDateTime;

@Component
public class ProductHandler {

    //* Vars
    private final ProductService service;

    //* Constructor
    public ProductHandler(ProductService service) {
        this.service = service;
    }

    //* Handler Mehtods
    public Mono<ServerResponse> findAll(ServerRequest req) {

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(this.service.findAll());
    }

    public Mono<ServerResponse> findById(ServerRequest req) {

        String id = req.pathVariable("id");

        return this.service.findById(id).flatMap(product ->
                ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(product)
        ).switchIfEmpty(ServerResponse.notFound().build());

    }

    public Mono<ServerResponse> save(ServerRequest req) {

        Mono<Product> productMono = req.bodyToMono(Product.class);

        return productMono.flatMap(product -> {
            product.setCreateAt(LocalDateTime.now());
            return this.service.save(product);
        }).flatMap(productDb ->
                ServerResponse.created(URI.create("/products/".concat(productDb.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(productDb)
        );

    }

    public Mono<ServerResponse> update(ServerRequest req) {

        Mono<Product> productMono = req.bodyToMono(Product.class);
        String id = req.pathVariable("id");

        return productMono.flatMap(product -> this.service.findById(id))
                .zipWith(productMono, (db, re) -> {
                    db.setName(re.getName());
                    db.setPrice(re.getPrice());
                    db.setCategory(re.getCategory());
                    return db;
                }).flatMap(productUpdate -> ServerResponse.created(URI.create("/products/".concat(productUpdate.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(this.service.save(productUpdate))
                ).switchIfEmpty(ServerResponse.notFound().build());

    }

    public Mono<ServerResponse> remove (ServerRequest req) {

        String id = req.pathVariable("id");

        return this.service.findById(id)
                .flatMap(product -> ServerResponse.status(HttpStatus.NO_CONTENT).bodyValue(this.service.deleteById(id)))
                .switchIfEmpty(ServerResponse.notFound().build());

    }

}















