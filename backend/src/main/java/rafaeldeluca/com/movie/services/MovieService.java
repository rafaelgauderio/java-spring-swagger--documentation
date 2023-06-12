package rafaeldeluca.com.movie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rafaeldeluca.com.movie.entities.Movie;
import rafaeldeluca.com.movie.entities.dto.MovieDTO;
import rafaeldeluca.com.movie.repositories.MovieRepository;

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

}
