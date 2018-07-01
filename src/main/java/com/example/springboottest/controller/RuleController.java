package com.example.springboottest.controller;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/V1/rule")
public class RuleController {
    private static final Logger logger = LoggerFactory.getLogger(RuleController.class);
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
        //現在の値を取得
        Rule current = ruleService.findById(id);
        //拡張For分でClassのフィールドを取得
        for (Field field : rule.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if(field.get(rule)!=null) {
                    PropertyDescriptor ruleProp = new PropertyDescriptor(field.getName(), rule.getClass());
                    Method ruleSetter = ruleProp.getWriteMethod();
                    ruleSetter.invoke(current, field.get(rule));
                    field.setAccessible(false);
                }
            } catch (IllegalAccessException e) {
                //e.printStackTrace();
            } catch (IntrospectionException e) {
                //e.printStackTrace();
            } catch (InvocationTargetException e) {
                //e.printStackTrace();
            }
        }
        return ruleService.update(current);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="{id}")
    public void deleteRule(@PathVariable("id") Integer id) {
        ruleService.delete(id);
    }
}
