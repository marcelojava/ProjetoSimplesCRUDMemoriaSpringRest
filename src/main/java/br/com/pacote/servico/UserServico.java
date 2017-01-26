package br.com.pacote.servico;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.pacote.modelo.User;
import br.com.pacote.repositories.UserRepository;

@Service
public class UserServico {
	
	private  final static Logger logger = Logger.getLogger(UserServico.class);
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(Pageable pageable) {
		logger.info("Buscando usuario na base");
		Page<User> page = this.repository.findAll(pageable);
		
		return page.getContent();
	}

	public Optional<User> findUser(String userName, String password) {
		logger.info("buscando usuario pelo username e password");
		return this.repository.findUserByUserNameAndPassword(userName, password);
	}
	
	public Map<String, Boolean> findUserByUserName(String userName) {
		logger.info("verificando se existe algum usuario com o mesmo login");
		Map<String, Boolean> mapa = new HashMap<>();
		boolean isExisteUser = this.repository.findUserByUserName(userName).isPresent();
		mapa.put("existeUsuario", isExisteUser);
		return mapa;
	}

	public void save(User user) {
		logger.info("salvando novo usuario na base");
		this.repository.save(user);
	}
}
