package br.com.pacote.servico;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import br.com.pacote.modelo.User;
import br.com.pacote.repositories.UserRepository;

@Service
public class UserServico {
	
	private  final static Logger logger = Logger.getLogger(UserServico.class);
	
	@Autowired
	private MongoOperations mongoOperations;
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(Pageable pageable) {
		logger.info("Buscando usuario na base");
		Page<User> page = this.repository.findAll(pageable);
		
		return page.getContent();
	}
	
	public void save(User user) {
		logger.info("salvando novo usuario na base");
		this.mongoOperations.save(user);
	}

}
