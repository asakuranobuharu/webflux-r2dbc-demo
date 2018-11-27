package com.example.demo;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class HelloRouter {
  @Bean
  public RouterFunction<ServerResponse> route(HelloHandler handler) {
    return RouterFunctions.route(
            GET("/hello").and(RequestPredicates.accept(APPLICATION_JSON)),
            handler::hello);
  }
}
