package com.example.hotelproject;

import com.example.hotelproject.util.Animal;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HotelProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelProjectApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(@Qualifier("dog") Animal animal) {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                animal.bark();
            }
        };
    }

}
