package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Demo;
import com.example.demo.service.DemoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/demo")
public class DemoController {

  @Autowired DemoService demoService;

  @GetMapping("/{id}")
  private Mono<Demo> findById(@PathVariable("id") Integer id) {
    return demoService.findById(id);
  }

  @GetMapping
  private Flux<Demo> findAll() {
    return demoService.findAll();
  }
}
