package br.com.pacote.repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.pacote.modelo.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String>{
	
	Optional<User> findUserByUserNameAndPassword(String userName, String password);
	Optional<User> findUserByUserName(String userName);
}
