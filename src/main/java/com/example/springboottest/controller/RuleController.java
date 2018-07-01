package com.example.springboottest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.springboottest.domain.entity.Rule;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @RequestMapping(method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Rule createRule(@Validated @RequestBody Rule rule) {
        return ruleService.create(rule);
    }

    @RequestMapping(method=RequestMethod.PUT, value="{id}")
    public Rule updateRule(@PathVariable("id") Integer id, @RequestBody Rule rule) {
        rule.setId(id);
        return ruleService.update(rule);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="{id}")
    public void deleteRule(@PathVariable("id") Integer id) {
        ruleService.delete(id);
    }
}
