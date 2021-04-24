//package com.Alish.midka.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import javax.sql.DataSource;
//
//@Configuration
//@ComponentScan("com.Alish.midka")
//
//@EnableJpaRepositories(basePackages = "com.Alish.midka.repository")
//public class SpringConfig {
//
//
//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://localhost:5433/todo_db");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("123456");
//
//        return dataSource;
//    }
//
//
////    @Bean
////    public JdbcTemplate jdbcTemplate(){
////        return new JdbcTemplate((dataSource()));
////    }
//
//}
