package com.example.springboottest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboottest.domain.entity.Rule;
import com.example.springboottest.domain.repository.RuleRepository;

@Service
@Transactional
public class RuleService {
    @Autowired
    RuleRepository ruleRepository;

    public Rule save(Rule rule){
        return ruleRepository.save(rule);
    }
    public List<Rule> findAll(){
        return ruleRepository.findAll();
    }

    public Rule findById(Integer id){
        return ruleRepository.findById(id).get();
    }

    public Rule create(Rule rule){
        return ruleRepository.save(rule);
    }
    public Rule update(Rule rule){
        return ruleRepository.save(rule);
    }

    public void delete(Integer id){
        ruleRepository.deleteById(id);
    }
}
