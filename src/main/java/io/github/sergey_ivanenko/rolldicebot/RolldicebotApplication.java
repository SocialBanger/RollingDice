package io.github.sergey_ivanenko.rolldicebot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class RolldicebotApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(RolldicebotApplication.class, args);
	}

}
