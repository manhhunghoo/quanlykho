package com.example.quanlykhodemo.demo.database;

import com.example.quanlykhodemo.demo.models.Product;
import com.example.quanlykhodemo.demo.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase (ProductRepository productRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product productA= new Product("001","Meceses",2.0,"HaNoi",20);
                Product productB= new Product("002","Toyota",1.0,"DaNang", 30);
                logger.info("insert data:"+productRepository.save(productA));
                logger.info("insert data:"+productRepository.save(productB));
            }
        };
    }
}
