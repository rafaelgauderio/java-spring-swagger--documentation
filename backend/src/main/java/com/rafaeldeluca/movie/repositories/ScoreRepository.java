package com.rafaeldeluca.movie.repositories;

import com.rafaeldeluca.movie.entities.Score;
import com.rafaeldeluca.movie.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
