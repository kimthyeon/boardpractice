package com.study.board.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY는 mysql, mariadb에서 사용 // sequence는 oracle // auto는 알아서 지정
    private Integer id;

    private String title;

    private String content;
    
    private String filename;

    private String filepath;
}
