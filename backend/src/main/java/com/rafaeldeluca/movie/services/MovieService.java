package com.rafaeldeluca.movie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaeldeluca.movie.entities.Movie;
import com.rafaeldeluca.movie.entities.dto.MovieDTO;
import com.rafaeldeluca.movie.repositories.MovieRepository;

// Regras de negócio ficam na camada de serviço
//Anotacao Service registra o MovieService como componente do sistema
@Service
public class MovieService {
	
	//Autowired gerencia a instanciacao das variaveis
	@Autowired
	private MovieRepository repository;
	
	//argumento para buscar paginado e não tudo tudo de uma vez do database
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		
		Page<Movie> result = repository.findAll(pageable);
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		return page;		
		
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Movie result = repository.findById(id).get();
		MovieDTO dto = new MovieDTO(result);
		return dto;
		
	}

	@Transactional(readOnly=false)
	public MovieDTO insert (MovieDTO dto) {
		Movie entity = dto.dtoToEntity();
		entity = repository.save(entity);
		return new MovieDTO(entity);
	}

	@Transactional(readOnly=false)
	public MovieDTO update(MovieDTO dto, Long id) {
		//Movie entity = repository.getReferenceById(id);
		Movie entity = repository.getById(id);
		updateMovieData(entity, dto);
		entity = repository.save(entity);
		return new MovieDTO(entity);
	}

	private void updateMovieData(Movie entity, MovieDTO dto) {
		entity.setTitle(dto.getTitle());
		entity.setScore(dto.getScore());
		entity.setImage(dto.getImage());
		entity.setCount(dto.getCount());
	}

	public void delete (Long id) {
		repository.deleteById(id);
	}

}
