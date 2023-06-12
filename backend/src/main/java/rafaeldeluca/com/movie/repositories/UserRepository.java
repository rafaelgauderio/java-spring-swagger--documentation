package rafaeldeluca.com.movie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rafaeldeluca.com.movie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	//Buscar no dataBase por email
	User findByEmail(String email);

}
