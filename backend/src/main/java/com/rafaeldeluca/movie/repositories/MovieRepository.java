package com.rafaeldeluca.movie.repositories;

import com.rafaeldeluca.movie.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
