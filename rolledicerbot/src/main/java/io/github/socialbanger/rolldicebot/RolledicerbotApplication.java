package io.github.socialbanger.rolldicebot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class RolledicerbotApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(RolledicerbotApplication.class, args);
	}

}
