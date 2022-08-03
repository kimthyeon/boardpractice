## 유튜브 "한코딩" -> [스프링부트] 게시판 무작정 따라하기

IDE(통합개발환경) : intellij 

개발 언어 : Java 11

프레임워크 : Spring Boot 2.7.2 

빌드 : Gradle 

DB(데이터베이스) : MariaDB 10.6.8 

DB 접근 기술 : JPA 

View 템플릿 : Thymeleaf

## 프로젝트 생성(start.spring.io)
* Project : Gradle Project
* Language : Java
* Spring Boot : 2.7.2

--Project Metadata--
* Group : com.study  
* Artifact : board  
* Name : board  
* Description : Demo project for Spring Boot  
* Package name : com.study.board  
* Packaging : Jar
* Java : 11
  

--Dependencies--
* Spring Web
* Spring Data JPA
* MariaDB Driver
* Thymeleaf
* Lombok


## 테스트 데이터 프로시저 생성 코드
use board; (board스키마를 사용)

        DELIMITER $$
        CREATE PROCEDURE testDataInsert()
        BEGIN
            DECLARE i INT DEFAULT 1;

            WHILE i <= 120 DO
                INSERT INTO board(title, content)
                  VALUES(concat('제목',i), concat('내용',i));
                SET i = i + 1;
            END WHILE;
        END$$

call testDataInsert; (testDataInsert 테스트 데이터 불러오기)

