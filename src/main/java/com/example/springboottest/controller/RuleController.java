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
@RequestMapping("api/V1/rule")
public class RuleController {

    @Autowired
    RuleService ruleService;

    // 一覧表示
    @RequestMapping(value="/", method=RequestMethod.GET)
    public List<Rule> getRuleAll() {
        return ruleService.findAll();
    }

    @RequestMapping(method=RequestMethod.GET, value="{id}")
    public Rule getRule(@PathVariable("id") Integer id) {
        return ruleService.findById(id);
    }
}
