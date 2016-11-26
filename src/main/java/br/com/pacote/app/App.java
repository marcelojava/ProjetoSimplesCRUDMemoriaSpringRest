package br.com.pacote.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.pacote")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
