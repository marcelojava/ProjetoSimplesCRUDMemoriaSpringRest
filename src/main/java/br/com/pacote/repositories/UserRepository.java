package br.com.pacote.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.pacote.modelo.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String>{

}
