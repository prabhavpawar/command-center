package org.jpmorgan.helix.commandcenter.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class ProductRouter {

    @Bean
    public RouterFunction<ServerResponse> productsRoute(ProductHandler productHandler){

        return RouterFunctions.
                route(GET("/api/hello").and(accept(MediaType.APPLICATION_JSON)),
                        productHandler::getAllProducts);
    }

}
