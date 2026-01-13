package co.duvan.webflux.app;

import co.duvan.webflux.app.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class WebfluxApplication implements CommandLineRunner {

    //* Vars
    private final ProductService service;
    private final ReactiveMongoTemplate template;

    //* Constructor
    public WebfluxApplication(ProductService service, ReactiveMongoTemplate template) {
        this.service = service;
        this.template = template;
    }

    public static void main(String[] args) {
        SpringApplication.run(WebfluxApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


    }

}
