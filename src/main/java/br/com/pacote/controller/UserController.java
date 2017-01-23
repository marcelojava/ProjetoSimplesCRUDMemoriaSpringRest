package br.com.pacote.controller;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> users = this.userServico.findAll();

		if (users.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<UserDTO> userDtos = users.stream().map(UserDTO::new).collect(toList());

		return new ResponseEntity<>(userDtos, HttpStatus.OK);
	}
}
