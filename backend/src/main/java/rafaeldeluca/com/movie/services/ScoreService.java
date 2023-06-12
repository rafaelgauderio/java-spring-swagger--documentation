package rafaeldeluca.com.movie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rafaeldeluca.com.movie.entities.Movie;
import rafaeldeluca.com.movie.entities.Score;
import rafaeldeluca.com.movie.entities.User;
import rafaeldeluca.com.movie.entities.dto.MovieDTO;
import rafaeldeluca.com.movie.entities.dto.ScoreDTO;
import rafaeldeluca.com.movie.repositories.MovieRepository;
import rafaeldeluca.com.movie.repositories.ScoreRepository;
import rafaeldeluca.com.movie.repositories.UserRepository;

@Service
public class ScoreService {
	
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		
		User user = userRepository.findByEmail(dto.getEmail());
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		//lista de avaliações de um filme
		for(Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		double avg = sum/movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);		
	}
}
