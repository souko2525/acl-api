package com.example.springboottest.domain.repository;

import com.example.springboottest.domain.entity.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RuleRepository extends JpaRepository<Rule, Integer> {
}
