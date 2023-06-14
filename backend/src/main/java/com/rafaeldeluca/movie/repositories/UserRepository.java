package com.rafaeldeluca.movie.repositories;

import com.rafaeldeluca.movie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	//Buscar no dataBase por email
	User findByEmail(String email);

}
