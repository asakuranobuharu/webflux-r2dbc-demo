package com.example.demo.service;

import com.example.demo.entity.Demo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DemoService {
  Mono<Demo> findById(Integer id);

  Flux<Demo> findAll();
}
