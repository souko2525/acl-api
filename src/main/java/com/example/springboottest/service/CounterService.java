package com.example.springboottest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.springboottest.domain.repository.CounterRepository;
import com.example.springboottest.domain.entity.Counter;

@Service
@Transactional
public class CounterService {

    @Autowired
    CounterRepository repository;

    public List<Counter> selectAll() {
        return repository.findAll();
    }

}
