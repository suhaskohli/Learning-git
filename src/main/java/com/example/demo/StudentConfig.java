package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(HomeRepository homeRepository){
        return args->{
            Student mariam = new Student("Mariam", "Mariam6767@gmail.com",
                    LocalDate.of(2004, Month.FEBRUARY,20));

            Student alexa = new Student("Alexa", "alexisforu989@gmail.com",
                    LocalDate.of(1998, Month.JULY,11));
            homeRepository.saveAll(List.of(mariam,alexa));
        };

    }
}
