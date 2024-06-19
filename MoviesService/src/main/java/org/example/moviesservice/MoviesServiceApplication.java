package org.example.moviesservice;

import org.example.moviesservice.model.MovieBean;
import org.example.moviesservice.model.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoviesServiceApplication implements CommandLineRunner {

    @Autowired
    private MoviesRepository moviesRepository;

    public static void main(String[] args) {
        SpringApplication.run(MoviesServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        MovieBean movieBean = new MovieBean(null, "Inception", "2h15");

        moviesRepository.save(movieBean) ;

    }
}
