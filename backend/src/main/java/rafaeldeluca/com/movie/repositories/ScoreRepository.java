package rafaeldeluca.com.movie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rafaeldeluca.com.movie.entities.Score;
import rafaeldeluca.com.movie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
