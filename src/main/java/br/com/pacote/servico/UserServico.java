package br.com.pacote.servico;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import br.com.pacote.modelo.User;

@Service
public class UserServico {
	
	private  final static Logger logger = Logger.getLogger(UserServico.class);
	
	@Autowired
	private MongoOperations mongoOperations;
	
	public List<User> findAll() {
		logger.info("Buscando usuario na base");
		return this.mongoOperations.findAll(User.class);
	}
	
	public void save(User user) {
		logger.info("salvando novo usuario na base");
		this.mongoOperations.save(user);
	}

}
