package org.example.moviesservice.model.repository;

import org.example.moviesservice.model.MovieBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "movies")
public interface MoviesRepository extends JpaRepository<MovieBean, String> {

}


