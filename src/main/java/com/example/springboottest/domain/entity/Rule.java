package com.example.springboottest.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "rule")
@NoArgsConstructor
@AllArgsConstructor
public class Rule {


    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String src;

    @Column(nullable = false)
    private String dst;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private Integer device_id;
}
