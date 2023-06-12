package rafaeldeluca.com.movie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rafaeldeluca.com.movie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
