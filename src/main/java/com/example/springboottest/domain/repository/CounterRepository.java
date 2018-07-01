package com.example.springboottest.domain.repository;
import com.example.springboottest.domain.entity.Counter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterRepository extends JpaRepository<Counter, Integer> {
}
