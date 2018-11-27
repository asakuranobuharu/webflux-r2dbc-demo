package com.example.demo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.example.demo.entity.Demo;

public interface DemoRepository extends ReactiveCrudRepository<Demo, Integer> {}
