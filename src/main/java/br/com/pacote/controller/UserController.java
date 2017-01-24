package br.com.pacote.controller;

import static java.util.stream.Collectors.toList;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pacote.dto.UserDTO;
import br.com.pacote.modelo.User;
import br.com.pacote.servico.UserServico;

@RestController
public class UserController {

	@Autowired
	private UserServico userServico;

	@RequestMapping(value = "user", method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(Pageable pageable) {
		
		List<User> users = this.userServico.findAll(pageable);
		
		if (users.isEmpty()) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(users.stream().
				map(UserDTO::new).collect(toList()), HttpStatus.OK);
	}
	
	@RequestMapping(value = "user", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody User user) {
		this.userServico.save(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "user/{username}/{password}")
	public UserDTO findUser(@PathVariable("username") String userName,
			@PathVariable("password") String passWord,
			HttpServletResponse httpServletResponse) {
		return this.userServico.findUser(userName, passWord)
				.map(UserDTO::new)
				.orElseGet(() -> {httpServletResponse.setStatus(404); return null;});
	}
}
