package com.example.springboottest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboottest.domain.entity.Rule;
import com.example.springboottest.service.RuleService;

@RestController
@RequestMapping("/rule")
public class RuleController {
    @Autowired
    RuleService ruleService;
    // 一覧表示
    @RequestMapping(value="/selectall", method=RequestMethod.GET)
    public List<Rule> ruleSelectAll() {
        return ruleService.findAll();
    }
}
