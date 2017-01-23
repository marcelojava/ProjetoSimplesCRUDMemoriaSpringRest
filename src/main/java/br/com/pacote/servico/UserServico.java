package br.com.pacote.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import br.com.pacote.modelo.User;

@Service
public class UserServico {
	
	@Autowired
	private MongoOperations mongoOperations;
	
	public List<User> findAll() {
		return this.mongoOperations.findAll(User.class);
	}

}
