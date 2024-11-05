//package com.forum.apigateway.controller;
//
//import com.portal.web.domain.service.*;
//import com.portal.web.domain.game.Game;
//import com.portal.web.domain.service.impl.AccountServiceJPA;
//import com.portal.web.domain.service.impl.CommentServiceJPA;
//import com.portal.web.domain.service.impl.RatingServiceJPA;
//import com.portal.web.domain.service.impl.ScoreServiceJPA;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Import;
//import org.springframework.context.annotation.Primary;
//import org.springframework.web.client.RestTemplate;
//import com.portal.web.domain.config.SecurityConfig;
//
//@SpringBootApplication
//@EntityScan("com.portal.web.domain.entity")
//@Import(SecurityConfig.class)
//public class GameStudioServer {
//    public static void main(String[] args) {
//        SpringApplication.run(GameStudioServer.class, args);
//    }
//
//    @Bean
//    @Primary
//    public UserService accountService() {
//        return new AccountServiceJPA();
//    }
//
//    @Bean
//    public ScoreService scoreService() {
//        return new ScoreServiceJPA();
////        return new ScoreServiceRestClient();
//
//    }
//    @Bean
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
//
//
//    @Bean
//    public RatingService ratingService() {
//        return new RatingServiceJPA();
//    }
//
//    @Bean
//    public CommentService commentService() {
//        return new CommentServiceJPA();
//    }
//
//    @Bean
//    public Game gamer() {
//        return new Game();
//    }
//
//
//}