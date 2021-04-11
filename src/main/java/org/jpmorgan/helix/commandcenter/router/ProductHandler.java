package org.jpmorgan.helix.commandcenter.router;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Component
public class ProductHandler {


    public Mono<ServerResponse> getAllProducts(ServerRequest serverRequest){

        //Arrays val = Arrays.asList("one", "two", "three");

        Mono<String> missing = Mono.just("hello from reactor");
        Flux<String> fewWords = Flux.just("Hello", "World");

        //fewWords.

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(missing, String.class);
    }

}
