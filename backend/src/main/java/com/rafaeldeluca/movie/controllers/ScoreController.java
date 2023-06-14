package com.rafaeldeluca.movie.controllers;

import com.rafaeldeluca.movie.entities.dto.MovieDTO;
import com.rafaeldeluca.movie.entities.dto.ScoreDTO;
import com.rafaeldeluca.movie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
