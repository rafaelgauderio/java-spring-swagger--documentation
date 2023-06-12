package rafaeldeluca.com.movie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rafaeldeluca.com.movie.entities.dto.MovieDTO;
import rafaeldeluca.com.movie.entities.dto.ScoreDTO;
import rafaeldeluca.com.movie.services.ScoreService;

@RestController
@RequestMapping(value ="/scores")
public class ScoreController {
	
	@Autowired
	private ScoreService service;
	
	//put salvar de maneira indepotente ou atualizar
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
		MovieDTO movieDTO = service.saveScore(dto);
		return movieDTO;
	}

}
