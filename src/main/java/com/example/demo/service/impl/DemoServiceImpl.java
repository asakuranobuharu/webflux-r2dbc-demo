package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Demo;
import com.example.demo.repository.DemoRepository;
import com.example.demo.service.DemoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DemoServiceImpl implements DemoService {

  @Autowired DemoRepository demoRepository;

  @Override
  public Mono<Demo> findById(Integer id) {
    return demoRepository.findById(id);
  }

  @Override
  public Flux<Demo> findAll() {
    return demoRepository.findAll();
  }
}
