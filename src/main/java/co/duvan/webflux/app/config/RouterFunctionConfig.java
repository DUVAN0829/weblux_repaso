package co.duvan.webflux.app.config;

import co.duvan.webflux.app.handlers.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterFunctionConfig {

    @Bean
    RouterFunction<ServerResponse> routes(ProductHandler handler) {

        return route(GET("/products"), handler::findAll)
                .andRoute(POST("/products"), handler::save)
                .andRoute(GET("/products/{id}"), handler::findById)
                .andRoute(PUT("/products/{id}"), handler::update)
                .andRoute(DELETE("/products/{id}"), handler::remove);

    }

}
